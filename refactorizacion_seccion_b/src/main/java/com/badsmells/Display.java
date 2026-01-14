package com.badsmells;

public class Display {

    public static void printDetail(Player p1, Player p2){
        System.out.println("******** ROUND: "+ RPMGame.roundsPlayed + "********** \n");
        System.out.println("Number of draws: "+ RPMGame.draws + "\n");
        System.out.println("Player 1: "+ p1.getChoice().name() + "\t Player 1 Total Wins: "+ p1.getWins());
        System.out.println("Player 2: "+ p2.getChoice().name() + "\t Player 2 Total Wins: "+ p2.getWins());
    }

}
