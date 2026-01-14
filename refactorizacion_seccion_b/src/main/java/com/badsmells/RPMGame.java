package com.badsmells;

public class RPMGame {

    private final Logic logic = new Logic();
    private Player p1 = new Player();
    private Player p2 = new Player();
    public static int roundsPlayed = 0;
    public static int draws = 0;
    public static boolean gameWon = false;

    public static final int winsToWin = 3; 
    
    public void play(){

        logic.initRules();

        do{
            p1.makeChoice();
            p2.makeChoice();

            Display.printDetail(p1, p2);
            roundsPlayed++;

            Result result = logic.decideResult(p1.getChoice(), p2.getChoice());

            switch (result) {
                case WIN -> p1.addWin();
                case LOSE -> p2.addWin();
                case DRAW -> logic.draw();
            }

            Logic.isTheGameEnd(p1, p2);

        } while(!gameWon);
    }
    
    public static void updateDraw(){
        draws++;
    }

    public static void updateFlag(){
        gameWon = true;
    }

    public static void main(String[] args) {
        RPMGame game = new RPMGame();
        game.play();
    }
}