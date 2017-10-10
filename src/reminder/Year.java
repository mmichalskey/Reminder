/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author mmichalski
 */
public class Year {
    
    private int year;
    private ArrayList<Month> months;
    
    public Year()
    {
      this.year = LocalDateTime.now().getYear();;
      months = new ArrayList<Month>();
      this.generateMonths();
      this.updateDaysName();
    }
    private String getMonthForNumber(int num)
    {
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            return months[num];
        }
        return null;
    }
    
    
    private void generateMonths()
    {
        for(int i=1; i<=12; i++)
        {
            months.add(new Month(i, this.getMonthForNumber(i-1), YearMonth.of(this.year, i).lengthOfMonth()));
        }
    }
    
    private void updateDaysName()
    {  
        Calendar date = Calendar.getInstance();
        for(Month month : months)
        {   
            for(int i=1; i<=month.getMonthDays(); i++)
            {   
                int xxx = month.getMonthNumber();
                date.set(this.year, month.getMonthNumber()-1, i);
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
                String asWeekDay = dateFormat.format(date.getTime());
                System.out.println(date.getTime());
                month.getDay(i).setDayName(asWeekDay);
            }
        }
    }
    
    public Month getMonth(int num)
    {
        for(Month month : months)
        {
            if(num == month.getMonthNumber())
                return month;
        }
        return null;
    }
    
}
