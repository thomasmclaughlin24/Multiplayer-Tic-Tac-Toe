import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu {
    static File play_file = new File("src/costume3.png");
    static File local_file = new File("src/costume4.png");
    static File lan_file = new File("src/costume5.png");

    public static void DrawMainMenu(Graphics g) throws IOException {
        BufferedImage play_image = ImageIO.read(play_file);
        BufferedImage local_image = ImageIO.read(local_file);
        BufferedImage lan_image = ImageIO.read(lan_file);
        g.drawImage(play_image, 100, 500, 250, 125, null);
        g.drawImage(local_image, 400, 500, 250, 125, null);
        g.drawImage(lan_image, 250, 650, 250, 125, null);
    }
}
