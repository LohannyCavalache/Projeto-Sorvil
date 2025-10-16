package service;

import javax.swing.JOptionPane;
import view.AdicionaLivrosEstante;

/**
 *
 * @author Lohanny
 */

public class VerificarAdicao {
    
    AdicionaLivrosEstante adicao;
    
    public VerificarAdicao(AdicionaLivrosEstante adicao){
        this.adicao = adicao;
    }
    
    public boolean verificaAdicao(){
        if(adicao.getNomeLivro().isEmpty() || adicao.getAutor().isEmpty() || adicao.getEditora().isEmpty() || adicao.getPaginas().isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os dados devem ser preenchidos.");
            return false;
        }else{
            return true;
        }
    }
}
