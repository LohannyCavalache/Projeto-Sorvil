package service;

import javax.swing.JOptionPane;
import view.CadastroLivros;

/**
 *
 * @author Lohanny
 */

public class VerificacaoLivro {
    
    CadastroLivros cadastro;
    
    public VerificacaoLivro(CadastroLivros cadastro) {
        this.cadastro = cadastro;
    }

    public boolean verificarLivro(){
        if(cadastro.getNomeLivro().isEmpty() || cadastro.getISBN().isEmpty() || cadastro.getData().isEmpty() || cadastro.getAutor().isEmpty() || cadastro.getEditora().isEmpty() || cadastro.getQntdPaginas().isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
            return false;
        }else{
            return true;
        }
    }
}
