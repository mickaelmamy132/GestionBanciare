/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_bancaire2;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.*;

public class liaison{
    public static void main(String arg[]) throws ClassNotFoundException
    {
        PreparedStatement prt;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
            System.out.println("succes");
        } 
        catch(SQLException e)
        {
            System.out.println("erreur");
            //e.printStackTrace();
        }
    }
}
