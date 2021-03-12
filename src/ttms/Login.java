/*
 * Login Page.
 */
package ttms;

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author kappa
 */
public class Login extends JFrame implements ActionListener{
    
    JButton loginButton, signupButton, helpButton;

    public Login() {
        setSize(700, 300);
        setLocation(450, 200);

        setLayout(null);  //Border layout, Flow Layout, Grid Layout, Grid
        
        //set Bounds functions to place your components on your layout.
        getContentPane().setBackground(Color.WHITE);
        
        JPanel jp1 = new JPanel();  //this works same as div in HTML.
        jp1.setBackground(new Color(131, 193, 233));
        jp1.setBounds(0, 0, 300, 300);
        jp1.setLayout(null);
        add(jp1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jl1 = new JLabel(i3);
        jl1.setBounds( 50, 30, 200, 200);
        jp1.add(jl1);
        
        
        JPanel jp2 = new JPanel();
        jp2.setLayout(null);
        jp2.setBounds(300, 0, 400, 300);
        add(jp2);
        
        
        
        //2nd panel importing all buttons and text fields
        JLabel username = new JLabel("Username : ");
        username.setBorder(null);
	username.setBounds(40, 10, 95, 30);
	jp2.add(username);

	JLabel password = new JLabel("Password : ");
        password.setBorder(null);
	password.setBounds(40, 80, 95, 30);
	jp2.add(password);

	JTextField textField = new JTextField();
        textField.setBorder(null);
	textField.setBounds(40, 45, 300, 30);
	jp2.add(textField);
	
	JPasswordField passwordField = new JPasswordField();
        password.setBorder(BorderFactory.createEmptyBorder());
	passwordField.setBounds(40, 115, 300, 30);
	jp2.add(passwordField);
        
        
        loginButton = new JButton("Login");     
        loginButton.setBorder(null);
	loginButton.setForeground(Color.WHITE);
	loginButton.setBackground(new Color(133, 193, 233));
	loginButton.setBounds(40, 165, 140, 30);
        loginButton.addActionListener(this);
	jp2.add(loginButton);
		
        signupButton = new JButton("SignUp");	
        signupButton.setBorder(new LineBorder(new Color(133, 193, 233)));
	signupButton.setForeground(new Color(133, 193, 233));
	signupButton.setBackground(Color.WHITE);
	signupButton.setBounds(200, 165, 140, 30);
        signupButton.addActionListener(this);
	jp2.add(signupButton);
        
        
        JLabel help = new JLabel("Trouble in login..?");
        help.setBorder(null);
        help.setForeground(new Color(133, 193, 233));
        help.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
	help.setBounds(40, 210, 140, 30);
	jp2.add(help);
        
        helpButton = new JButton("Forget Password");	
        helpButton.setBorder(new LineBorder(new Color(133, 193, 233)));;
	helpButton.setForeground(Color.RED);
	helpButton.setBackground(Color.WHITE);
        helpButton.setFont(new Font("SAN_SERIF", Font.PLAIN, 12));
	helpButton.setBounds(200, 210, 140, 30);
        helpButton.addActionListener(this);
	jp2.add(helpButton);
        
        
        
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            
        }else if(e.getSource() == signupButton){
            this.setVisible(false);
            new SignUp().setVisible(true);
        }else if(e.getSource() == helpButton){
            this.setVisible(false);
            new ForgetPassword().setVisible(true);
        }
    }
}
