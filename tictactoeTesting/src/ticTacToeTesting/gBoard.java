package ticTacToeTesting;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/**
 * @author Reginald Long
 */
public class gBoard {
    private static human h;
    private static computer cpu;
    private static char[][] piecePositions = new char[3][3];//Will hold all piece locations of the pieces.
    private static boolean humanTurn = true;//The human player will get to go first.
    private static StringBuilder gameBoard = new StringBuilder();//This will be used for making the game board.
    private static Random rand = new Random();
    private static Scanner scan = new Scanner(System.in);
    private static boolean sentinelFlag = false;//Used for identifying when the user makes a mistake.
    public static int placedPieces; //Number of pieces currently on the board.

    /**
     *
     * @param hu An instance of a human player
     * @param cpu An instance of a computer player
     */
    public gBoard(human hu, computer cpu) {
        this.h = hu;
        this.cpu = cpu;
        for (int i = 0; i < piecePositions.length; i++) {
            for (int j = 0; j < piecePositions[i].length; j++){
                piecePositions[i][j] = '_';
            }
        }
    }

    /**
     * Creates a string representation of the game board.
     * @return A string representation of a game board.
     */
    public static String makeBoard() {
//        for (int i = 0; i < piecePositions.length; i++) {
//            gameBoard.append("[" + piecePositions[i] + "]\t\t");
//            if(((i+1) % 3) == 0)
//            gameBoard.append("\n");
//        }

        for(int i = 0; i < piecePositions.length; i++){
            for(int j = 0; j < piecePositions[i].length; j++){
                gameBoard.append("[" + piecePositions[i][j] + "]\t\t");
            }
            gameBoard.append("\n\n");
        }
        gameBoard.append("\n\n\n");
        return gameBoard.toString();
    }
    /**
     * Decides who goes firsts and prints the result.
     */

    public static void coinToss(){
        int coin = rand.nextInt(2);//giving a value of zero or one. One represents human. Zero represents computer.
        if(coin == 0) {
            System.out.println(h.getName() + ", you go first.");
            humanTurn = true;
        }else{
                System.out.println("The computer will go first.");
                humanTurn = false;
                placePiece();
        }
    }

    /**
     * An overloaded method of placePiece() that places the human's playing piece.
     * @param targetX The row position for the player's piece.
     * @param targetY The column position for the player's piece.
     */
    public static void placePiece(int targetX, int targetY) {
        if (piecePositions[targetX][targetY] == cpu.getPiece() || piecePositions[targetX][targetY] == h.getPiece()) {
            sentinelFlag = true;

            while (sentinelFlag) {
                System.out.println("There is already a piece in this location. Please choose another location: ");
                targetX = scan.nextInt();
                targetY = scan.nextInt();
                if (!(piecePositions[targetX][targetY] == cpu.getPiece() || piecePositions[targetX][targetY] == h.getPiece()))
                    sentinelFlag = false;
            }

            piecePositions[targetX][targetY] = h.getPiece();
        }
    }

        /**
         * A method for the computer. Uses an instance of Random to determine where to place a piece.
         */
        public static void placePiece(){

            int targetX = rand.nextInt(3);
            int targetY = rand.nextInt(3);
            if(piecePositions[targetX][targetY] == '_'|| piecePositions[targetX][targetY] == h.getPiece()){
                sentinelFlag = true;
                while(sentinelFlag){
                    targetX = rand.nextInt(3);
                    targetY = rand.nextInt(3);
                    if(!(piecePositions[targetX][targetY] == '_'|| piecePositions[targetX][targetY] == h.getPiece()))
                        sentinelFlag = false;
                }
                piecePositions[targetX][targetY] = cpu.getPiece();
        }
    }

        public static void nextTurn(){
            if(!humanTurn){
                placePiece();
                System.out.println("\nThe computer has made its move.");
                humanTurn = true;
                System.out.println(makeBoard());
            }
            else{
                System.out.println("It's your turn. Where do you want to place your piece? " +
                        "Enter the row number and the column number.");

                //Implement error handling in future development for these values....
                    int x = scan.nextInt();
                    int y = scan.nextInt();

                    placePiece(x,y);
                    System.out.println(makeBoard());
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

