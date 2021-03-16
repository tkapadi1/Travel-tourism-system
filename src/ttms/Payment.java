/*
 * to open a Dialog to give a payment option an redirect it to the portal website.
 */
package ttms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kappa
 */
public class Payment extends JFrame implements ActionListener{
    
    JButton pay, back;

    public Payment() {
        
        setBounds(450, 200, 750, 500);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(750, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 500);
        add(image);
        
        pay = new JButton("PAY NOW");
        pay.setBounds(50, 400, 125, 30);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("BACK");
        back.setBounds(550, 400, 125, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
    }
    
    public static void main(String[] args) {
        new Payment().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == pay){
            this.setVisible(false);
            new Paytm().setVisible(true);
        }else if(e.getSource() == back){
            this.setVisible(false);
        }
        
    }
    
}
