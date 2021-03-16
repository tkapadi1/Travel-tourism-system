/*
 * Delete Customer Details from the DataBase and Starting the App again.
 */
package ttms;

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
import javax.swing.JOptionPane;

/**
 *
 * @author kappa
 */
public class DeleteCustomer extends JFrame implements ActionListener{
    
    JLabel textField, numberField, nameField, countryField, addressField, phoneField, mailField, choiceField, radioField;
    
    JButton back, delete;
    
    String u, i, no, nm, c, a, p, m, g;
    
    String user = null;

    public DeleteCustomer(String user) {        
        
        //Adding the username and name field to the text boxes.
        try {
            String sql = "select * from customer where username = '"+user+"'";
            
            Conn connect = new Conn();
            ResultSet rs = connect.statement.executeQuery(sql);
            while(rs.next()){
                u = rs.getString("username");
                i = (rs.getString("id"));       
                no = (rs.getString("number"));
                nm = (rs.getString("name"));
                g = (rs.getString("gender"));
                c = (rs.getString("country"));
                a = (rs.getString("address"));
                p = (rs.getString("phone"));
                m = (rs.getString("email"));
                
            }
            
        } catch (Exception l) {
            l.printStackTrace();
        }
        
        setBounds(450, 200, 700, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading = new JLabel("CUSTOMER DETAILS");
        heading.setBounds(200, 10, 300, 25);
        heading.setLayout(null);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        

        JLabel username = new JLabel("Username : ");
        username.setLayout(null);
        username.setBounds(25, 45, 100, 25);
        add(username);

        textField = new JLabel(u);
        textField.setLayout(null);
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setBounds(175, 45, 200, 25);
        add(textField);
        
        

        JLabel id = new JLabel("ID : ");
        id.setLayout(null);
        id.setBounds(25, 85, 100, 25);
        add(id);
        
        choiceField = new JLabel(i);
        choiceField.setLayout(null);
        choiceField.setFont(new Font("Tahoma", Font.BOLD, 15));
        choiceField.setBounds(175, 85, 200, 25);
        add(choiceField);
        
        

        JLabel number = new JLabel("Number : ");
        number.setLayout(null);
        number.setBounds(25, 125, 100, 25);
        add(number);

        numberField = new JLabel(no);
        numberField.setLayout(null);
        numberField.setFont(new Font("Tahoma", Font.BOLD, 15));
        numberField.setBounds(175, 125, 200, 25);
        add(numberField);
        
        

        JLabel name = new JLabel("Name : ");
        name.setLayout(null);
        name.setBounds(25, 165, 100, 25);
        add(name);

        nameField = new JLabel(nm);
        nameField.setLayout(null);
        nameField.setFont(new Font("Tahoma", Font.BOLD, 15));
        nameField.setBounds(175, 165, 200, 25);
        add(nameField);
        
        

        JLabel gender = new JLabel("Gender : ");
        gender.setLayout(null);
        gender.setBounds(25, 205, 100, 25);
        add(gender);
        
        radioField = new JLabel(g);
        radioField.setLayout(null);
        radioField.setFont(new Font("Tahoma", Font.BOLD, 15));
        radioField.setBounds(175, 205, 200, 25);
        add(radioField);
        
        

        JLabel country = new JLabel("Country : ");
        country.setLayout(null);
        country.setBounds(25, 245, 100, 25);
        add(country);

        countryField = new JLabel(c);
        countryField.setLayout(null);
        countryField.setFont(new Font("Tahoma", Font.BOLD, 15));
        countryField.setBounds(175, 245, 200, 25);
        add(countryField);
        
        

        JLabel address = new JLabel("Address : ");
        address.setLayout(null);
        address.setBounds(25, 285, 100, 25);
        add(address);

        addressField = new JLabel(a);
        addressField.setLayout(null);
        addressField.setFont(new Font("Tahoma", Font.BOLD, 15));
        addressField.setBounds(175, 285, 200, 25);
        add(addressField);
        
        

        JLabel phone = new JLabel("Phone : ");
        phone.setLayout(null);
        phone.setBounds(25, 325, 100, 25);
        add(phone);

        phoneField = new JLabel(p);
        phoneField.setLayout(null);
        phoneField.setFont(new Font("Tahoma", Font.BOLD, 15));
        phoneField.setBounds(175, 325, 200, 25);
        add(phoneField);
        
        

        JLabel mail = new JLabel("Email : ");
        mail.setLayout(null);
        mail.setBounds(25, 365, 100, 25);
        add(mail);

        mailField = new JLabel(m);
        mailField.setLayout(null);
        mailField.setFont(new Font("Tahoma", Font.BOLD, 15));
        mailField.setBounds(175, 365, 200, 25);
        add(mailField);
        
        

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/delete.png"));
        Image toCon = image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon newImage = new ImageIcon(toCon);
        JLabel i1 = new JLabel(newImage);
        i1.setBounds(425, 80, 200, 300);
        i1.setLayout(null);
        add(i1);
        
        

        delete = new JButton("DELETE");
        delete.setLayout(null);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(150, 415, 100, 25);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setLayout(null);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 415, 100, 25);
        back.addActionListener(this);
        add(back);
        
    }
    
    public static void main(String[] args) {
        new DeleteCustomer("tkapadi1").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back){
            this.setVisible(false);
        }else if(e.getSource() == delete){
            
            try {
                
                Conn connect = new Conn();
                
                //String sql = "delete from "+table[i]+" where username = '"+u+"'";
                String[] table = new String[]{"account", 
                    "bookhotel", 
                    "bookpackage", 
                    "customer"
                };
                
                for (int j = 0; j < 4; j++) {
                    connect.statement.executeUpdate("delete from "+table[j]+" where username = '"+u+"'");
                }
                
                JOptionPane.showMessageDialog(null, "User Account deleted Successfully from the Databeses!");
                
                System.exit(0);
                
            } catch (Exception x) {
                x.printStackTrace();
            }
            
        }
        
    }
    
}
