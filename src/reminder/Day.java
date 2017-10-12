/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;


/**
 *
 * @author mmichalski
 */
public class Day extends JLabel implements MouseListener {
    
    private int dayNumber;
    private String dayName;
    private boolean selected;
    
    public Day(int dayNumber)
    {
        super.setText(Integer.toString(dayNumber));
        super.setOpaque(true);
        super.setBackground(Color.lightGray);
        super.addMouseListener(this);
        this.dayNumber = dayNumber;
        this.selected = false;
        
    }
    
    public void setDayName(String dayName)
    {
        this.dayName = dayName;
    }
    
    
    public String getDayName()
    {
        return this.dayName;
    }
    
    public int getDayNumber()
    {
        return this.dayNumber;
    }
    
    public boolean isSelected()
    {
        return this.selected;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
       if(MainWindow.previousCheckedDay != this && MainWindow.previousCheckedDay == null)
       {
         this.setOpaque(true);
         this.setBackground(new Color(86, 179, 250));
         this.selected = true;
         MainWindow.previousCheckedDay = this;
       }
       else if(MainWindow.previousCheckedDay == this)
       {
         this.setBackground(Color.lightGray);
         this.selected = false;
         MainWindow.previousCheckedDay = null;
       }
       else
       {
          this.setOpaque(true);
          this.setBackground(new Color(86, 179, 250));
          this.selected = true;
          MainWindow.previousCheckedDay.setBackground(Color.lightGray);
          MainWindow.previousCheckedDay.selected = false;
          MainWindow.previousCheckedDay = this;
          
       }
       
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) { 
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }


}
