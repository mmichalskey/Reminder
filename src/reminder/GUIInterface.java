/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;



/**
 *
 * @author mmichalski
 */
public class GUIInterface implements ActionListener {

    private final JPanel calendarPanel;
    private final JPanel changeMonthPanel;
    private final JPanel daysPanel;
    private final JPanel detailsPanel;
    private final Year year;
    private int month;
    public GUIInterface() 
    {
        this.month = 6;
        this.calendarPanel = new JPanel();
        this.changeMonthPanel = new JPanel();
        this.daysPanel = new JPanel();
        this.detailsPanel = new JPanel();
        this.year = new Year();
        this.generateMothView();
        this.generateDetailsView();
    }
    
    private void generateDays()
    {   
        int startDay = this.year.getMonth(this.month).getStartDay();
        int monthDays = this.year.getMonth(this.month).getMonthDays();
        int gridSize;
        int day = 1;
        // POPRAWKA do wyświetlanego gridu !!!
        if(startDay > 2 && monthDays < 31)
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
        this.changeMonthPanel.add(new JLabel(Integer.toString(this.month), SwingConstants.CENTER));
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
    
    private void generateDetailsView()
    {
        this.detailsPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 5));
        this.detailsPanel.setLayout(new BoxLayout(this.detailsPanel, BoxLayout.Y_AXIS));
        List<String> events = Arrays.asList("Wydarzenia: Tesst", "Gdzie: w Dupie", "Data: 11-10-2017");
        for(String s : events)
        {
           JLabel l = new JLabel(s);
           l.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
           this.detailsPanel.add(l);
        }
    }
    
    private void cleanPanels()
    {
        this.calendarPanel.removeAll(); 
        this.changeMonthPanel.removeAll(); 
        this.daysPanel.removeAll(); 
        this.detailsPanel.removeAll(); 
     }
    
    public void setCalendarView(JFrame window)
    {
        window.add(this.calendarPanel);
    }
    public void setDetailsView(JFrame window)
    {
        window.add(this.detailsPanel);
    }

    
    @Override
   public void actionPerformed(ActionEvent e) 
   {
       
       if ("left".equals(e.getActionCommand()))
       {
            if(this.month > 1)
                this.month--;
       }
       else
       {
            if(this.month < 12 )
                this.month++;
       }
       this.generateMothView();
       MainWindow.getInstance().reloadWindow();
       
   }
    
}
