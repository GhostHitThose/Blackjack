package me.maxrenner.blackjack;

import me.maxrenner.blackjack.game.Game;

// IMPORTANT
// !THIS IS A SINGLETON CLASS!
public class Blackjack {
    private static Blackjack blackjack;

    public static Blackjack getInstance() {
        if(blackjack == null) blackjack = new Blackjack();

        return blackjack;
    }

    private Blackjack(){
        System.out.println("+----------------------+");
        System.out.println("| Welcome To Blackjack |");
        System.out.println("+----------------------+");

        this.start();
    }

    private void start() {
        Thread thread = new Thread(new Game());
        thread.start();
    }
}
