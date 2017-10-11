/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author mmichalski
 */
public class Day extends JLabel {
    
    private int dayNumber;
    private String dayName;
    
    public Day(int dayNumber)
    {
        super.setText(Integer.toString(dayNumber));
        this.dayNumber = dayNumber;
        
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
}
