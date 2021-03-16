/*
 * To view the booked hotel details.
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

/**
 *
 * @author kappa
 */
public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JLabel usernameField, idField, numberField, phoneField, priceField, personsTextField, daysTextField, acField, foodField, hotelField;
    
    JButton back;

    public ViewBookedHotel(String user) {
        
        setBounds(450, 200, 850, 525);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        JLabel title = new JLabel("BOOKED HOTEL DETAIL");
        title.setBounds(250, 5, 300, 30);
        title.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
        add(title);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 60, 450, 350);
        add(image);
        
        
        
        JLabel username = new JLabel("Username : ");
        username.setBounds(25, 75, 130, 20);
        username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(username);
        
        usernameField = new JLabel();
        usernameField.setBounds(160, 75, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(usernameField);
        
        
        
        JLabel choose = new JLabel("Choose Hotel :");
        choose.setBounds(25, 115, 130, 20);
        choose.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(choose);
        
        hotelField = new JLabel();
        hotelField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        hotelField.setBounds(160, 115, 180, 20);
        add(hotelField);        
        
        
        
        JLabel persons = new JLabel("Total Persons :");
        persons.setBounds(25, 155, 130, 20);
        persons.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(persons);
        
        personsTextField = new JLabel();
        personsTextField.setBounds(160, 155, 150, 23);
        personsTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(personsTextField);
        
        
        
        JLabel days = new JLabel("No. of Days :");
        days.setBounds(25, 195, 130, 20);
        days.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(days);
        
        daysTextField = new JLabel();
        daysTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        daysTextField.setBounds(160, 195, 150, 23);
        add(daysTextField);
        
        
        
        JLabel hoteltype = new JLabel("A/C :");
        hoteltype.setBounds(25, 235, 130, 20);
        hoteltype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(hoteltype);
        
        acField = new JLabel();
        acField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        acField.setBounds(160, 235, 150, 20);
        add(acField);
        
        
        
        JLabel utility = new JLabel("Food Included :");
        utility.setBounds(25, 275, 130, 20);
        utility.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(utility);
        
        foodField = new JLabel();
        foodField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        foodField.setBounds(160, 275, 150, 20);
        add(foodField);
        
        
        
        JLabel id = new JLabel("ID : ");
        id.setBounds(25, 315, 130, 20);
        id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(id);
        
        idField = new JLabel();
        idField.setBounds(160, 315, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(idField);
        
        
        
        JLabel number = new JLabel("Number : ");
        number.setBounds(25, 355, 130, 20);
        number.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(number);
        
        numberField = new JLabel();
        numberField.setBounds(160, 355, 150, 20);
        numberField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(numberField);
        
        
        
        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(25, 395, 130, 20);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phone);
        
        phoneField = new JLabel();
        phoneField.setBounds(160, 395, 150, 20);
        phoneField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phoneField);
        
        
        
        JLabel price = new JLabel("Total Price : ");
        price.setBounds(25, 435, 130, 20);
        price.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(price);
        
        priceField = new JLabel();
        priceField.setBounds(160, 435, 150, 20);
        priceField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(priceField);
        
        
        
        back = new JButton("Back");
        back.setBounds(350, 435, 450, 24);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);
        
        
        
        try {
            
            Conn connect = new Conn();
            
            String sql = "select * from bookHotel where username = '"+user+"'";
            
            ResultSet rs = connect.statement.executeQuery(sql);
            
            while(rs.next()){
                usernameField.setText(rs.getString("username"));
                hotelField.setText(rs.getString("hotel"));
                personsTextField.setText(rs.getString("persons"));
                daysTextField.setText(rs.getString("days"));
                acField.setText(rs.getString("ac"));
                foodField.setText(rs.getString("food"));
                idField.setText(rs.getString("id"));
                numberField.setText(rs.getString("number"));
                phoneField.setText(rs.getString("phone"));
                priceField.setText(rs.getString("cost"));                
            }
            
        } catch (Exception x) {
            x.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new ViewBookedHotel("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == back){
            
            this.setVisible(false);
            
        }
        
    }
    
}
