/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

/**
 *
 * @author Lung
 */
public class DeskTopWatch extends javax.swing.JFrame {
    int hour, minute, second;
    static int second1 = 0;
    static int minute1 = 0;
    static int hour1 = 0;
    static boolean stateCountDown = true;
    static int hourTimer;
    static int minuteTimer;
    static int secondTimer;
    static boolean stateTimer = true;
    Timer timer;
    int x_second, y_second, x_minute, y_minute, x_hour, y_hour;
 
    /**
     * Creates new form DeskTopWatch
     */
    public DeskTopWatch() {
        // Set time clock
        initComponents();
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true ){
                    //Set time
                    Calendar calendar = Calendar.getInstance();
                    hour = calendar.get(Calendar.HOUR_OF_DAY);
                    minute = calendar.get(Calendar.MINUTE);
                    second = calendar.get(Calendar.SECOND);
                    SimpleDateFormat sdf = new SimpleDateFormat("HH   :   mm   :   ss");
                    Date date = calendar.getTime();
                    String time24 = sdf.format(date);
                    hourDisplay.setText(time24);
                    //Set day
                    String pattern = "EEEE,  dd - MM - yyyy";
                    SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
                    dayDisplay.setText(dateformat.format(new Date()));
 
            }
        }
            
        };
        thread.start();
        this.gioQuocte();
        this.runThread();
        
    }
    public void runThread(){
       Thread clockThread = new Thread(){
           @Override
           public void run(){
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
       };
       clockThread.start();
   }
    public void getValueTimer(){
        hourTimer = (int) hourSpinner.getValue();
        minuteTimer = (int) minuteSpinner.getValue();
        secondTimer = (int) secondSpinner.getValue();
        
    }
    public void gioQuocte(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    //Set time in HongKong UTC +8
                    Date date1 = new Date();
                    DateFormat dateFormat1 = new SimpleDateFormat("HH : mm : ss");
                    dateFormat1.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
                    hongKongTime.setText(dateFormat1.format(date1));
                    //Set time in Tokyo GMT +9
                    DateFormat dateFormat2 = new SimpleDateFormat("HH : mm : ss");
                    dateFormat2.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
                    tokyoTime.setText(dateFormat2.format(date1));
                    // Set time in Barcelona GMT +2
                    DateFormat dateFormat3 = new SimpleDateFormat("HH : mm : ss");
                    dateFormat3.setTimeZone(TimeZone.getTimeZone("Europe/Minsk"));
                    barcelonaTime.setText(dateFormat3.format(date1));
                    //Set time in paris GMT +1
                    DateFormat dateFormat4 = new SimpleDateFormat("HH : mm : ss");
                    dateFormat4.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
                    parisTime.setText(dateFormat4.format(date1));
                    //Set time in New York GMT -5
                    DateFormat dateFormat5 = new SimpleDateFormat("HH : mm : ss");
                    dateFormat5.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                    newyorkTime.setText(dateFormat5.format(date1));
                }
            }
         
        };
        thread.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        menuBar = new javax.swing.JPanel();
        GioQuocTeButton = new javax.swing.JButton();
        BamGioButton = new javax.swing.JButton();
        HenGioButton = new javax.swing.JButton();
        BaoThucButton = new javax.swing.JButton();
        XemGioButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        gioQuocTePanel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hongKongTime = new javax.swing.JLabel();
        tokyoTime = new javax.swing.JLabel();
        barcelonaTime = new javax.swing.JLabel();
        parisTime = new javax.swing.JLabel();
        newyorkTime = new javax.swing.JLabel();
        baoThucPanel = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        bamGioPanel = new javax.swing.JPanel();
        hourOfStop = new javax.swing.JLabel();
        secondOfStop = new javax.swing.JLabel();
        minuteOfStop = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        HenGioPanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        hourSpinner = new javax.swing.JSpinner();
        minuteSpinner = new javax.swing.JSpinner();
        secondSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        StartButtonTimer = new javax.swing.JButton();
        StopButtonTimer = new javax.swing.JButton();
        ResetButtonTimer = new javax.swing.JButton();
        milisecondTimer = new javax.swing.JLabel();
        hourLabelTimer = new javax.swing.JLabel();
        minuteLabelTimer = new javax.swing.JLabel();
        secondLabelTimer = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        AnalogPanel = new javax.swing.JPanel(){
            public void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                // set position of central point alway in center of screen
                g2d.translate(getWidth()/2, getHeight()/2);

                

                // repaint process
                setAllRenderingHints(g2d);
                drawClockFace(g2d);
                drawClockHands(g2d);

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
        };
        hourDisplay = new javax.swing.JLabel();
        dayDisplay = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DesktopWatch");
        setSize(new java.awt.Dimension(1200, 800));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        menuBar.setBackground(new java.awt.Color(255, 204, 255));

        GioQuocTeButton.setText("WORLD TIME");
        GioQuocTeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GioQuocTeButtonActionPerformed(evt);
            }
        });

        BamGioButton.setText("STOPWATCH");
        BamGioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BamGioButtonActionPerformed(evt);
            }
        });

        HenGioButton.setText("TIMER");
        HenGioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HenGioButtonActionPerformed(evt);
            }
        });

        BaoThucButton.setText("ALARM");
        BaoThucButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaoThucButtonActionPerformed(evt);
            }
        });

        XemGioButton.setText("CLOCK");
        XemGioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XemGioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GioQuocTeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BamGioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(HenGioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(XemGioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(BaoThucButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(GioQuocTeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BaoThucButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BamGioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(HenGioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(XemGioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        gioQuocTePanel.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Múi giờ các nước");
        jTextField1.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Tokyo");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setText("Barcelona");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setText("Hong Kong");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setText("Paris");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel11.setText("New York");

        hongKongTime.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        tokyoTime.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        barcelonaTime.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        barcelonaTime.setToolTipText("");

        parisTime.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        newyorkTime.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        javax.swing.GroupLayout gioQuocTePanelLayout = new javax.swing.GroupLayout(gioQuocTePanel);
        gioQuocTePanel.setLayout(gioQuocTePanelLayout);
        gioQuocTePanelLayout.setHorizontalGroup(
            gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator5)
            .addComponent(jSeparator7)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator9)
            .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                .addGroup(gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(tokyoTime, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(barcelonaTime, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(hongKongTime))
                    .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(parisTime, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(newyorkTime, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        gioQuocTePanelLayout.setVerticalGroup(
            gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gioQuocTePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hongKongTime, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tokyoTime, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barcelonaTime, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parisTime, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gioQuocTePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newyorkTime, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", gioQuocTePanel);

        baoThucPanel.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Normal");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Special");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chọn thời gian:");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Hour");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Minute");

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Chọn chế độ báo thức: ");

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 255, 102));
        jButton7.setText("Set");

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 0, 0));
        jButton8.setText("Cancel");

        javax.swing.GroupLayout baoThucPanelLayout = new javax.swing.GroupLayout(baoThucPanel);
        baoThucPanel.setLayout(baoThucPanelLayout);
        baoThucPanelLayout.setHorizontalGroup(
            baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baoThucPanelLayout.createSequentialGroup()
                .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baoThucPanelLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(baoThucPanelLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baoThucPanelLayout.createSequentialGroup()
                                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(baoThucPanelLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(baoThucPanelLayout.createSequentialGroup()
                .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baoThucPanelLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baoThucPanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baoThucPanelLayout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        baoThucPanelLayout.setVerticalGroup(
            baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baoThucPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jSpinner4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(58, 58, 58)
                .addGroup(baoThucPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", baoThucPanel);

        bamGioPanel.setBackground(new java.awt.Color(255, 255, 255));

        hourOfStop.setBackground(new java.awt.Color(204, 204, 204));
        hourOfStop.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        hourOfStop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourOfStop.setText("00 ");
        hourOfStop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        secondOfStop.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        secondOfStop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondOfStop.setText("00 ");
        secondOfStop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        minuteOfStop.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        minuteOfStop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minuteOfStop.setText("00 ");
        minuteOfStop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(":");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(":");

        javax.swing.GroupLayout bamGioPanelLayout = new javax.swing.GroupLayout(bamGioPanel);
        bamGioPanel.setLayout(bamGioPanelLayout);
        bamGioPanelLayout.setHorizontalGroup(
            bamGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bamGioPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(bamGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bamGioPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(bamGioPanelLayout.createSequentialGroup()
                        .addComponent(hourOfStop, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(bamGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bamGioPanelLayout.createSequentialGroup()
                        .addComponent(minuteOfStop, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(secondOfStop, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bamGioPanelLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        bamGioPanelLayout.setVerticalGroup(
            bamGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bamGioPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(bamGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secondOfStop, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteOfStop, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hourOfStop, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bamGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bamGioPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bamGioPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(bamGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", bamGioPanel);

        HenGioPanel.setBackground(new java.awt.Color(255, 255, 255));

        hourSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 1));

        minuteSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, 60, 1));

        secondSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Giờ");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phút");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Giây");

        StartButtonTimer.setBackground(new java.awt.Color(204, 255, 204));
        StartButtonTimer.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        StartButtonTimer.setText("Start");
        StartButtonTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonTimerActionPerformed(evt);
            }
        });

        StopButtonTimer.setBackground(new java.awt.Color(255, 51, 51));
        StopButtonTimer.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        StopButtonTimer.setText("Stop");
        StopButtonTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonTimerActionPerformed(evt);
            }
        });

        ResetButtonTimer.setBackground(new java.awt.Color(102, 255, 255));
        ResetButtonTimer.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ResetButtonTimer.setText("Reset");
        ResetButtonTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonTimerActionPerformed(evt);
            }
        });

        milisecondTimer.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        milisecondTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        hourLabelTimer.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        hourLabelTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourLabelTimer.setText("00");

        minuteLabelTimer.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        minuteLabelTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minuteLabelTimer.setText("00");

        secondLabelTimer.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        secondLabelTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secondLabelTimer.setText("00");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(":");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(":");

        javax.swing.GroupLayout HenGioPanelLayout = new javax.swing.GroupLayout(HenGioPanel);
        HenGioPanel.setLayout(HenGioPanelLayout);
        HenGioPanelLayout.setHorizontalGroup(
            HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HenGioPanelLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HenGioPanelLayout.createSequentialGroup()
                        .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HenGioPanelLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel6)
                                .addGap(33, 33, 33)
                                .addComponent(minuteLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(secondLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(HenGioPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(HenGioPanelLayout.createSequentialGroup()
                                        .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(hourSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                            .addComponent(minuteSpinner))
                                        .addGap(45, 45, 45)
                                        .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(secondSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)))
                        .addComponent(milisecondTimer))
                    .addGroup(HenGioPanelLayout.createSequentialGroup()
                        .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(StartButtonTimer)
                            .addComponent(hourLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(StopButtonTimer)
                        .addGap(64, 64, 64)
                        .addComponent(ResetButtonTimer)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        HenGioPanelLayout.setVerticalGroup(
            HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HenGioPanelLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hourSpinner)
                    .addComponent(secondSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(minuteSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HenGioPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(milisecondTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hourLabelTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minuteLabelTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(secondLabelTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(HenGioPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(HenGioPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartButtonTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HenGioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(StopButtonTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ResetButtonTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(270, 270, 270))
        );

        jTabbedPane1.addTab("", HenGioPanel);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout AnalogPanelLayout = new javax.swing.GroupLayout(AnalogPanel);
        AnalogPanel.setLayout(AnalogPanelLayout);
        AnalogPanelLayout.setHorizontalGroup(
            AnalogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        AnalogPanelLayout.setVerticalGroup(
            AnalogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );

        hourDisplay.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        hourDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hourDisplay.setText("Hour");

        dayDisplay.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        dayDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayDisplay.setText("Ngày và giờ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnalogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hourDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(dayDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(AnalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hourDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dayDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jTabbedPane1)
                        .addGap(147, 147, 147)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(860, 753));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void XemGioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XemGioButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_XemGioButtonActionPerformed

    private void GioQuocTeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GioQuocTeButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_GioQuocTeButtonActionPerformed

    private void BaoThucButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaoThucButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_BaoThucButtonActionPerformed

    private void BamGioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BamGioButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_BamGioButtonActionPerformed

    private void HenGioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HenGioButtonActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_HenGioButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        stateCountDown = true;
        Thread t = new Thread(){
            @Override
            public void run() {
               for(;;){
               
                   if(stateCountDown == true){
                       try {
                           sleep(1000);
                           
                           if(second1 > 60){
                              
                               second1 = 0;
                               minute1++;
                           }
                           if(minute1 > 60){
                               
                               second1 = 0;
                               minute1 = 0;
                               hour1++;
                           }
                          
                           secondOfStop.setText(second1 + "");
                           minuteOfStop.setText(minute1 + "");
                           hourOfStop.setText(hour1 + "");
                           second1++;
                       } catch (Exception e) {
                       }
                   }
                   else{
                       break;
                   }
               }
            }
            
        };
        t.start();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        stateCountDown = false;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        stateCountDown = false;
        hour1 = 0;
        minute1 = 0;
        second1 = 0;
        
        hourOfStop.setText("00");
        minuteOfStop.setText("00");
        secondOfStop.setText("00");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void StartButtonTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonTimerActionPerformed
        // TODO add your handling code here:
       if(stateTimer){
           getValueTimer();
       }
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if( hourTimer == 0){
                    if(secondTimer == 0){
                        secondTimer = 60;
                        minuteTimer--;
                    }
                    if(minuteTimer < 0){
                        JOptionPane.showMessageDialog(rootPane, "Times up", "Stopped", 0);
                        timer.stop();
                        minuteTimer = 0;
                        secondTimer = 0;
                    }else{
                        secondTimer--;
                        hourLabelTimer.setText(""+hourTimer);
                        minuteLabelTimer.setText(""+minuteTimer);
                        secondLabelTimer.setText(""+secondTimer);
                    }
                    
                }
                else{
                    if(minuteTimer == 0 && secondTimer == 0){
                        hourTimer--;
                        minuteTimer = 60;
                    }
                     if(secondTimer == 0){
                        secondTimer = 60;
                        minuteTimer--;
                    }
                    if(minuteTimer < 0){
                        JOptionPane.showMessageDialog(rootPane, "Times up", "Stopped", 0);
                        timer.stop();
                        minuteTimer = 0;
                        secondTimer = 0;
                    }else{
                        secondTimer--;
                        hourLabelTimer.setText(""+hourTimer);
                        minuteLabelTimer.setText(""+minuteTimer);
                        secondLabelTimer.setText(""+secondTimer);
                    
                }
                }
                
                
            }
        });
        
        timer.start();
        
        
       
       ;
        
    }//GEN-LAST:event_StartButtonTimerActionPerformed

    private void ResetButtonTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonTimerActionPerformed
        // TODO add your handling code here:
       stateTimer = true;
       timer.stop();
       hourTimer = 0;
       minuteTimer = 0;
       secondTimer = 0;
       hourLabelTimer.setText("00");
       minuteLabelTimer.setText("00");
       secondLabelTimer.setText("00");
    }//GEN-LAST:event_ResetButtonTimerActionPerformed

    private void StopButtonTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonTimerActionPerformed
        // TODO add your handling code here:
        stateTimer = false;
        timer.stop();
        
    }//GEN-LAST:event_StopButtonTimerActionPerformed

     
        
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeskTopWatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeskTopWatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeskTopWatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeskTopWatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeskTopWatch().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AnalogPanel;
    private javax.swing.JButton BamGioButton;
    private javax.swing.JButton BaoThucButton;
    private javax.swing.JButton GioQuocTeButton;
    private javax.swing.JButton HenGioButton;
    private javax.swing.JPanel HenGioPanel;
    private javax.swing.JButton ResetButtonTimer;
    private javax.swing.JButton StartButtonTimer;
    private javax.swing.JButton StopButtonTimer;
    private javax.swing.JButton XemGioButton;
    private javax.swing.JPanel bamGioPanel;
    private javax.swing.JPanel baoThucPanel;
    private javax.swing.JLabel barcelonaTime;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel dayDisplay;
    private javax.swing.JPanel gioQuocTePanel;
    private javax.swing.JLabel hongKongTime;
    private javax.swing.JLabel hourDisplay;
    private javax.swing.JLabel hourLabelTimer;
    private javax.swing.JLabel hourOfStop;
    private javax.swing.JSpinner hourSpinner;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel menuBar;
    private javax.swing.JLabel milisecondTimer;
    private javax.swing.JLabel minuteLabelTimer;
    private javax.swing.JLabel minuteOfStop;
    private javax.swing.JSpinner minuteSpinner;
    private javax.swing.JLabel newyorkTime;
    private javax.swing.JLabel parisTime;
    private javax.swing.JLabel secondLabelTimer;
    private javax.swing.JLabel secondOfStop;
    private javax.swing.JSpinner secondSpinner;
    private javax.swing.JLabel tokyoTime;
    // End of variables declaration//GEN-END:variables

   
  
}
