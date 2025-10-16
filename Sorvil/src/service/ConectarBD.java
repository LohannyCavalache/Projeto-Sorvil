package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lohanny
 */

public class ConectarBD extends Conexao{
    
    Connection conn;
    
    
    @Override
    public Connection conectar(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorvil","root","2403");
            System.out.println("Conexão realizada com sucesso");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco " + ex.getMessage());
        }
        
        return conn;
    }
}
