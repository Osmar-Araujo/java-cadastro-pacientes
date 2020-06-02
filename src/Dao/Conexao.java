
package Dao;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexao {
    
    public static Connection conectar() throws ClassNotFoundException{
        
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql"
                    + "://localhost:5432/","postgres","mar1212");
            
            return con;
            
        }
        catch(SQLException error)
        {
            JOptionPane.showMessageDialog(null, error);
            
            return null;
        }
    }
}
