package model;

/**
 *
 * @author Lohanny
 */

public class Livros{
    private String nomeLivro;
    private String isbn;
    private Object dataPublicacao;
    private String nomeAutor;
    private String editora;
    private int qntdPaginas;
    
    public String getNomeLivro(){
        return nomeLivro;
    }
    
    public void setNomeLivro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }
    
    public String getISBN(){
        return isbn;
    }
    
    public void setISBN(String isbn){
        this.isbn = isbn;
    }
    
    public Object getDataPublicacao(){
        return dataPublicacao;
    }
    
    public void setDataPublicacao(Object dataPublicacao){
        this.dataPublicacao = dataPublicacao;
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
