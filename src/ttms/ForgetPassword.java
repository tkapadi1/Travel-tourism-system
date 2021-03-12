/*
 * Forget Password File and its connection.
 */
package ttms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kappa
 */
public class ForgetPassword extends JFrame implements ActionListener{

    JButton searchButton, backButton, retrieveButton;
    
    JTextField textField, nameField, answerField, passwordField, securityField;
    
    //String password = null, answer = null;
    
    public ForgetPassword() {
        
        setSize(700, 280);
        setLocation(450, 200);

        setLayout(null);  //Border layout, Flow Layout, Grid Layout, Grid
        
        //set Bounds functions to place your components on your layout.
        getContentPane().setBackground(Color.WHITE);
        
        JPanel jp1 = new JPanel();  //this works same as div in HTML.
        jp1.setBackground(Color.WHITE);
        jp1.setBounds(0, 0, 260, 280);
        jp1.setLayout(null);
        add(jp1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl1 = new JLabel(i3);
        jl1.setBounds( 35, 25, 190, 190);
        jp1.add(jl1);
        
        
        JPanel jp2 = new JPanel();
        jp2.setLayout(null);
        jp2.setBackground(new Color(131, 193, 233));
        jp2.setBounds(260, 0, 500, 280);
        add(jp2);
        
        
        
        //2nd panel importing all buttons and text fields
        JLabel username = new JLabel("Username : ");
        username.setBorder(null);
	username.setBounds(35, 10, 95, 25);
	jp2.add(username);

	textField = new JTextField();
        textField.setBorder(null);
	textField.setBounds(155, 10, 140, 25);
	jp2.add(textField);
        
        searchButton = new JButton("Search");	
        searchButton.setBorder(new LineBorder(Color.DARK_GRAY));
	searchButton.setForeground(Color.GRAY);
	searchButton.setBackground(Color.WHITE);
	searchButton.setBounds(306, 10, 90, 25);
        searchButton.addActionListener(this);
	jp2.add(searchButton);
        
        
        
        JLabel name = new JLabel("Name : ");
        name.setBorder(null);
	name.setBounds(35, 50, 95, 25);
	jp2.add(name);

	nameField = new JTextField();
        nameField.setBorder(null);
	nameField.setBounds(155, 50, 140, 25);
	jp2.add(nameField);
        
                
        
        
        JLabel security = new JLabel("Security Question: ");
        security.setBorder(null);
	security.setBounds(35, 90, 130, 21);
	jp2.add(security);
        
        securityField = new JTextField();
        securityField.setBorder(null);
	securityField.setBounds(155, 90, 240, 21);
	jp2.add(securityField);
        
        
        
        JLabel answer = new JLabel("Answer: ");
        answer.setBorder(null);
	answer.setBounds(37, 130, 140, 25);
	jp2.add(answer);

	answerField = new JTextField();
        answerField.setBorder(null);
	answerField.setBounds(155, 130, 140, 23);
	jp2.add(answerField);
        
        retrieveButton = new JButton("Retrieve");	
        retrieveButton.setBorder(new LineBorder(Color.DARK_GRAY));
	retrieveButton.setForeground(Color.GRAY);
	retrieveButton.setBackground(Color.WHITE);
	retrieveButton.setBounds(306, 130, 90, 25);
        retrieveButton.addActionListener(this);
	jp2.add(retrieveButton);
        
        
        
        
        JLabel password = new JLabel("Password : ");
        password.setBorder(null);
	password.setBounds(37, 166, 95, 25);
	jp2.add(password);
	
	passwordField = new JTextField();
        password.setBorder(BorderFactory.createEmptyBorder());
	passwordField.setBounds(155, 165, 140, 25);
	jp2.add(passwordField);
        
        
		
        backButton = new JButton("Back");	
        backButton.setBorder(new LineBorder(Color.RED));
	backButton.setForeground(Color.GRAY);
	backButton.setBackground(Color.WHITE);
	backButton.setBounds(155, 200, 140, 25);
        backButton.addActionListener(this);
	jp2.add(backButton);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Conn connect = new Conn();
        
        if(e.getSource() == backButton){
            
            this.setVisible(false);
            new Login().setVisible(true);
        
        }else if(e.getSource() == searchButton){
            
            String sql = "select * from account where username = '"+textField.getText()+"'";
            try {
                
                ResultSet allData = connect.statement.executeQuery(sql);
                while(allData.next()){
                    nameField.setText(allData.getString("name"));
                    securityField.setText(allData.getString("security"));
                }
                
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "User NOT found! please check the username");
                Logger.getLogger(ForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }else if(e.getSource() == retrieveButton){
            
            
            try {
                
                String sql = "select * from account where username = '"+textField.getText()+"' AND answer = '"+answerField.getText()+"'";
                ResultSet allData = connect.statement.executeQuery(sql);
                while(allData.next()){
                    passwordField.setText(allData.getString("password"));
                }
                
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "User NOT found! please check the username");
                Logger.getLogger(ForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
    }
    
    
    public static void main(String[] args) {
        new ForgetPassword().setVisible(true);
    }
}
