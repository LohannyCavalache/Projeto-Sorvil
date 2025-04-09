/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lohcfsz
 */
public class LivrosEstante {
    private String nomeLivro;
    private String nomeAutor;
    private String editora;
    private int qntdPaginas;
    
    public String getNomeLivro(){
        return nomeLivro;
    }
    
    public void setNomeLivro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }
    
    public String getNomeAutor(){
        return nomeAutor;
    }
    
    public void setNomeAutor(String nomeAutor){
        this.nomeAutor = nomeAutor;
    }
    
    public String getEditora(){
        return editora;
    }
    
    public void setEditora(String editora){
        this.editora = editora;
    }
    
    public int getQntdPaginas(){
        return qntdPaginas;
    }
    
    public void setQntdPaginas(int qntdPaginas){
        this.qntdPaginas = qntdPaginas;
    }
}
