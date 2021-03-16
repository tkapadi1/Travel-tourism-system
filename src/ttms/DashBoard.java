/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.swing.JPanel;

/**
 *
 * @author kappa
 */
public class DashBoard extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    
    String username = null;

    public DashBoard(String user) {
        
        username = user;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1950, 65);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 103));
        add(p1);
               
        JLabel dash = new JLabel("|:T:| Dashboard");
        dash.setLayout(null);
        dash.setBounds(10, 12, 300, 40);
        dash.setForeground(Color.WHITE);
        dash.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(dash);

       
        
        JPanel p2 = new JPanel();
        p2.setBounds(0, 65, 300, 1000);
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 103));
        add(p2);
        
        b1 = new JButton("Add Personal Details");
        b1.setBackground(new Color(0, 0, 102));
        b1.setForeground(Color.WHITE);
        b1.setBounds(0, 0, 300, 50);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b1.addActionListener(this);
        p2.add(b1);
        
        b2 = new JButton("Update Personal Details");
        b2.setBackground(new Color(0, 0, 102));
        b2.setForeground(Color.WHITE);
        b2.setBounds(0, 50, 300, 50);
        b2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b2.addActionListener(this);
        p2.add(b2);
        
        b3 = new JButton("View Personal Details");
        b3.setBackground(new Color(0, 0, 102));
        b3.setForeground(Color.WHITE);
        b3.setBounds(0, 100, 300, 50);
        b3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b3.addActionListener(this);
        p2.add(b3);
        
        b4 = new JButton("Delete Personal Details");
        b4.setBackground(new Color(0, 0, 102));
        b4.setForeground(Color.WHITE);
        b4.setBounds(0, 150, 300, 50);
        b4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b4.addActionListener(this);
        p2.add(b4);
        
        b5 = new JButton("Check package");
        b5.setBackground(new Color(0, 0, 102));
        b5.setForeground(Color.WHITE);
        b5.setBounds(0, 200, 300, 50);
        b5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b5.addActionListener(this);
        p2.add(b5);
        
        b6 = new JButton("Book Package");
        b6.setBackground(new Color(0, 0, 102));
        b6.setForeground(Color.WHITE);
        b6.setBounds(0, 250, 300, 50);
        b6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b6.addActionListener(this);
        p2.add(b6);
        
        b7 = new JButton("View Package");
        b7.setBackground(new Color(0, 0, 102));
        b7.setForeground(Color.WHITE);
        b7.setBounds(0, 300, 300, 50);
        b7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b7.addActionListener(this);
        p2.add(b7);
        
        b8 = new JButton("View Hotels");
        b8.setBackground(new Color(0, 0, 102));
        b8.setForeground(Color.WHITE);
        b8.setBounds(0, 350, 300, 50);
        b8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b8.addActionListener(this);
        p2.add(b8);
        
        b9 = new JButton("Book Hotels");
        b9.setBackground(new Color(0, 0, 102));
        b9.setForeground(Color.WHITE);
        b9.setBounds(0, 400, 300, 50);
        b9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b9.addActionListener(this);
        p2.add(b9);
        
        b10 = new JButton("View Booked Details");
        b10.setBackground(new Color(0, 0, 102));
        b10.setForeground(Color.WHITE);
        b10.setBounds(0, 450, 300, 50);
        b10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b10.addActionListener(this);
        p2.add(b10);
        
        b11 = new JButton("Destinatons");
        b11.setBackground(new Color(0, 0, 102));
        b11.setForeground(Color.WHITE);
        b11.setBounds(0, 500, 300, 50);
        b11.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b11.addActionListener(this);
        p2.add(b11);
        
        b12 = new JButton("Payment");
        b12.setBackground(new Color(0, 0, 102));
        b12.setForeground(Color.WHITE);
        b12.setBounds(0, 550, 300, 50);
        b12.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b12.addActionListener(this);
        p2.add(b12);
        
        b13 = new JButton("Calculator");
        b13.setBackground(new Color(0, 0, 102));
        b13.setForeground(Color.WHITE);
        b13.setBounds(0, 600, 300, 50);
        b13.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b13.addActionListener(this);
        p2.add(b13);
        
        b14 = new JButton("NotePad");
        b14.setBackground(new Color(0, 0, 102));
        b14.setForeground(Color.WHITE);
        b14.setBounds(0, 650, 300, 42);
        b14.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b14.addActionListener(this);
        p2.add(b14);
        
        b15 = new JButton("About");
        b15.setBackground(new Color(0, 0, 102));
        b15.setForeground(Color.WHITE);
        b15.setBounds(0, 692, 300, 42);
        b15.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b15.addActionListener(this);
        p2.add(b15);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/home.jpg"));
        Image home = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(home);
        JLabel l1 = new JLabel(image);
        l1.setBounds(0, 0, 1950, 1000);
        add(l1);
        
        JLabel brandHead = new JLabel("Travel and Tourism Management Systems");
        brandHead.setBounds(445, 80, 1000, 60);
        brandHead.setForeground(Color.WHITE);
        brandHead.setFont(new Font("Tahoma", Font.BOLD, 45));
        l1.add(brandHead);
                
        
    }
    
    public static void main(String[] args) {
        new DashBoard("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1){
            new AddCustomer(username).setVisible(true);
        }else if(e.getSource() == b2){
            new UpdateDetails(username).setVisible(true);
        }else if(e.getSource() == b3){
            new ViewCustomer(username).setVisible(true);
        }else if(e.getSource() == b5){
            new CheckPackage().setVisible(true);
        }else if(e.getSource() == b6){
            new BookPackage(username).setVisible(true);
        }else if(e.getSource() == b7){
            new ViewPackage(username).setVisible(true);
        }else if(e.getSource() == b8){
            new CheckHotels().setVisible(true);
        }else if(e.getSource() == b9){
            new BookHotel(username).setVisible(true);
        }else if(e.getSource() == b10){
            new ViewBookedHotel(username).setVisible(true);
        }else if(e.getSource() == b11){
            new Destinations().setVisible(true);
        }else if(e.getSource() == b12){
            new Payment().setVisible(true);
        }else if(e.getSource() == b13){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception c) {
                
            }
        }else if(e.getSource() == b14){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception c) {
            }
        }else if(e.getSource() == b15){
            new About().setVisible(true);
        }
        
    }
}
