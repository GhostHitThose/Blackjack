package me.maxrenner.blackjack.game.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> deck;
    private int currentCard, numDecks, resetThreshold;

    public Deck() {
        this(5);
    }

    public Deck(int numDecks){
        deck = new ArrayList<>();
        currentCard = 0;
        this.numDecks = numDecks;
        resetThreshold = 20;
    }

    public void buildDecks() {
        for(int i = 0; i < numDecks; i++){
            for(int j = 0; j < 13; j++){
                Rank rank = Rank.values()[j];

                for(int k = 0; k < 4; k++){
                    deck.add(new Card(rank, Suit.values()[k]));
                }
            }
        }
    }

    public void shuffleDeck() {
        shuffleDeck(1);
    }

    public void shuffleDeck(int times){
        for(int i = 0; i < times; i++){
            Collections.shuffle(deck);
        }
    }

    public int getNumDecks(){
        return numDecks;
    }
    public int getCurrentCard(){
        return currentCard;
    }
    public ArrayList<Card> getDeck(){
        return deck;
    }

    public Card drawCard(){
        return deck.get(currentCard++);
    }

    public boolean resetDeck(){
        if(currentCard > (numDecks*52 - resetThreshold)){
            currentCard = 0;
            shuffleDeck(7);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(Card card : deck){
            sb.append(deck.indexOf(card)).append(": ").append(card.getRankName()).append(" of ").append(card.getSuitName()).append(" ");
        }

        return sb.toString();
    }
}
