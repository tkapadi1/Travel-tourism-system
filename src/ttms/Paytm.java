/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttms;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author kappa
 */
public class Paytm extends JFrame  implements ActionListener{
    
    JEditorPane j;

    public Paytm(){
        
        j = new JEditorPane();
        j.setEditable(false);
        
        
        try {
            j.setPage("https://paytm.com/credit-card-bill-payment");
        } catch (IOException ex) {
            j.setContentType("text/html");
            j.setText("<html>Could not load, Error 404</html>");
        }
        
        add(j);
        JScrollPane p = new JScrollPane(j);
        getContentPane().add(p);
        
        JButton back = new JButton("BACK");
        back.setBounds(750, 10, 75, 30);
        back.addActionListener(this);
        j.add(back);
        
        setBounds(450, 200, 850, 650);
        
    }
    
    public static void main(String[] args) {
        new Paytm().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new Payment().setVisible(true);
    }
    
}
