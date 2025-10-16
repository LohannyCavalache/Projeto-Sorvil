package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuarios;

/**
 *
 * @author Lohanny
 */

public class AdicionarUsuariosBD {
    
    Conexao conexao = new ConectarBD();

    public int adicionarUsuarios(Usuarios usuarios){
        
        int status;
        PreparedStatement ps;
        
        try{
            Connection conn = conexao.conectar();
            
            ps = conn.prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)");
            ps.setString(1, usuarios.getNomeUsuario());
            ps.setString(2, usuarios.getEmail());
            ps.setObject(3, usuarios.getSenha());
            status = ps.executeUpdate();
            
            return status;
        }catch(SQLException ex){
            System.out.println("Não foi possível adicionar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
}
