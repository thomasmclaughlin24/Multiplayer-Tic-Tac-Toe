//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameBoard.fillBoard();
        Display.DisplayWindow();
        Static_Example notStaticExample = new Static_Example();
        notStaticExample.Print();
        Static_Example.Print2();
    }
}