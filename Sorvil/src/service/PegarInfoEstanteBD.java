package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.LivrosEstante;

/**
 *
 * @author Lohanny
 */

public class PegarInfoEstanteBD {
    
    String sql = "SELECT * FROM estantes";
    ConectarBD dados = new ConectarBD();
    
    public List<LivrosEstante> getLivrosEstante(){
        
        Connection conn = dados.conectar();
        try{
            PreparedStatement psstmt = conn.prepareStatement(sql);
            ResultSet rs = psstmt.executeQuery();
            List<LivrosEstante> listaLivrosEstante = new ArrayList<>();
            
            while(rs.next()){
                LivrosEstante estante = new LivrosEstante();
                estante.setNomeLivro(rs.getString("nome"));
                estante.setNomeAutor(rs.getString("nome_autor"));
                estante.setEditora(rs.getString("editora"));
                estante.setQntdPaginas(rs.getInt("quantidade_paginas"));
                listaLivrosEstante.add(estante);
            }
            
            return listaLivrosEstante;
        }catch(SQLException e){
            return null;
        }
    }
}
