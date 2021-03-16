/*
 * View the Package That is Bought.
 */
package ttms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author kappa
 */
public class ViewPackage extends JFrame implements ActionListener{
    
    JLabel usernameField, idField, numberField, phoneField, priceField, personsTextField, packageField;
    
    JButton back;

    public ViewPackage(String user) {
        
        setBounds(450, 200, 750, 400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        JLabel title = new JLabel("BOOK PACKAGE");
        title.setBounds(250, 5, 300, 30);
        title.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
        add(title);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 50, 350, 250);
        add(image);
        
        
        
        JLabel username = new JLabel("Username : ");
        username.setBounds(25, 75, 150, 20);
        username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(username);
        
        usernameField = new JLabel();
        usernameField.setBounds(190, 75, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(usernameField);
        
        
        
        JLabel choose = new JLabel("Package :");
        choose.setBounds(25, 115, 150, 20);
        choose.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(choose);
        
        packageField = new JLabel();
        packageField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        packageField.setBounds(190, 115, 150, 20);
        add(packageField);
        
        
        
        JLabel persons = new JLabel("Total Persons :");
        persons.setBounds(25, 155, 150, 20);
        persons.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(persons);
        
        personsTextField = new JLabel();
        personsTextField.setBounds(190, 155, 150, 20);
        personsTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(personsTextField);
        
        
        
        JLabel id = new JLabel("ID : ");
        id.setBounds(25, 195, 150, 20);
        id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(id);
        
        idField = new JLabel();
        idField.setBounds(190, 195, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(idField);
        
        
        
        JLabel number = new JLabel("Number : ");
        number.setBounds(25, 235, 150, 20);
        number.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(number);
        
        numberField = new JLabel();
        numberField.setBounds(190, 235, 150, 20);
        numberField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(numberField);
        
        
        
        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(25, 275, 150, 20);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phone);
        
        phoneField = new JLabel();
        phoneField.setBounds(190, 275, 150, 20);
        phoneField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phoneField);
        
        
        
        JLabel price = new JLabel("Total Price : ");
        price.setBounds(25, 315, 150, 20);
        price.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(price);
        
        priceField = new JLabel();
        priceField.setBounds(190, 315, 150, 20);
        priceField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(priceField);
        
        
        
        back = new JButton("Back");
        back.setBounds(590, 315, 115, 24);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);
        
        
        
        try {
            
            Conn connect = new Conn();
            
            String sql = "select * from bookpackage where username = '"+user+"'";
            
            ResultSet rs = connect.statement.executeQuery(sql);
            
            while(rs.next()){
                 usernameField.setText(rs.getString("username"));
                 idField.setText(rs.getString("id"));
                 numberField.setText(rs.getString("number"));
                 phoneField.setText(rs.getString("phone"));
                 priceField.setText(rs.getString("price"));
                 personsTextField.setText(rs.getString("person"));
                 packageField.setText(rs.getString("package"));
                 
            }
            
        } catch (Exception x) {
            x.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new ViewPackage("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back){
            this.setVisible(false);
        }
        
    }
    
}
