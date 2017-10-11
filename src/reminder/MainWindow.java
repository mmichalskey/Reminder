/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



/**
 *
 * @author mmichalski
 */
public class MainWindow {
    
    private static MainWindow instance = null;
    private final JFrame mainFrame = new JFrame();
    private GUIInterface guiInterface;
    private MainWindow(){}
    
    public static MainWindow getInstance(){
    if(instance ==null){
        instance=new MainWindow();
    }
    return instance;
    }

    public void reloadWindow()
    {
        SwingUtilities.updateComponentTreeUI(this.mainFrame);
    }
    public void initWindow(String title)
    {
        guiInterface = new GUIInterface();
        this.mainFrame.setTitle(title);
        this.mainFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE );
        this.mainFrame.setLayout(new GridLayout (1,2));
        guiInterface.setCalendarView(this.mainFrame);
        guiInterface.setDetailsView(this.mainFrame);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
        this.mainFrame.setResizable(false);
        this.mainFrame.setSize(800, 400);
    }
}
