import javax.swing.JFrame;

public class mainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(new Countdown());
        frame.setVisible(true);
    }
}
