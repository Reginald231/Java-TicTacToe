package ticTacToeTesting;

import java.util.Scanner;

public class commandLineTicTacToe {
    private static char humanPiece = ' ';//Human can be X or O.
    private static char cpuPiece = ' ';//Computer must be opposing piece when compared to the human's piece.
    private static boolean sentinelFlag = false;//If true, then an incorrect value has been entered.
    private static char[] piecePosition = new char[9];//Tic Tac Toe pieces
    private static final String INSTRUCTIONS = "The instructions are simple. \nTry your best to place your pieces in a" +
            "row of three, either horizontally, vertically, or diagonally." +
            "\nYour opponent, the computer, will try to do the same. If you place your pieces in a row of three, " +
            "you win.";

    public static void main (String[] args) {
       // go(); Opens console.
        String startUpString = "This is a command line test program to simulate a basic tic tac toe game between the computer and the human player.";

        String beginningHeader = makeBorder(startUpString);
        System.out.println(beginningHeader);
        choosePiece();
        System.out.println("Enter your name: ");

        Scanner scan = new Scanner(System.in);
        String humanName = scan.next();
        human player = new human(humanName, humanPiece);

        if(humanPiece == 'X')
            cpuPiece = 'O';
        else
            cpuPiece = 'X';

        human h = new human(humanName, humanPiece);
        computer c = new computer(cpuPiece);
        gBoard board = new gBoard(h,c);
        System.out.println("\n\n\nYour game piece is '" + humanPiece +
                "'\nThe computer's game piece is '" + cpuPiece + "'");
        board.coinToss();//flipping coin to decide turn.
        board.nextTurn();
        System.out.println("I hope you enjoyed the game. Goodbye!");
    }

    //Makes a border of '=' above and below a target
    private static String makeBorder(String target){
        StringBuilder border = new StringBuilder();
        for(int i = 0; i < target.length(); i++){
        border.append("=");
        }

        return (border+"\n"+target+"\n"+ INSTRUCTIONS + "\n" + border);
    }


    public static void choosePiece(){
        System.out.println("Which piece will you use? (Enter X or O then press return.)");
        Scanner scan = new Scanner(System.in);
        humanPiece = Character.toUpperCase((scan.next().charAt(0)));

        if (humanPiece != 'X' && humanPiece != 'O')
            sentinelFlag = true;

        while (sentinelFlag) {
                System.out.println("*You entered an invalid parameter. Your piece must be an X or O. Enter a piece, then press 'Return.'");
                humanPiece = Character.toUpperCase(scan.next().charAt(0));
                if (humanPiece == 'X' || humanPiece == 'O')
                    sentinelFlag = false;
        }
    }
}
