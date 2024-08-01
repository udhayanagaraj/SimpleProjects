package SnakeLadder;

public class Dice {
    public static int rollDice(){
        return 1 + (int)(Math.random() * 100) % 5;
    }
}
