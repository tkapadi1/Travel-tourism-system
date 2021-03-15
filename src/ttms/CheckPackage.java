/*
 * To built package details using TABs.
 */
package ttms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author kappa
 */
public class CheckPackage extends JFrame{

    public CheckPackage() {
        
        setBounds(450, 200, 700, 500);
        
        String[] package1 = new String[]{
            "GOLD PACKAGE",
            "6 Days and 7 Nights",
            "Airport Assitance",
            "Half Day City Tour",
            "Daily Buffet",
            "Welcome Drinks on Arrival",
            "Full Day 3 Island Cruise",
            "English Speaking Guide",
            "Summer Special",
            "USD 1200.00",
            "ttms/icons/package1.jpg"
        };
        
        String[] package2 = new String[]{
            "PLATINIUM PACKAGE",
            "7 Days and 8 Nights",
            "Entrance Free Tickets",
            "Half Day City Tour",
            "Daily Buffet",
            "SPA on Arrival",
            "Two Day Island Cruise",
            "English Speaking Guide",
            "Winter Special",
            "USD 2000.00",
            "ttms/icons/package2.jpg"
        };
        
        String[] package3 = new String[]{
            "CROWN PACKAGE",
            "9 Days and 10 Nights",
            "Airport LIMO Pickup & drop",
            "Two Day City Tour & Sports",
            "Daily Lunch & Dinner",
            "Unlimited Drinks on House",
            "Full 3 Nights Boat House",
            "English Speaking Guide",
            "All Season Special",
            "USD 3500.00",
            "ttms/icons/package3.jpg"
        };
        
        JTabbedPane pane = new JTabbedPane();
        
        JPanel p1 = createPackage(package1);
        
        JPanel p2 = createPackage(package2);
        
        JPanel p3 = createPackage(package3);
        
        pane.addTab("Package Gold", null, p1);
        
        pane.addTab("Package Platinium", null, p2);
        
        pane.addTab("Package Crown", null, p3);
        
        add(pane, BorderLayout.CENTER);
        
        
    }
    
    public static void main(String[] args) {
        new CheckPackage().setVisible(true);
    }

    private JPanel createPackage(String[] pack) {
        
        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(Color.WHITE);
        
        JLabel gold = new JLabel(pack[0]);
        gold.setBounds(50, 5, 300, 30);
        gold.setFont(new Font("Tahoma", Font.PLAIN, 30));
        jp.add(gold);
        
        JLabel l1 = new JLabel(pack[1]);
        l1.setBounds(30, 60, 300, 30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jp.add(l1);
        
        JLabel l2 = new JLabel(pack[2]);
        l2.setBounds(30, 100, 300, 30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jp.add(l2);
        
        JLabel l3 = new JLabel(pack[3]);
        l3.setBounds(30, 140, 300, 30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jp.add(l3);
        
        JLabel l4 = new JLabel(pack[4]);
        l4.setBounds(30, 180, 300, 30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jp.add(l4);
        
        JLabel l5 = new JLabel(pack[5]);
        l5.setBounds(30, 220, 300, 30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jp.add(l5);
        
        JLabel l6 = new JLabel(pack[6]);
        l6.setBounds(30, 260, 300, 30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jp.add(l6);
        
        JLabel l7 = new JLabel(pack[7]);
        l7.setBounds(30, 300, 300, 30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jp.add(l7);
        
        JLabel l8 = new JLabel("BOOK NOW");
        l8.setBounds(30, 385, 300, 30);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 30));
        jp.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(250, 385, 300, 30);
        l9.setForeground(Color.RED);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 22));
        jp.add(l9);
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(490, 385, 300, 30);
        l10.setForeground(Color.RED);
        l10.setFont(new Font("Tahoma", Font.PLAIN, 22));
        jp.add(l10);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(pack[10]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(260, 35, 400, 350);
        jp.add(image);
        
                
        
        return jp;
        
    }
    
}
