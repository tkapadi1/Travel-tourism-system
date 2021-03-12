/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttms;

import java.sql.*;

/**
 *
 * @author kappa
 */
public class Conn {
    
    Connection connect;
    Statement statement;

    public Conn() {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ttms","root","Soneji777&T");
            
            statement = connect.createStatement();
            
        } catch (Exception e) {
        }
        
    }
   
}
