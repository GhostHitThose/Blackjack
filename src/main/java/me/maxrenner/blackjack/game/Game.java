package me.maxrenner.blackjack.game;

import me.maxrenner.blackjack.game.cards.Deck;
import me.maxrenner.blackjack.game.cards.Hand;
import me.maxrenner.blackjack.game.cards.Rank;
import me.maxrenner.blackjack.game.players.Dealer;
import me.maxrenner.blackjack.game.players.Player;

import java.util.Scanner;

public class Game implements Runnable {

    private Dealer dealer;
    private Player player;
    private Deck deck;
    private GameState gameState;

    public enum GameState {
        SETUP,
        RUNNING,
        RESET
    }

    @Override
    public void run(){
        // blackjack.start -> create deck, shuffle deck, start game loop

        if(player == null || dealer == null) initGame();

        Scanner sc = new Scanner(System.in);
        while(true){
            switch(gameState) {
                case SETUP:
                    initGame();
                    break;
                case RESET:
                    System.out.println("Would you like to play again?[Yes(Y) or No(N)]");
                    String playAgain = sc.nextLine();

                    if(playAgain.toUpperCase().charAt(0) == 'Y'){
                        initGame();
                    } else {
                        this.end();
                    }
                    break;
                case RUNNING:
                    System.out.println(player.getName() + "'s hand: " + player.getHand().toString() + "\n" + player.getName() + "'s total score: " + player.getHand().getTotal() + "\nWhat is your move?[Hit(H), Stand(S), Double(D), Exit(E)]");
                    String action = sc.nextLine();
                    if (action.length() == 0) break;
                    if(!player.isStood()) {
                        switch (action.toUpperCase().charAt(0)) {
                            case 'H':
                                player.hit(deck.drawCard());
                                System.out.println(dealer.getName() + "'s total: " + dealer.getHand().getTotal());
                                if (player.getHand().getTotal() == 21) {
                                    player.sendMessage(player.getName() + " wins!");
                                    gameState = GameState.RESET;
                                    continue;
                                } else if (player.getHand().getTotal() > 21) {
                                    player.sendMessage(player.getName() + " busted!");
                                    player.sendMessage(dealer.getName() + " wins!");
                                    gameState = GameState.RESET;
                                    continue;
                                }
                                break;
                            case 'S':
                                player.stand();
                                break;
                            case 'D':
                                player.doubleDown();
                                break;
                            case 'E':
                                this.end();
                            default:
                                System.out.println("Enter a proper value.");
                        }
                    }

                    if(!dealer.isStood()) {
                        if (dealer.getHand().getTotal() < 17) {
                            dealer.hit(deck.drawCard());
                            System.out.println(dealer.getHand());
                            if (dealer.getHand().getTotal() == 21) {
                                dealer.sendMessage(dealer.getName() + " wins!");
                                gameState = GameState.RESET;
                                break;
                            } else if (dealer.getHand().getTotal() > 21) {
                                dealer.sendMessage(dealer.getName() + " busted!");
                                player.sendMessage(player.getName() + " wins!");
                                gameState = GameState.RESET;
                                break;
                            }
                        } else {
                            dealer.stand();
                        }
                    }

                    if(player.isStood() && dealer.isStood()){
                        if(player.getHand().getTotal() > dealer.getHand().getTotal()){
                            player.sendMessage(player.getName() + " wins!");
                        } else {
                            player.sendMessage(dealer.getName() + " wins!");
                        }

                        gameState = GameState.RESET;

                        continue;
                    }
                    break;
            }
        }
    }

    private void initGame(){
        gameState = GameState.SETUP;
        Player player = new Player();
        Dealer dealer = new Dealer();

        deck = new Deck();
        deck.buildDecks();
        deck.shuffleDeck();

        player.setHand(new Hand());
        dealer.setHand(new Hand());
        gameState = GameState.RUNNING;

        player.getHand().addToHand(deck.drawCard()).addToHand(deck.drawCard());
        dealer.getHand().addToHand(deck.drawCard()).addToHand(deck.drawCard());
        Rank.JACK.setValue(10);
        Rank.QUEEN.setValue(10);
        Rank.KING.setValue(10);

        player.setName("Player");
        this.dealer = dealer;
        this.player = player;
    }

    public void end(){
        System.exit(0);
    }
}
