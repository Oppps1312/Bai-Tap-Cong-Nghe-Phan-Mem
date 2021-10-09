/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Lung
 */
public class HourTime implements Runnable {
    public String time24;
    int hour, minute, second;
    
    public void run() {
        while(true ){
            Calendar calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
	    second = calendar.get(Calendar.SECOND);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date = calendar.getTime();
            String time24 = sdf.format(date);
            
        }
        
    }
    
    
}
