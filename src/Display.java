import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display {
    static File x_file = new File("src/x image.png");
    static File o_file = new File("src/o image.png");
    static BufferedImage x_image = null;
    static BufferedImage o_image = null;
    static GameMode mode = new GameMode();

    public static void DisplayXandO(Graphics g) throws IOException {
        x_image = ImageIO.read(x_file);
        o_image = ImageIO.read(o_file);
        for(int i=0; i < GameBoard.board.length; i++) {
            for (int j = 0; j < GameBoard.board.length; j++) {
                if (GameBoard.board[j][i].equals("X")){
                    g.drawImage(x_image, j*300, i*300, 150, 150, null);
                }
                else if (GameBoard.board[j][i].equals("O")){
                    g.drawImage(o_image, j*300, i*300, 150, 150, null);
                }
            }
        }
    }

    public static void DisplayWindow() {
        JFrame frame = new JFrame("Game Board");
        frame.setSize(800, 850);
        frame.setVisible(true);
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    if (mode.getMode().equals("Main Menu")) {
                        Menu.DrawMainMenu(g);
                    }
                    if (mode.getMode().equals("Play")){
                        GameBoard.drawBoard(g);
                        DisplayXandO(g);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //GameBoard.drawBoard(g);
                //DisplayXandO(g);
            }
        };
        frame.add(panel);
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + ", "  + e.getY());
                try {
                    playClicked(e);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                playLocal(e);
                playLAN(e);
            }

            public void playClicked(MouseEvent e) throws Exception {
                if (e.getX() > 100 && e.getX() < 350 && e.getY() > 500 && e.getY() < 625){
                    System.out.println("Play");
                    mode.switchMode("Play");
                    panel.repaint();
                }
            }

            public void playLocal(MouseEvent e){
                if (e.getX() > 400 && e.getX() < 600 && e.getY() > 500 && e.getY() < 625){
                    System.out.println("Local");
                }
            }

            public void playLAN(MouseEvent e){
                if (e.getX() > 250 && e.getX() < 500 && e.getY() > 650 && e.getY() < 725){
                    System.out.println("LAN");
                }
            }

            public void mouseMultiplayerSetup(MouseEvent e){
                if(e.getX() > 0 && e.getX() < 250 && e.getY() > 0 && e.getY() < 250){
                    GameBoard.AddXorOLocalMultiplayer(0, 0);
                }
                if(e.getX() > 250 && e.getX() < 550 && e.getY() > 0 && e.getY() < 250){
                    GameBoard.AddXorOLocalMultiplayer(1, 0);
                }
                if(e.getX() > 550 && e.getX() < 800 && e.getY() > 0 && e.getY() < 250){
                    GameBoard.AddXorOLocalMultiplayer(2, 0);
                }
                if(e.getX() > 0 && e.getX() < 250 && e.getY() > 250 && e.getY() < 550){
                    GameBoard.AddXorOLocalMultiplayer(0, 1);
                }
                if(e.getX() > 0 && e.getX() < 250 && e.getY() > 550 && e.getY() < 800){
                    GameBoard.AddXorOLocalMultiplayer(0, 2);
                }
                if(e.getX() > 250 && e.getX() < 550 && e.getY() > 250 && e.getY() < 550){
                    GameBoard.AddXorOLocalMultiplayer(1, 1);
                }
                if(e.getX() > 250 && e.getX() < 550 && e.getY() > 550 && e.getY() < 800){
                    GameBoard.AddXorOLocalMultiplayer(1, 2);
                }
                if(e.getX() > 550 && e.getX() < 800 && e.getY() > 250 && e.getY() < 550){
                    GameBoard.AddXorOLocalMultiplayer(2, 1);
                }
                if(e.getX() > 550 && e.getX() < 800 && e.getY() > 550 && e.getY() < 800){
                    GameBoard.AddXorOLocalMultiplayer(2, 2);
                }
            }

            public void mouseBotSetup(MouseEvent e){
                if(e.getX() > 0 && e.getX() < 250 && e.getY() > 0 && e.getY() < 250){
                    GameBoard.AddXorOBot(0, 0);
                }
                if(e.getX() > 250 && e.getX() < 550 && e.getY() > 0 && e.getY() < 250){
                    GameBoard.AddXorOBot(1, 0);
                }
                if(e.getX() > 550 && e.getX() < 800 && e.getY() > 0 && e.getY() < 250){
                    GameBoard.AddXorOBot(2, 0);
                }
                if(e.getX() > 0 && e.getX() < 250 && e.getY() > 250 && e.getY() < 550){
                    GameBoard.AddXorOBot(0, 1);
                }
                if(e.getX() > 0 && e.getX() < 250 && e.getY() > 550 && e.getY() < 800){
                    GameBoard.AddXorOBot(0, 2);
                }
                if(e.getX() > 250 && e.getX() < 550 && e.getY() > 250 && e.getY() < 550){
                    GameBoard.AddXorOBot(1, 1);
                }
                if(e.getX() > 250 && e.getX() < 550 && e.getY() > 550 && e.getY() < 800){
                    GameBoard.AddXorOBot(1, 2);
                }
                if(e.getX() > 550 && e.getX() < 800 && e.getY() > 250 && e.getY() < 550){
                    GameBoard.AddXorOBot(2, 1);
                }
                if(e.getX() > 550 && e.getX() < 800 && e.getY() > 550 && e.getY() < 800){
                    GameBoard.AddXorOBot(2, 2);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Hello world");
                System.out.println(e.getX());
                System.out.println(e.getY());
                if(mode.getMode().equals("Local")) {
                    mouseMultiplayerSetup(e);
                }
                if(mode.getMode().equals("Play")){
                    GameBoard.AddXorOBot(0,0);
                }
                GameBoard.printBoard();
                panel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        panel.addMouseListener(mouseListener);
    }
}
