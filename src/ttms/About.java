/*
 * To Show the copyright functionalities of the project.
 */
package ttms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kappa
 */
public class About extends JFrame implements ActionListener{
    
    String s = "";

    public About() {
        
        setBounds(550, 200, 500, 425);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Travel and Tourism management system.");
        heading.setBounds(50, 10, 400, 60);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setForeground(Color.red);
        add(heading);
        
        s = "                                    About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
                ;
        
        TextArea dialog = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        dialog.setEditable(false);
        dialog.setBounds(20, 80, 445, 265);
        add(dialog);
        
        JButton back = new JButton("BACK");
        back.setBounds(20, 355, 445, 20);
        back.addActionListener(this);
        add(back);
        
    }
    
    public static void main(String[] args) {
        new About().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
    
}
