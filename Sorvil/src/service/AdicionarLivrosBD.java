package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Livros;

/**
 *
 * @author Lohanny
 */

public class AdicionarLivrosBD {
    
    Conexao conexao = new ConectarBD();

    public int adicionarLivros(Livros livros){
        
        int status;
        PreparedStatement ps;
        
        try{
            Connection conn = conexao.conectar();
            ps = conn.prepareStatement("INSERT INTO livros (nome, isbn, data_publicacao, nome_autor, editora, quantidade_paginas) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, livros.getNomeLivro());
            ps.setString(2, livros.getISBN());
            ps.setObject(3, livros.getDataPublicacao());
            ps.setString(4, livros.getNomeAutor());
            ps.setString(5, livros.getEditora());
            ps.setInt(6, livros.getQntdPaginas());
            status = ps.executeUpdate();
   
            conexao.desconectar(conn);
            return status;

        }catch(SQLException ex){
            System.out.println("Não foi possível adicionar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
}
