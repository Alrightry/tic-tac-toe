package com.tictactoe.game;

public class Field {

    private static final char DEFAULT_SIGN = ' ';

    private final int FIELD_LENGTH;

    private char field[][];

    public Field() {
        this(3);
    }

    public Field(int length) {
        this.FIELD_LENGTH = length;
        field = new char[FIELD_LENGTH][FIELD_LENGTH];
        this.eraseField();
    }

    public int getFieldLength() {
        return FIELD_LENGTH;
    }

    public void printField() {
        for(int i = 0; i < this.FIELD_LENGTH; i++){
            this.printRow(i);
        }
    }

    public void printRow(int row) {
        for(int i = 0; i < this.FIELD_LENGTH; i++){
            System.out.print("[" + this.field[row][i] + "]");
        }
        System.out.println();
    }

    public void eraseField() {
        for(int i = 0; i < this.FIELD_LENGTH; i++) {
            this.eraseRow(i);
        }
    }

    public void eraseRow(int row) {
        for(int i = 0; i < this.FIELD_LENGTH; i++) {
            this.field[row][i] = DEFAULT_SIGN;
        }
    }

}
