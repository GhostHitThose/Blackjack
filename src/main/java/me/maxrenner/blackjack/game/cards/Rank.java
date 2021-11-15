package me.maxrenner.blackjack.game.cards;

public enum Rank {
    ACE     (1," A", "Ace"),
    TWO     (2, " 2", "2"),
    THREE   (3, " 3", "3"),
    FOUR    (4, " 4", "4"),
    FIVE    (5, " 5", "5"),
    SIX     (6, " 6", "6"),
    SEVEN   (7, " 7", "7"),
    EIGHT   (8, " 8", "8"),
    NINE    (9, " 9", "9"),
    TEN     (10, "10", "10"),
    JACK    (11, "J", "Jack"),
    QUEEN   (12, "Q", "Queen"),
    KING    (13, "K", "King");

    private int value;
    private final String label;
    private final String name;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public String getLabel() {
        return label;
    }
    public String getName() {
        return name;
    }

    Rank(int value, String label, String name){
        this.value = value;
        this.label = label;
        this.name = name;
    }
}
