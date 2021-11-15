package me.maxrenner.blackjack.game.players;

import lombok.Getter;
import lombok.Setter;
import me.maxrenner.blackjack.game.cards.Card;
import me.maxrenner.blackjack.game.cards.Hand;

public abstract class BlackjackPlayer {
    @Getter @Setter private int score;
    @Getter @Setter private Hand hand;
    @Getter @Setter private String name;
    @Getter private boolean stood = false;

    public void hit(Card card){
        this.sendMessage(name + " hit.");
        hand.addToHand(card);
    }

    public void stand(){
        this.sendMessage(name + " stood.");
        this.stood = true;
    }

    public void sendMessage(String msg){
        System.out.println(msg);
    }
}
