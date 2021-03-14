/*
 * Loading Screen after the Login is Successful.
 */
package ttms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author kappa
 */
public class Loading extends JFrame implements Runnable{
    
    JProgressBar progressBar;
    
    String user = null;
    
    Thread t;

    public Loading(String username) {
        
        user = username;
        t = new Thread(this);
        
        setBounds(450, 200, 600, 400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Travel and Tourism Application");
        heading.setBounds(60, 30, 500, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true); //this will show the percentage.
        progressBar.setBounds(150, 95, 300, 20);
        add(progressBar);
        
        
        JLabel wait = new JLabel("Please Wait...");
        wait.setBounds(250, 115, 100, 25);
        wait.setFont(new Font("Tahoma", Font.BOLD, 13));
        wait.setForeground(Color.RED);
        add(wait);
        
        
        JLabel welcome = new JLabel("Welcome ");
        welcome.setBounds(230, 195, 300, 32);
        welcome.setFont(new Font("Tahoma", Font.BOLD, 30));
        welcome.setForeground(Color.GRAY);
        add(welcome);
        
        
        JLabel usrnm = new JLabel(user);
        usrnm.setBounds(260, 230, 300, 32);
        usrnm.setFont(new Font("Tahoma", Font.BOLD, 30));
        usrnm.setForeground(Color.GRAY);
        add(usrnm);
        
        
        t.start();
    
    }
    
    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }

    @Override
    public void run() {
        
        try {
            for (int i = 1; i <= 101; i++) {
                int max = progressBar.getMaximum();
                int current = progressBar.getValue();
                if(current < max){
                    progressBar.setValue(progressBar.getValue() + 1);
                }else{
                    i = 101;
                    setVisible(false);
                    new DashBoard(user).setVisible(true);
                }
                t.sleep(30);
            }
        } catch (Exception e) {
        }
        
    }
}
