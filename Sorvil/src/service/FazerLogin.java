package service;

import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Usuarios;
import view.Login;
import view.TelaInicial;

/**
 *
 * @author Lohanny
 */

public class FazerLogin {
    
    Conexao conexao = new ConectarBD();
    VerificacaoLogin verifica = new VerificacaoLogin();
    Login login;
    Usuarios usuarios = new Usuarios();
    
    public FazerLogin(Login login){
        this.login = login;
    }
    
    public void fazerLogin(){
        
        if(login.getEmail().isEmpty() || login.getSenha().isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
        }
        
        String testeEmail = login.getEmail();
        boolean email = testeEmail.matches("[a-zA-Z]{1,100}@[a-zA-Z]{1,50}.[a-zA-Z]{3}");
        
        if(email == false){
            JOptionPane.showMessageDialog(null, "Campo de email deve seguir o formato padrão");
        }
        
        Connection conn = conexao.conectar();
        
        if(!login.getEmail().isEmpty() && !login.getSenha().isEmpty() && email == true){
            String loginCerto = login.getEmail();
            String senhaCerta = login.getSenha();

            usuarios.setEmail(loginCerto);
            usuarios.setSenha(senhaCerta);
        
            boolean verificado = verifica.verificarLogin(loginCerto, senhaCerta);
            
            if(verificado){
                JOptionPane.showMessageDialog(null, "Seja bem vindo!");
                TelaInicial inicio = new TelaInicial();
                inicio.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao fazer login.");
            }
        } 
        
        conexao.desconectar(conn);
    }
}
