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
    private String monthName;
    private int monthDays;
    private ArrayList<Day> days;
    
    Month(int monthNumber, String monthName, int monthDays)
    {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
        this.monthDays = monthDays;
        this.days = new ArrayList<Day>();
        this.generateDays();
    }
    
    private void generateDays()
    {
        for(int i=1; i<=this.monthDays; i++)
        {
            this.days.add(new Day(i));
        }
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
        List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thurstday", "Friday", "Saturday", "Sunday");
        String day = this.getDay(1).getDayName();
        return (daysOfWeek.indexOf(day)+1);
    }
    
}
