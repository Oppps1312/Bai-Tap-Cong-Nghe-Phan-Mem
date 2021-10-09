import javax.swing.JFrame;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,600);
        frame.add(new ClockPanel());
        frame.setVisible(true);
    }    
}
