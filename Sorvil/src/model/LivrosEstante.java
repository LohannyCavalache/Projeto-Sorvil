package model;

/**
 *
 * @author Lohanny
 */

public class LivrosEstante extends Livros{
    private String nomeLivro;
    private String nomeAutor;
    private String editora;
    private int qntdPaginas;
    
    @Override
    public String getNomeLivro(){
        return nomeLivro;
    }
    
    @Override
    public void setNomeLivro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }
    
    @Override
    public String getNomeAutor(){
        return nomeAutor;
    }
    
    @Override
    public void setNomeAutor(String nomeAutor){
        this.nomeAutor = nomeAutor;
    }
    
    @Override
    public String getEditora(){
        return editora;
    }
    
    @Override
    public void setEditora(String editora){
        this.editora = editora;
    }
    
    @Override
    public int getQntdPaginas(){
        return qntdPaginas;
    }
    
    @Override
    public void setQntdPaginas(int qntdPaginas){
        this.qntdPaginas = qntdPaginas;
    }
}
