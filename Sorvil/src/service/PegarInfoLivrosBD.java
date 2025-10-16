package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livros;

/**
 *
 * @author Lohanny
 */

public class PegarInfoLivrosBD {

    String sql = "SELECT * FROM livros";
    ConectarBD dados = new ConectarBD();
    
    public List<Livros> getLivros(){
        
        Connection conn = dados.conectar();
        try{
            PreparedStatement psstmt = conn.prepareStatement(sql);
            ResultSet rs = psstmt.executeQuery();
            List<Livros> listaLivros = new ArrayList<>();
            
            while(rs.next()){
                Livros livros = new Livros();
                livros.setNomeLivro(rs.getString("nome"));
                livros.setISBN(rs.getString("isbn"));
                livros.setDataPublicacao(rs.getString("data_publicacao"));
                livros.setNomeAutor(rs.getString("nome_autor"));
                livros.setEditora(rs.getString("editora"));
                livros.setQntdPaginas(rs.getInt("quantidade_paginas"));
                listaLivros.add(livros);
            }
            
            return listaLivros;
        }catch(SQLException e){
            return null;
        }
    }
}
