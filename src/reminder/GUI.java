/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;



/**
 *
 * @author mmichalski
 */
public class GUI implements ActionListener  {

    private JPanel calendarPanel;
    private JPanel changeMonthPanel;
    private JPanel daysPanel;
    private DayDetailsView detailsView;
    private Year year;
    private int month;
    public GUI() 
    {
        this.calendarPanel = new JPanel();
        this.changeMonthPanel = new JPanel();
        this.daysPanel = new JPanel();
        this.detailsView = new DayDetailsView();
        this.year = new Year(LocalDateTime.now().getYear());
        this.month = this.year.getCurrentMonth();
        this.generateMothView();
    }
    
    private void generateDays()
    {   
        int startDay = this.year.getMonth(this.month).getStartDay();
        int monthDays = this.year.getMonth(this.month).getMonthDays();
        int gridSize;
        int day = 1;
        
        if(monthDays <= 31 && startDay <= 6)
        {
            this.daysPanel.setLayout(new GridLayout(6, 7, 1, 1));
            gridSize = 35;
        }
        else
        {
            this.daysPanel.setLayout(new GridLayout(7, 7, 1, 1));
            gridSize = 42;
        }     
        this.daysPanel.setPreferredSize(new Dimension(300,300));
        
        //days generation algo:
        //iterate throuh whole grid elements
        //condition check if day should be generated or empty label 
        for(int i=1; i<=gridSize; i++)
        {
            if(i >= startDay && monthDays+startDay > i)
            {  
                Day dayLabel = this.year.getMonth(this.month).getDay(day);
                dayLabel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                this.daysPanel.add(dayLabel);
                day++;
            }
            else
            {
                JLabel dayLabel = new JLabel();
                dayLabel.setOpaque(true);
                dayLabel.setBackground(Color.darkGray);
                dayLabel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                this.daysPanel.add(dayLabel);  
            }
        }    
    }
    
    private void generateWeekDays()
    {
        List<String> daysOfWeek = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        
        for(String dayOfWeek : daysOfWeek)
        {
            JLabel dow = new JLabel(dayOfWeek, SwingConstants.CENTER);
            dow.setOpaque(true);
            dow.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            dow.setBackground(Color.LIGHT_GRAY);
            this.daysPanel.add(dow);
        }
    }
    
    private void generateMonthChanger()
    {
        BasicArrowButton left = new BasicArrowButton(BasicArrowButton.WEST);
        BasicArrowButton right = new BasicArrowButton(BasicArrowButton.EAST);
        left.setActionCommand("left");
        right.setActionCommand("right");
        this.changeMonthPanel.setLayout(new GridLayout(1, 3, 1, 1));
        this.changeMonthPanel.setPreferredSize(new Dimension(150, 20));
        this.changeMonthPanel.add(left, BorderLayout.WEST);
        this.changeMonthPanel.add(new JLabel(this.year.getMonth(this.month).getMonthName() 
                + " " + this.year.getYear(), SwingConstants.CENTER));
        this.changeMonthPanel.add(right, BorderLayout.EAST);
        left.addActionListener(this);
        right.addActionListener(this);
 
    }
    
    private void generateMothView()
    {
        this.cleanPanels();
        this.generateMonthChanger();
        this.generateWeekDays();
        this.generateDays();
        this.calendarPanel.setLayout(new BoxLayout(calendarPanel, BoxLayout.Y_AXIS));
        this.calendarPanel.setPreferredSize(new Dimension(300,300));
        this.calendarPanel.add(this.changeMonthPanel, BorderLayout.NORTH);
        this.calendarPanel.add(this.daysPanel, BorderLayout.WEST);
        
    }
    
    private void cleanPanels() 
   {
        this.calendarPanel.removeAll(); 
        this.changeMonthPanel.removeAll(); 
        this.daysPanel.removeAll();
        this.daysPanel.removeAll();
     }
    
    public void setCalendarView(JFrame window)
    {
        window.add(this.calendarPanel);
    }
    public void setDetailsView(JFrame window)
    {
        
        this.detailsView.setDetailsView(window);
    }


    
    @Override
   public void actionPerformed(ActionEvent e) 
   {
       
       if ("left".equals(e.getActionCommand()))
       {
            this.month--;
            if(this.month < 1)
            {
                this.year = new Year(this.year.getYear()-1);
                this.month = 12;
            }               
       }
       else
       {
            this.month++;
            if(this.month > 12)
            {
                this.year = new Year(this.year.getYear()+1);
                this.month = 1;     
            }         
       }
       this.generateMothView();
       MainWindow.getInstance().reloadWindow();
       
   }

    
}
