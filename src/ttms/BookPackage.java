/*
 * Book a pacj=kage for the user.
 */
package ttms;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kappa
 */
public class BookPackage extends JFrame implements ActionListener{
    
    Choice c1;
    
    JLabel usernameField, idField, numberField, phoneField, priceField;
    
    JTextField personsTextField;
    
    JButton totalPrice, book, back;
    
    String u,i,n,p, t, tp;
    
    int total;

    public BookPackage(String user) {
        
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
        
        setBounds(450, 200, 750, 400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        JLabel title = new JLabel("BOOK PACKAGE");
        title.setBounds(250, 5, 300, 30);
        title.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
        add(title);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 50, 350, 250);
        add(image);
        
        
        
        JLabel username = new JLabel("Username : ");
        username.setBounds(25, 75, 150, 20);
        username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(username);
        
        usernameField = new JLabel(u);
        usernameField.setBounds(190, 75, 150, 20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(usernameField);
        
        
        
        JLabel choose = new JLabel("Choose Package :");
        choose.setBounds(25, 115, 150, 20);
        choose.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(choose);
        
        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Platinium Package");
        c1.add("Crown Package");
        c1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        c1.setBounds(190, 115, 150, 20);
        add(c1);
        
        
        
        JLabel persons = new JLabel("Total Persons :");
        persons.setBounds(25, 155, 150, 20);
        persons.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(persons);
        
        personsTextField = new JTextField("1");
        personsTextField.setBounds(190, 155, 150, 20);
        personsTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(personsTextField);
        
        
        
        JLabel id = new JLabel("ID : ");
        id.setBounds(25, 195, 150, 20);
        id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(id);
        
        idField = new JLabel(i);
        idField.setBounds(190, 195, 150, 20);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(idField);
        
        
        
        JLabel number = new JLabel("Number : ");
        number.setBounds(25, 235, 150, 20);
        number.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(number);
        
        numberField = new JLabel(n);
        numberField.setBounds(190, 235, 150, 20);
        numberField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(numberField);
        
        
        
        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(25, 275, 150, 20);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phone);
        
        phoneField = new JLabel(p);
        phoneField.setBounds(190, 275, 150, 20);
        phoneField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(phoneField);
        
        
        
        JLabel price = new JLabel("Total Price : ");
        price.setBounds(25, 315, 150, 20);
        price.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(price);
        
        priceField = new JLabel(t);
        priceField.setBounds(190, 315, 150, 20);
        priceField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(priceField);
        
        
        
        totalPrice = new JButton("Check Price");
        totalPrice.setBounds(350, 315, 115, 24);
        totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totalPrice.addActionListener(this);
        add(totalPrice);
        
        book = new JButton("BOOK NOW");
        book.setBounds(470, 315, 115, 24);
        book.setFont(new Font("Tahoma", Font.BOLD, 13));
        book.addActionListener(this);
        add(book);
        
        back = new JButton("Back");
        back.setBounds(590, 315, 115, 24);
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);

        
        
        
        
        
    }
    
    public static void main(String[] args) {
        new BookPackage("").setVisible(true);
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
                    String sql= "insert into bookpackage values ('"+u+"', "
                            + "'"+c1.getSelectedItem()+"', "
                            + "'"+personsTextField.getText()+"', "
                            + "'"+i+"', "
                            + "'"+n+"', "
                            + "'"+p+"', "
                            + "'"+priceField.getText()+"')";

                    connect.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Package Reserved! Please Pay to Complete Booking");
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
        
        String checking = c1.getSelectedItem();
            tp = personsTextField.getText();
            total = Integer.parseInt(tp);
            
            if(checking == "Gold Package"){
                
                if(total == 0){
                    t = "1200";
                }else{
                    int z = total * 1200;
                    total = z;
                    t = String.valueOf(z);
                }   
            
            }else if(checking == "Platinium Package"){
                
                if(total == 0){
                    t = "2000";
                }else{
                    int z = total * 2000;
                    total = z;
                    t = String.valueOf(z);
                }
            
            }else if(checking == "Crown Package"){
                
                if(total == 0){
                    t = "3500";
                }else{
                    int z = total * 3500;
                    total = z;
                    t = String.valueOf(z);
                }
            
            }
            priceField.setText("USD "+t+".00");
        
    }
    
}
