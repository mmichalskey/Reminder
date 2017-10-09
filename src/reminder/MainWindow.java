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
        YearMonth yearMonthObject = YearMonth.of(2017, 10);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        
        this.mainFrame.setTitle(title);
        this.mainFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE );
        this.mainFrame.setLayout( new java.awt.GridLayout(5,7));
        
        for(int i=0; i<daysInMonth; i++)
        {
            int mod = 0;
            JLabel label = new JLabel(Integer.toString(i+1));
            label.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            this.mainFrame.add(label);
            mod++;
            if(mod%7==0)
            {
                mod = 0;
            }
        }
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
        this.mainFrame.setSize(300, 200);
    }
}
