/*
 * SignUp Page.
 */
package ttms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author kappa
 */
public class SignUp extends JFrame implements ActionListener{
    
    JButton createButton, backButton;
    
    JTextField textField, nameField, answerField, passwordField;
    
    //JPasswordField passwordField;
    
    Choice box;

    public SignUp() {
        setSize(700, 250);
        setLocation(450, 200);

        setLayout(null);  //Border layout, Flow Layout, Grid Layout, Grid
        
        //set Bounds functions to place your components on your layout.
        getContentPane().setBackground(Color.WHITE);
        
        JPanel jp1 = new JPanel();  //this works same as div in HTML.
        jp1.setBackground(Color.WHITE);
        jp1.setBounds(0, 0, 250, 250);
        jp1.setLayout(null);
        add(jp1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(175, 175, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl1 = new JLabel(i3);
        jl1.setBounds( 45, 25, 175, 175);
        jp1.add(jl1);
        
        
        JPanel jp2 = new JPanel();
        jp2.setLayout(null);
        jp2.setBackground(new Color(131, 193, 233));
        jp2.setBounds(250, 0, 500, 250);
        add(jp2);
        
        
        
        //2nd panel importing all buttons and text fields
        JLabel username = new JLabel("Username : ");
        username.setBorder(null);
	username.setBounds(40, 10, 95, 25);
	jp2.add(username);

	textField = new JTextField();
        textField.setBorder(null);
	textField.setBounds(170, 10, 220, 25);
	jp2.add(textField);
        
        
        
        JLabel name = new JLabel("Name : ");
        name.setBorder(null);
	name.setBounds(40, 50, 95, 25);
	jp2.add(name);

	nameField = new JTextField();
        nameField.setBorder(null);
	nameField.setBounds(170, 50, 220, 25);
	jp2.add(nameField);
        
        
        
        JLabel password = new JLabel("Password : ");
        password.setBorder(null);
	password.setBounds(40, 90, 95, 25);
	jp2.add(password);
	
	passwordField = new JPasswordField();
        password.setBorder(BorderFactory.createEmptyBorder());
	passwordField.setBounds(170, 90, 220, 25);
	jp2.add(passwordField);
        
        
        
        box = new Choice();
        box.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        box.add("Security Question");
        box.add("Lucky Number?");
        box.add("Mothers Maiden Name?");
        box.add("Nick Name?");
        box.add("Favourite Superhero?");
        box.setBounds(35, 130, 130, 30);
        jp2.add(box);

	answerField = new JTextField();
        answerField.setBorder(null);
	answerField.setBounds(170, 130, 220, 21);
	jp2.add(answerField);
        
        
        
        createButton = new JButton("Create");     
        createButton.setBorder(new LineBorder(new Color(133, 193, 233)));
	createButton.setBackground(Color.WHITE);
	createButton.setForeground(new Color(133, 193, 233));
	createButton.setBounds(35, 165, 200, 30);
        createButton.addActionListener(this);
	jp2.add(createButton);
		
        backButton = new JButton("Back");	
        backButton.setBorder(new LineBorder(Color.WHITE));
	backButton.setBackground(new Color(133, 193, 233));
	backButton.setForeground(Color.WHITE);
	backButton.setBounds(245, 165, 145, 30);
        backButton.addActionListener(this);
	jp2.add(backButton);
        
    }
    
    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createButton){
            String username = textField.getText();
            String name = nameField.getText();
            String password = passwordField.getText();
            String answer = answerField.getText();
            String security = box.getSelectedItem();
            
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
            
            try {
                
                Conn connect = new Conn();
                connect.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created Successfully!");
                this.setVisible(false);
                new Login().setVisible(true);
                
            } catch (Exception mysql) {
            }
            
        }else if(e.getSource() == backButton){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
}
