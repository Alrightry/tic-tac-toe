package com.tictactoe.game;

import java.util.Scanner;

public class Player {

    private static final int possibleSteps[][] = {{2,0},{2,1},{2,2},{1,0},
            {1,1},{1,2},{0,0},{0,1},{0,2}};

    private final char type;
    private Field field;
    private Scanner scan;

    public Player(char type, Field field) {
        this.type = type;
        this.field = field;
        scan = new Scanner(System.in);
    }

    public char getType() {
        return this.type;
    }

    public void act() {
        proceedInput(getInput());
    }

    private int getInput() {
        System.out.print("Step of player-" + this.type + ": ");
        return Integer.parseInt(scan.nextLine());
    }

    private void proceedInput(int input) {
        int step[] = possibleSteps[input - 1];
        this.field.changeCellState(step[0], step[1], this.type);
    }

}
