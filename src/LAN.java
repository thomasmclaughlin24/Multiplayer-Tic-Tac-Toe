import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LAN {
    static File host_button = new File("src/Host Game Button.png");
    static File join_button = new File("src/Join Game Button.png");

    static BufferedImage host_button_image;

    static {
        try {
            host_button_image = ImageIO.read(host_button);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedImage join_button_image;

    static {
        try {
            join_button_image = ImageIO.read(join_button);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LAN() throws IOException {
    }

    public static void DrawLANMenu(Graphics g){
        g.drawImage(host_button_image, 50, 400, 300, 175, null);
        g.drawImage(join_button_image, 400, 400, 300, 175, null);
    }
}
