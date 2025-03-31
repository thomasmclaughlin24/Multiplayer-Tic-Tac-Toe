import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameBoard  extends JPanel {
    public static String[][] board = new String[3][3];
    public static int turnNumber = 1;
    public static String playerTurn = "X";
    public static Random random = new Random();

    public static void fillBoard(){
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board.length; j++) {
                board[i][j] = " ";
                System.out.print(board[i][j]);
            }
        }
    }

    public static void drawBoard(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(50, 250, 750, 250);
        g2d.drawLine(50, 550, 750, 550);
        g2d.drawLine(250, 50, 250, 750);
        g2d.drawLine(550, 50, 550, 750);
    }

    public static void printBoard(){
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board.length; j++){
                System.out.print(board[j][i] + ",");
            }
            System.out.println();
        }
    }

    public static void AddXorOLocalMultiplayer(int row, int col){
        if (turnNumber % 2 != 0){
            playerTurn = "X";
        }
        else{
            playerTurn = "O";
        }
        board[row][col] = playerTurn;
        turnNumber++;
        CheckWin(playerTurn);
    }

    public static void AddXorOBot(int row, int col){
        board[row][col] = "X";
        PlaceToken();
    }

    public static void PlaceToken(){
        int rand_row = random.nextInt(0,3);
        int rand_col = random.nextInt(0,3);
        while(!(board[rand_row][rand_col]).equals(" ")){
            rand_row = random.nextInt(0,3);
            rand_col = random.nextInt(0,3);
        }
    }

    private static int tokenCounter = 0;
    public static void CheckWin(String playerTurn) {
        for (int i = 0; i < board.length; i++) {
            tokenCounter = 0;
            for (int j = 0; j < board.length; j++) {
                CheckWinHelper(i, j);
            }
            tokenCounter = 0;
            for (int j = 0; j < board.length; j++) {
                CheckWinHelper(j, i);
            }
            tokenCounter = 0;
            for (int j = 0; j < board.length; j++) {
                if (CheckWinHelper(j, j)) {
                    return;
                }
            }
        }

        if((board[0][0] == playerTurn && board[1][1] == playerTurn && board[2][2] == playerTurn) || (board[0][2] == playerTurn && board[1][1] == playerTurn && board[2][0] == playerTurn)){
            System.out.println("Game won! by " + playerTurn);
        }
    }

    private static boolean CheckWinHelper(int i, int j){
        if (board[i][j].equals(playerTurn)){
            tokenCounter++;
        }
        if (tokenCounter == 3){
            System.out.println("Game won! by " + playerTurn);
            return true;
        }
        return false;
    }
    // protected void pai
}
