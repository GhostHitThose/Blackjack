package me.maxrenner.blackjack.game.cards;

public enum Suit {
    HEARTS("Hearts", '❤', 'H'), CLUBS("Clubs", '♣', 'C'), DIAMONDS("Diamonds", '♦', 'D'), SPADES("Spades", '♠', 'S');

    private final String name;
    private final char symbol;
    private final char label;

    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
    public char getLabel() {
        return label;
    }

    Suit(String name, char symbol, char label){
        this.name = name;
        this.symbol = symbol;
        this.label = label;
    }
}
