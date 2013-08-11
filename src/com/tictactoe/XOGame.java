package com.tictactoe;

import java.util.Scanner;

import com.tictactoe.game.Field;
import com.tictactoe.game.Player;

public class XOGame {

    private Field field;
    private Player players[];

    public XOGame(){
        field = new Field();
        players = new Player[2];
        players[0] = new Player('X', field);
        players[1] = new Player('0', field);
        showGreetings();
    }

    public void startGame(){
        field.eraseField();
        gameMenu();
    }

    private void gameMenu() {
        showMenu();
        int choice = menuInput();
        if(choice == 1) {
            playerAgainstPlayer();
        } else if(choice == 2) {
            System.exit(0);
        }
    }

    private void playerAgainstPlayer() {
        System.out.println("Starting the game...");
        this.field.printField();
        for(int i = 0; i < 8; i++) {
            players[i % 2].act();
            this.field.printField();
            if(this.field.isFinished()) {
                System.out.println("Player-" + players[i % 2].getType() + " won.");
                return;
            }
        }
        players[0].act();
        this.field.printField();
        if(!this.field.isFinished()) {
            System.out.println("Draw.");
        } else {
            System.out.println("Player-" + players[0].getType() + " won.");
        }
    }

    private int menuInput() {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }

    private void showMenu() {
        System.out.println("1-New game(2 players)");
        System.out.println("2-Exit");
        System.out.println();
        System.out.print("Choice: ");
    }

    private void showGreetings() {
        System.out.println("    ***********************");
        System.out.println("    ******Tic-Tac-Toe******");
        System.out.println("    ***********************");
        System.out.println();
    }

}
