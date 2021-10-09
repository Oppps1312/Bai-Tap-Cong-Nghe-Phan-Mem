import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class ClockPanel extends JPanel{
    ClockPanel() {
        setSize(350, 550);
        setBackground(new Color(2, 170, 230)); // set background color of panel
        setLayout(new BorderLayout(2,1)); //division panel to 2 row 1 column
        this.add(new AnalogClock(), BorderLayout.CENTER);// add analog clock into frame
        this.add(new DigitalClock(), BorderLayout.SOUTH);// add digital clock into frame
        setVisible(true);
    }
}
