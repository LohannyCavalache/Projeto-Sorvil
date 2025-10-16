package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lohanny
 */

public class VerificacaoLogin {
    
    Conexao conexao = new ConectarBD();
        
    public boolean verificarLogin(String email, String senha){
        
        Connection conn = conexao.conectar();
        
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
        
        return false;
    }
}
