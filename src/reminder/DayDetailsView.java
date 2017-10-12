/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mmichalski
 */
public class DayDetailsView {
    
    private JPanel dayDetailsView;
    private JLabel date;
    
    public DayDetailsView() {
        this.dayDetailsView = new JPanel();
        this.date = new JLabel("Data: ");
        this.dayDetailsView.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 5));
        this.dayDetailsView.setLayout(new BoxLayout(this.dayDetailsView, BoxLayout.Y_AXIS));
        
    }
    
    public void setDetailsView(JFrame window)
    {
        window.add(this.dayDetailsView);
    }
    
    public void setDetailsDate(String date)
    {
        this.date.setText("Data: " + date);
    }
    
    public void removeAll()
    {
       this.dayDetailsView.removeAll();
    }
    
    
    
    
    
}
