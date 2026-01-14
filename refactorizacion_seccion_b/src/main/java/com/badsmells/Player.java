package com.badsmells;

import java.util.List;
import java.util.Random;

public class Player {

    private static final List<Choice> CHOICES = List.of(new Rock(), new Paper(), new Scissor());
    private int wins;
    private int winTotal;
    private Choice choice;
    
    public void makeChoice(){
        Random rnd = new Random();
        Choice c = CHOICES.get(rnd.nextInt(CHOICES.size()));
        setChoice(c);
    }
    
    public void setWins(){
        winTotal += wins;
    }

    public int addWin(){
        return wins++;
    }

    public int getWins(){
        return wins;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
    
}
