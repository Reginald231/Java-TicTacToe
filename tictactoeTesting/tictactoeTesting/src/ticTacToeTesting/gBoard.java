package ticTacToeTesting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class gBoard {
    private static human h;
    private static computer cpu;
    private static char[][] piecePositions = new char[3][3];//Will hold all piece locations of the pieces.
    private static boolean humanTurn = true;//The human player will get to go first.
    private static StringBuilder gameBoard = new StringBuilder();//This will be used for making the game board.
    public static Random rand = new Random();
    public static Scanner scan = new Scanner(System.in);
    public static boolean sentinelFlag = false;

    public gBoard(human a, computer cpu) {
        this.h = a;
        this.cpu = cpu;
        for (int i = 0; i < piecePositions.length; i++)
            for(int j = 0; ; < piecePositions[i].length; j++)
                piecePositions[i][j] = '_';
    }

    public static String makeBoard() {
        for (int i = 0; i < piecePositions.length; i++) {
            gameBoard.append("[" + piecePositions[i] + "]\t\t");
            if(((i+1) % 3) == 0)
            gameBoard.append("\n");
        }
        return gameBoard.toString();
    }
    public static void coinToss(){//Finding out who goes first: computer or human player.
        int coin = rand.nextInt(2);//returning a value of zero or one. One represents human. Zero represents computer.
        if(coin == 0) {
            System.out.println(h.getName() + ", you go first.");
            humanTurn = true;
        }else{
                System.out.println("The computer will go first.");
                humanTurn = false;
        }
    }
    public static void placePiece(int target){
        if(piecePositions[target] == '_'|| piecePositions[target] == h.getPiece()){
            sentinelFlag = true;
            while(sentinelFlag){
                System.out.println("There is already a piece in this location. Please choose another location: ");
                target = scan.nextInt();
                if(!(piecePositions[target] == '_'|| piecePositions[target] == h.getPiece()))
                    sentinelFlag = false;
            }
            piecePositions[target] = h.getPiece();
        }
   public static void placePieceCPU(){

            int target = rand.nextInt(10);
            if(piecePositions[target] == '_'|| piecePositions[target] == h.getPiece()){
                sentinelFlag = true;
                while(sentinelFlag){
                    target = rand.nextInt(10);
                    if(!(piecePositions[target] == '_'|| piecePositions[target] == h.getPiece()))
                        sentinelFlag = false;
                }
                piecePositions[target] = cpu.getPiece();
        }
    }
        public static void checkBoard(){//looks for winning plays in the board. Using a winning flag for this case.

        }

        public static void checkLeft(int pos, char piece){ //Checks to the left of a chosen target for two more matching pieces (X or O).
            int matchCount = 0; // Needs to reach two for a winning row.
            for(int i = 2; i >= 0 ; i--){//we only need two more matches. Before this method runs, the chosen position should be filled.

            }
        }
}

