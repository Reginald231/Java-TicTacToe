package ticTacToeTesting;

public class human {
    private char piece = ' ';
    private int wins = 0;
    private String name = " ";

    public human(String name, char piece){
        this.name = name;
        this.piece = piece;
    }
    public char getPiece(){
        return piece;
    }

    public String getName(){
        return name;
    }
    public int getWins(){
        return wins;
    }
}

