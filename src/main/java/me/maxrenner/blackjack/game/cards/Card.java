package me.maxrenner.blackjack.game.cards;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }
    public int getValue() {
        return rank.getValue();
    }
    public void setValue(int value){
        this.rank.setValue(value);
    }
    public String getRankLabel() {
        return rank.getLabel();
    }
    public String getRankName() {
        return rank.getName();
    }

    public Suit getSuit() {
        return suit;
    }
    public String getSuitName() {
        return suit.getName();
    }
    public char getSuitSymbol() {
        return suit.getSymbol();
    }
    public char getSuitLabel(){
        return suit.getLabel();
    }

    @Override
    public String toString() {
        return getRankLabel() + " " + getSuitLabel();
    }
}
