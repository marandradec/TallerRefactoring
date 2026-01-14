package com.badsmells;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private final Map<Class<? extends Choice>, Map<Class<? extends Choice>, Result>> rules = new HashMap<>();

    public Logic() {
        initRules();
    }

    public void initRules() {
        addRule(Rock.class, Scissor.class, Result.WIN);
        addRule(Rock.class, Paper.class, Result.LOSE);

        addRule(Paper.class, Rock.class, Result.WIN);
        addRule(Paper.class, Scissor.class, Result.LOSE);

        addRule(Scissor.class, Paper.class, Result.WIN);
        addRule(Scissor.class, Rock.class, Result.LOSE);
    }

    public static void player1Wins(Player p1){
        System.out.println("Player 1 Wins");
        p1.setWins();
    }

    public static void player2Wins(Player p2){
        System.out.println("Player 2 Wins");
        p2.setWins();
    }

    public void draw(){
        RPMGame.updateDraw();
        System.out.println("\n\t\t\t Draw \n");
    }

    public static void isTheGameEnd(Player p1, Player p2){
        final boolean p1Win= p1.getWins() >= RPMGame.winsToWin;
        final boolean p2Win = p2.getWins() >= RPMGame.winsToWin;

        if (p1Win || p2Win){
            RPMGame.updateFlag();
            System.out.println("GAME WON");

            if (p1.getWins() > p2.getWins()){
            player1Wins(p1);
            } else if (p2.getWins() > p1.getWins()){
                player2Wins(p2);
            }
        }

        System.out.println();
    }

    private void addRule(Class<? extends Choice> c1, Class<? extends Choice> c2, Result result) {
        if (!rules.containsKey(c1)) {
            rules.put(c1, new HashMap<>());
        }
        rules.get(c1).put(c2, result);
    }

    public Result decideResult(Choice c1, Choice c2) {
        if (c1.getClass().equals(c2.getClass())) {
            return Result.DRAW;
        }
        return rules.get(c1.getClass()).get(c2.getClass());
    }
}
