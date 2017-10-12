/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mmichalski
 */
public class Month {
    
    private int monthNumber;
    private final String monthName;
    private final int monthDays;
    private final ArrayList<Day> days;
    
    Month(int monthNumber, String monthName, int monthDays)
    {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
        this.monthDays = monthDays;
        this.days = new ArrayList<>();
        this.generateDays();
    }
    
    private void generateDays()
    {
        for(int i=1; i<=this.monthDays; i++)
        {
            Day day = new Day(i);
            this.days.add(day);
        }
    }
    
    public int getSelectedDay()
    {
        for(Day day : days)
        {
            if(day.isSelected())
                return day.getDayNumber();
        }
        return 0;
    }
    
    public String getMonthName()
    {
        return this.monthName;
    }
    
    public int getMonthNumber()
    {
        return this.monthNumber;
    }
    
    public int getMonthDays()
    {
        return this.monthDays;
    }
    
    public Day getDay(int num)
    {
        for(Day day : days)
        {
            if(num == day.getDayNumber())
                return day;
        }
        return null;
    }
    
    public int getStartDay()
    {
        List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        String day = this.getDay(1).getDayName();
        return (daysOfWeek.indexOf(day)+1);
    }
}
