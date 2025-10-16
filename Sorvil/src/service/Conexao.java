package service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lohanny
 */

public abstract class Conexao {
    public abstract Connection conectar();
    
    public void desconectar(Connection conn){
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível desconectar." + e.getMessage());
        }
    }
}
