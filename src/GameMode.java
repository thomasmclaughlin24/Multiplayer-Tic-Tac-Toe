import java.util.Objects;

public class GameMode {
    private String gameMode;
    public GameMode(){
        this.gameMode = "Main Menu";
    }
    public void switchMode(String mode) throws Exception {
        if (mode.equals("Main Menu") || mode.equals("Local") || mode.equals("LAN") || mode.equals("Play") || mode.equals("Host Join Code") || mode.equals("Join Code Input")){
            this.gameMode = mode;
        }
        else {
            throw new Exception("Invalid Game Mode");
        }
    }

    public String getMode(){
        return this.gameMode;
    }
}
