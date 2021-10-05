import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.util.*;

public class DigitalClock extends JPanel{
    ClockLabel dateLabel = new ClockLabel("date"); // create date label
    ClockLabel timeLabel = new ClockLabel("time"); // create time label

    DigitalClock(){
        setOpaque(false); // background invisible
        setLayout(new GridLayout(2, 1));
        add(timeLabel);
        add(dateLabel);
    }
}

class ClockLabel extends JLabel implements ActionListener{
    String type; // type of text
    SimpleDateFormat sdf;


    public ClockLabel(String type){
        this.type = type;     
        
        switch (type) {
                            // set text for day, date, month, year
            case "date" :   sdf = new SimpleDateFormat("EEE, MMM d, YYYY");
                            setForeground(Color.black);
                            setFont(new Font("sans-serif", Font.PLAIN,30));
                            setHorizontalAlignment(SwingConstants.CENTER);
                            setVerticalAlignment(SwingConstants.TOP);
                            break;
                            // set text for hour, minute, second
            case "time" :   sdf = new SimpleDateFormat("hh:mm a");
                            setForeground(Color.blue);
                            setFont(new Font("sans-serif", Font.PLAIN, 60));
                            setHorizontalAlignment(SwingConstants.CENTER);
                            break;
        }
        Timer t = new Timer(1000, this); 
        t.start();
    }
    
    public void actionPerformed(ActionEvent e) {
        Date d = new Date();
        setText(sdf.format(d)); 
    }

}

