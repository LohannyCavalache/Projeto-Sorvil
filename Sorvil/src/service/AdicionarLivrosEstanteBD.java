package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.LivrosEstante;

/**
 *
 * @author Lohanny
 */

public class AdicionarLivrosEstanteBD {
    
    Conexao conexao = new ConectarBD();

    public int adicionarLivroEstante(LivrosEstante estante){
        
        int status;
        PreparedStatement ps;
        
        try{
            Connection conn = conexao.conectar();
            ps = conn.prepareStatement("INSERT INTO estantes (nome, nome_autor, editora, quantidade_paginas) VALUES (?, ?, ?, ?)");
            ps.setString(1, estante.getNomeLivro());
            ps.setString(2, estante.getNomeAutor());
            ps.setString(3, estante.getEditora());
            ps.setInt(4, estante.getQntdPaginas());
            status = ps.executeUpdate();
            
            conexao.desconectar(conn);
            return status;
            
        }catch(SQLException ex){
            System.out.println("Não foi possível adicionar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
}
