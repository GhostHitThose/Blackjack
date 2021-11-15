package me.maxrenner.blackjack.game.cards;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }
    public Hand addToHand(Card card) {
        hand.add(card);

        return this;
    }
    public void clearHand(){
        hand.clear();
    }

    public int getTotal(){
        int total = 0;
        for(Card card : hand){
            total+=card.getValue();
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(Card card : hand){
            sb.append(card.getRankLabel());
            sb.append(card.getSuitLabel());
            sb.append("  ");
        }

        return sb.toString().trim();
    }
}
