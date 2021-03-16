/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.swing.JTextField;

/**
 *
 * @author kappa
 */
public class BookHotel extends JFrame implements ActionListener{
    
    Choice c1, ac, food;
    
    JLabel usernameField, idField, numberField, phoneField, priceField;
    
    JTextField personsTextField, daysTextField;
    
    JButton totalPrice, book, back;
    
    String u,i,n,p, tp;
    
    int total;

    public BookHotel(String user){
        
        try {
            
            Conn connect = new Conn();
            
            String sql = "select * from customer where username = '"+user+"'";
            
            ResultSet rs = connect.statement.executeQuery(sql);
            
            while(rs.next()){
                u = rs.getString("username");
                i = rs.getString("id");
                n = rs.getString("number");
                p = rs.getString("phone");
            }
            
        } catch (Exception x) {
            x.printStackTrace();
        }
        
        setBounds(450, 200, 850, 525);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        JLabel title = new JLabel("BOOK HOTEL");
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
        
        usernameField = new JLabel(u);
        usernameField.setBounds(160, 75, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(usernameField);
        
        
        
        JLabel choose = new JLabel("Choose Hotel :");
        choose.setBounds(25, 115, 130, 20);
        choose.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(choose);
        
        c1 = new Choice();
        String list = "select * from hotel";
        try {
            Conn cnt = new Conn();
            ResultSet as = cnt.statement.executeQuery(list);
            while(as.next()){
                c1.add(as.getString("name"));
                c1.setFont(new Font("Tahoma", Font.PLAIN, 15));
                c1.setBounds(160, 115, 180, 20);
                add(c1);
            }
        } catch (Exception e) {
        }
        
        
        
        
        
        JLabel persons = new JLabel("Total Persons :");
        persons.setBounds(25, 155, 130, 20);
        persons.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(persons);
        
        personsTextField = new JTextField("1");
        personsTextField.setBounds(160, 155, 150, 23);
        personsTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(personsTextField);
        
        
        
        JLabel days = new JLabel("No. of Days :");
        days.setBounds(25, 195, 130, 20);
        days.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(days);
        
        daysTextField = new JTextField("1");
        daysTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        daysTextField.setBounds(160, 195, 150, 23);
        add(daysTextField);
        
        
        
        JLabel hoteltype = new JLabel("A/C :");
        hoteltype.setBounds(25, 235, 130, 20);
        hoteltype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(hoteltype);
        
        ac = new Choice();
        ac.add("Yes");
        ac.add("No");
        ac.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ac.setBounds(160, 235, 150, 20);
        add(ac);
        
        
        
        JLabel utility = new JLabel("Food Included :");
        utility.setBounds(25, 275, 130, 20);
        utility.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(utility);
        
        food = new Choice();
        food.add("Yes");
        food.add("No");
        food.setFont(new Font("Tahoma", Font.PLAIN, 18));
        food.setBounds(160, 275, 150, 20);
        add(food);
        
        
        
        JLabel id = new JLabel("ID : ");
        id.setBounds(25, 315, 130, 20);
        id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(id);
        
        idField = new JLabel(i);
        idField.setBounds(160, 315, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(idField);
        
        
        
        JLabel number = new JLabel("Number : ");
        number.setBounds(25, 355, 130, 20);
        number.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(number);
        
        numberField = new JLabel(n);
        numberField.setBounds(160, 355, 150, 20);
        numberField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(numberField);
        
        
        
        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(25, 395, 130, 20);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phone);
        
        phoneField = new JLabel(p);
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
        
        
        
        totalPrice = new JButton("Check Price");
        totalPrice.setBounds(350, 435, 125, 24);
        totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalPrice.addActionListener(this);
        add(totalPrice);
        
        book = new JButton("BOOK NOW");
        book.setBounds(510, 435, 125, 24);
        book.setFont(new Font("Tahoma", Font.BOLD, 13));
        book.addActionListener(this);
        add(book);
        
        back = new JButton("Back");
        back.setBounds(675, 435, 125, 24);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);
        
        
        
        
        
    }
    
    public static void main(String[] args) {
        new BookHotel("").setVisible(true);
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            
            this.setVisible(false);
            
        }else if(e.getSource() == book){
            
            if(priceField.getText() == null){
                calculate();
            }
            if(p == null || i == null || u == null || n ==null){
                
                JOptionPane.showMessageDialog(null, "Incomplete Information. Please Fill all mandatory Information");
                
            }else{
                
                try {
                
                    Conn connect = new Conn();
                    String sql= "insert into bookHotel values ('"+u+"', "
                            + "'"+c1.getSelectedItem()+"', "
                            + "'"+personsTextField.getText()+"', "
                            + "'"+daysTextField.getText()+"', "
                            + "'"+ac.getSelectedItem()+"', "
                            + "'"+food.getSelectedItem()+"', "
                            + "'"+i+"', "
                            + "'"+n+"', "
                            + "'"+p+"', "
                            + "'"+priceField.getText()+"')";

                    connect.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Hotel Reserved! Please Pay to Complete Booking");
                    this.setVisible(false);

                } catch (Exception x) {
                    x.printStackTrace();
                }
                
            }
          
            
            
        }else if(e.getSource() == totalPrice){
            
            calculate();     
            
        }
    }
    
    public void calculate(){
        
        try {
                Conn connect = new Conn();
                String values = "select * from hotel where name = '"+c1.getSelectedItem()+"'";
                ResultSet ls = connect.statement.executeQuery(values);
                while(ls.next()){

                    int cost = Integer.parseInt(ls.getString("cost_per_day"));
                    int foodval = Integer.parseInt(ls.getString("food_charges"));
                    int acval = Integer.parseInt(ls.getString("ac_charges"));

                    int noperson = Integer.parseInt(personsTextField.getText());
                    int nodays = Integer.parseInt(daysTextField.getText());

                    String acprice = ac.getSelectedItem();
                    String foodprice = food.getSelectedItem();

                    if(nodays * noperson > 0){
                        int sum = 0;
                        sum += acprice.equals("Yes") ? acval : 0;
                        sum += foodprice.equals("Yes") ? foodval : 0;
                        sum += cost;
                        sum = sum * noperson * nodays;
                        sum = sum/75;  //USD Conversion.
                        priceField.setText("USD "+sum+".00");
                    }
                    else{
                        priceField.setText("Enter Valid Values");
                    }

                }
            } catch (Exception v) {
                v.printStackTrace();
            }
        
    }
    
}
