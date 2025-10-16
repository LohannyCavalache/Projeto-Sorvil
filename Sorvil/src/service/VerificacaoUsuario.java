package service;

import javax.swing.JOptionPane;
import view.Cadastro;

/**
 *
 * @author Lohanny
 */

public class VerificacaoUsuario {
    
    Cadastro cadastro;
    
    public VerificacaoUsuario(Cadastro cadastro){
        this.cadastro = cadastro;
    }
    
    public boolean fazerVerificacao(){
        
        String testeNome = cadastro.getUsuario();
        String testeEmail = cadastro.getEmail();
        boolean nome = testeNome.matches("[a-zA-Z]{1,500}");
        boolean email = testeEmail.matches("[a-zA-Z]{1,100}@[a-zA-Z]{1,50}.[a-zA-Z]{3}");
        
        if(nome == false){
            JOptionPane.showMessageDialog(null, "Campo de nome deve conter apenas letras");
            return false;
        }else if(email == false){
            JOptionPane.showMessageDialog(null, "Campo de email deve seguir o formato padrão");
            return false;
        }
        
        if(cadastro.getUsuario().isEmpty() || cadastro.getEmail().isEmpty() || cadastro.getSenha().isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
            return false;
        }else{
            return true;
        }
    }
}
