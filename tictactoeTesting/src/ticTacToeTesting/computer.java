package ticTacToeTesting;

public class computer {
    private char piece;
    private int wins = 0;

    public computer(char piece){ this.piece = piece; }
    public int getWins(){
        return wins;
    }

    public char getPiece(){
        return piece;
    }
}
