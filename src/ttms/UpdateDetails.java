/*
 * Upadte Customer Details.
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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author kappa
 */
public class UpdateDetails extends JFrame implements ActionListener{
    
    JTextField textField, numberField, nameField, countryField, addressField, phoneField, mailField, choiceField;

    JButton update, back;

    Choice c1;

    JRadioButton maleRadio, femaleRadio;
    
    String user = null;

    public UpdateDetails(String usrname) {
        
        user = usrname;        

        setBounds(450, 200, 700, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading = new JLabel("UPDATE CUSTOMER DETAILS");
        heading.setBounds(50, 10, 300, 25);
        heading.setLayout(null);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        

        JLabel username = new JLabel("Username : ");
        username.setLayout(null);
        username.setBounds(25, 45, 100, 25);
        add(username);

        textField = new JTextField();
        textField.setLayout(null);
        textField.setBounds(175, 45, 200, 25);
        add(textField);
        
        

        JLabel id = new JLabel("ID : ");
        id.setLayout(null);
        id.setBounds(25, 85, 100, 25);
        add(id);
        
        choiceField = new JTextField();
        choiceField.setLayout(null);
        choiceField.setBounds(175, 85, 100, 25);
        add(choiceField);

        c1 = new Choice();
        c1.setFont(new Font("Tohama", Font.BOLD, 12));
        c1.add("PassPort");
        c1.add("Driver License");
        c1.add("Birth Certificate");
        c1.add("State ID");
        c1.setBounds(275, 85, 100, 25);
        add(c1);
        
        

        JLabel number = new JLabel("Number : ");
        number.setLayout(null);
        number.setBounds(25, 125, 100, 25);
        add(number);

        numberField = new JTextField();
        numberField.setLayout(null);
        numberField.setBounds(175, 125, 200, 25);
        add(numberField);
        
        

        JLabel name = new JLabel("Name : ");
        name.setLayout(null);
        name.setBounds(25, 165, 100, 25);
        add(name);

        nameField = new JTextField();
        nameField.setLayout(null);
        nameField.setBounds(175, 165, 200, 25);
        add(nameField);
        
        

        JLabel gender = new JLabel("Gender : ");
        gender.setLayout(null);
        gender.setBounds(25, 205, 100, 25);
        add(gender);

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(175, 205, 95, 25);
        add(maleRadio);

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(280, 205, 95, 25);
        add(femaleRadio);
        
        

        JLabel country = new JLabel("Country : ");
        country.setLayout(null);
        country.setBounds(25, 245, 100, 25);
        add(country);

        countryField = new JTextField();
        countryField.setLayout(null);
        countryField.setBounds(175, 245, 200, 25);
        add(countryField);
        
        

        JLabel address = new JLabel("Address : ");
        address.setLayout(null);
        address.setBounds(25, 285, 100, 25);
        add(address);

        addressField = new JTextField();
        addressField.setLayout(null);
        addressField.setBounds(175, 285, 200, 25);
        add(addressField);
        
        

        JLabel phone = new JLabel("Phone : ");
        phone.setLayout(null);
        phone.setBounds(25, 325, 100, 25);
        add(phone);

        phoneField = new JTextField();
        phoneField.setLayout(null);
        phoneField.setBounds(175, 325, 200, 25);
        add(phoneField);
        
        

        JLabel mail = new JLabel("Email : ");
        mail.setLayout(null);
        mail.setBounds(25, 365, 100, 25);
        add(mail);

        mailField = new JTextField();
        mailField.setLayout(null);
        mailField.setBounds(175, 365, 200, 25);
        add(mailField);
        
        

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/update.png"));
        Image toCon = image.getImage().getScaledInstance(200, 350, Image.SCALE_DEFAULT);
        ImageIcon newImage = new ImageIcon(toCon);
        JLabel i1 = new JLabel(newImage);
        i1.setBounds(425, 15, 200, 450);
        i1.setLayout(null);
        add(i1);
        
        

        update = new JButton("UPDATE");
        update.setLayout(null);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 415, 100, 25);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setLayout(null);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 415, 100, 25);
        back.addActionListener(this);
        add(back);
        
        
        
        //Adding the username and name field to the text boxes.
        try {
            String sql = "select * from customer where username = '"+user+"'";
            
            Conn connect = new Conn();
            ResultSet rs = connect.statement.executeQuery(sql);
            while(rs.next()){
                textField.setText(rs.getString("username"));
                choiceField.setText(rs.getString("id"));       
                numberField.setText(rs.getString("number"));
                nameField.setText(rs.getString("name"));
                String radio = rs.getString("gender");
                if("Male".equals(radio)){
                    maleRadio.setSelected(true);
                }else{
                    femaleRadio.setSelected(true);
                }
                countryField.setText(rs.getString("country"));
                addressField.setText(rs.getString("address"));
                phoneField.setText(rs.getString("phone"));
                mailField.setText(rs.getString("email"));
                
            }
            
        } catch (Exception l) {
            l.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new UpdateDetails("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == update) {
            String username = textField.getText();
            String id = (String) c1.getSelectedItem();
            String number = numberField.getText();
            String name = nameField.getText();
            String gender = null;
            if (maleRadio.isSelected()) {
                gender = "Male";
            } else if (femaleRadio.isSelected()) {
                gender = "Female";
            }
            String country = countryField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = mailField.getText();

            String sql = "update customer set username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone ='" + phone + "', email = '" + email + "'";

            try {
                Conn connect = new Conn();
                connect.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Customer Updated successfully!");
                this.setVisible(false);

            } catch (Exception s) {
                s.printStackTrace();
            }
        }else if(e.getSource() == back){
            
            this.setVisible(false);
            
        }
        
    }
    
}
