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
        System.out.println();
        for(int i = 0; i < this.FIELD_LENGTH; i++){
            this.printRow(i);
        }
        System.out.println();
    }

    public void printRow(int row) {
        for(int i = 0; i < this.FIELD_LENGTH; i++){
            System.out.print("[" + this.field[row][i] + "]");
        }
        System.out.println();
    }

    public boolean isFinished(){
        if(checkDiagonal()){
            return true;
        }
        for(int i = 0; i < this.FIELD_LENGTH; i++) {
            if(this.checkColumn(i) || this.checkRow(i)){
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row) {
        if(this.field[row][0] == this.field[row][1] &&
                this.field[row][1] == this.field[row][2] &&
                this.field[row][1] != ' '){
            return true;
        }
        return  false;
    }

    private boolean checkColumn(int column) {
        if(this.field[0][column] == this.field[1][column] &&
                this.field[1][column] == this.field[2][column] &&
                this.field[1][column] != ' '){
            return true;
        }
        return  false;
    }

    private boolean checkDiagonal() {
        if(this.field[0][0] == this.field[1][1]
                && this.field[1][1] == this.field[2][2] && this.field[1][1] != ' '){
            return true;
        }
        else if(this.field[0][2] == this.field[1][1]
                && this.field[1][1] == this.field[2][0] && this.field[1][1] != ' ') {
            return true;
        }
        return false;
    }

    public void changeCellState(int x, int y, char sign) {
        this.field[x][y] = sign;
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
