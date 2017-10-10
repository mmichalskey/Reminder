/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

/**
 *
 * @author mmichalski
 */
public class Day {
    
    private int dayNumber;
    private String dayName;
    
    public Day(int dayNumber)
    {
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
