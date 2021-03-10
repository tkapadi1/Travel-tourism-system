/*
 * Travel and Tourism Management System.
 */
package ttms;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kappa
 */
public class Splash {

    public Splash() {

    }

    public static void main(String[] args) {
        // TODO code application logic here
        SplashFrame frame = new SplashFrame();
        int x = 1/2;
        frame.setVisible(true);

        for (int i = 0; i < 670; i++, x+=1/3) {
            frame.setLocation(700 - (i + x + i/2)/2, 410 - (i/2));
            frame.setSize((x/2 + i/3)*5, i);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            
        }
    
    }

}

class SplashFrame extends JFrame implements Runnable {

    public SplashFrame() {
        Thread t1;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1280, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);

        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();

//        setBounds(130, 65, 1280, 720); //Location where to start from top Left
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            this.setVisible(false);
        } catch (Exception e) {
        }
    }

}
