import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

public class AnalogClock extends JPanel implements Runnable{
    int x_second, y_second, x_minute, y_minute, x_hour, y_hour;
    Thread clockThread = new Thread(this);

    AnalogClock(){
        setOpaque(false);     
        setDoubleBuffered(true); // reducing flickering
        clockThread.start();
        
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        // set position of central point alway in center of screen
        g2d.translate(getWidth()/2, getHeight()/2);

        // Resize clock face when resize screen
        int side = getWidth() > getHeight() ? getHeight() : getWidth();
        g2d.scale(side/250, side/250);
        
        // repaint process
        setAllRenderingHints(g2d);
        drawClockFace(g2d);
        drawClockHands(g2d);
        
    }

    @Override
    public void run() {
        // get coordinates for clock hands
        while (true) {
            int s = Calendar.getInstance().get(Calendar.SECOND);
            x_second = (int) (Math.cos(s * Math.PI/30 - Math.PI/2) * 80);
            y_second = (int) (Math.sin(s * Math.PI/30 - Math.PI/2) * 80);

            int m = Calendar.getInstance().get(Calendar.MINUTE);
            x_minute = (int) (Math.cos(m * Math.PI/30 - Math.PI/2) * 75);
            y_minute = (int) (Math.sin(m * Math.PI/30 - Math.PI/2) * 75);

            int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            x_hour = (int) (Math.cos((h * 30 + m / 2) * Math.PI / 180 - Math.PI / 2) * 60);
            y_hour = (int) (Math.sin((h * 30 + m / 2) * Math.PI / 180 - Math.PI / 2) * 60);

            repaint(); // draw clock hands when time run
        }
    }

    //  increase rendering quality 
    private void setAllRenderingHints(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
   
     }

    private void drawClockFace(Graphics2D g){
        g.setPaint(Color.lightGray); // set color of clock face
        g.fill(new Arc2D.Double(-110, -110, 220, 220, 0, 360, Arc2D.CHORD)); // fill color for clock face

        g.setColor(Color.darkGray); // color of circle
        g.setStroke(new BasicStroke(4.0f)); // controlling thickness circle of clock
        g.draw(new Arc2D.Double(-110, -110, 220, 220, 0, 360, Arc2D.CHORD)); // draw circle of clock

        // draw line minute in clock face
        for (int i = 0; i < 60; i++) {
            if ((i % 5) != 0) {
                g.setStroke(new BasicStroke(1.0f));
                g.setColor(Color.darkGray);
                g.drawLine(92, 0, 96, 0);
            } else {
                g.setColor(Color.black);
                g.setStroke(new BasicStroke(2.0f));
                g.drawLine(88, 0, 96, 0);
            }
            g.rotate((Math.PI / 180.0) * 6.0);  // rotate circle around center of clock 
        }
    }

    private void drawClockHands (Graphics2D g) {
        // draw hands hour
        g.setColor(Color.blue);
        g.setStroke(new BasicStroke(5.0f));
        g.drawLine(0, 0, x_hour, y_hour);

        // draw hands minute
        g.setStroke(new BasicStroke(3.0f));
        g.drawLine(0, 0, x_minute, y_minute);
        g.setColor(Color.black);

        // draw hands second
        g.setStroke(new BasicStroke(2.0f));
        g.drawLine(0, 0, x_second, y_second);
        g.setColor(Color.black);
        
        // draw center of circle
        g.fillOval(-5, -5, 10, 10);
        g.setColor(Color.white);
        g.fillOval(-2, -2, 4, 4);
    }
}   

    