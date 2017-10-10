/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.time.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;



/**
 *
 * @author mmichalski
 */
public class MainWindow {
    
    private static MainWindow instance = null;
    private JFrame mainFrame = new JFrame();
    private MainWindow(){}
    
    public static MainWindow getInstance(){
    if(instance ==null){
        instance=new MainWindow();
    }
    return instance;
    }

    public void initWindow(String title)
    {
        Year year = new Year();
        Month month = year.getMonth(10);
        int startDay = month.getStartDay();
        int monthDays = month.getMonthDays();
        
        this.mainFrame.setTitle(title);
        this.mainFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE );
        this.mainFrame.setLayout( new java.awt.GridLayout(7, 7, 1, 1));
        List<String> daysOfWeek = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        for(String d: daysOfWeek)
        {
            JLabel label = new JLabel(d);
            label.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            this.mainFrame.add(label);
        }
        
        int day = 1;
        for(int i=1; i<43; i++)
        {
            
            if(i>=startDay && monthDays+startDay>i)
            {
                
                JLabel label = new JLabel(Integer.toString(day));
                label.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                this.mainFrame.add(label);
                day++;
            }
            else
            {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(Color.darkGray);
                label.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                this.mainFrame.add(label);  
            }
        }
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
        this.mainFrame.setSize(400, 300);
    }
}
