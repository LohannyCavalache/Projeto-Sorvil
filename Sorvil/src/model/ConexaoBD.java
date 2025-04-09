/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lohcfsz
 */
public class ConexaoBD {
    Connection conn;
    PreparedStatement ps;
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
    
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException ex){
            
        }
    }
    
    public int adicionarLivros(Livros livros){
        int status;
        try{
            conectar();
            ps = conn.prepareStatement("INSERT INTO livros (nome, isbn, data_publicacao, nome_autor, editora, quantidade_paginas) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, livros.getNomeLivro());
            ps.setString(2, livros.getISBN());
            ps.setObject(3, livros.getDataPublicacao());
            ps.setString(4, livros.getNomeAutor());
            ps.setString(5, livros.getEditora());
            ps.setInt(6, livros.getQntdPaginas());
            status = ps.executeUpdate();
            return status;
        }catch(SQLException ex){
            System.out.println("Não foi possível adicionar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
      
    public List<Livros> getLivros(){
        String sql = "SELECT * FROM livros";
        try{
            PreparedStatement psstmt = this.conn.prepareStatement(sql);
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
        }catch(Exception e){
            return null;
        }
    }
    
    public int adicionarUsuarios(CadastrarUsuarios usuarios){
        int status;
        try{
            conectar();
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
    
    public boolean verificarLogin(String email, String senha){
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
    
    public int adicionarLivroEstante(LivrosEstante estante){
        int status;
        try{
            conectar();
            ps = conn.prepareStatement("INSERT INTO estantes (nome, nome_autor, editora, quantidade_paginas) VALUES (?, ?, ?, ?)");
            ps.setString(1, estante.getNomeLivro());
            ps.setString(2, estante.getNomeAutor());
            ps.setString(3, estante.getEditora());
            ps.setInt(4, estante.getQntdPaginas());
            status = ps.executeUpdate();
            return status;
        }catch(SQLException ex){
            System.out.println("Não foi possível adicionar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public List<LivrosEstante> getLivrosEstante(){
        String sql = "SELECT * FROM estantes";
        try{
            PreparedStatement psstmt = this.conn.prepareStatement(sql);
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
        }catch(Exception e){
            return null;
        }
    }
}
