package service;

import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Usuarios;
import view.Cadastro;

/**
 *
 * @author Lohanny
 */

public class CadastrarUsuarios {
    
    Cadastro cadastro;
    VerificacaoUsuario verificacao;
    AdicionarUsuariosBD adiciona = new AdicionarUsuariosBD();
    Usuarios usuarios = new Usuarios();
    Conexao conexao = new ConectarBD();
    
    public CadastrarUsuarios(Cadastro cadastro){
        this.cadastro = cadastro;
        this.verificacao = new VerificacaoUsuario(cadastro);
    }
    
    public void cadastrarUsuario(){
        Connection conn = conexao.conectar();
        verificacao.fazerVerificacao();
        
        if(verificacao.fazerVerificacao() == true){
            int resposta;
            usuarios.setNomeUsuario(cadastro.getUsuario());
            usuarios.setEmail(cadastro.getEmail());
            usuarios.setSenha(cadastro.getSenha());
            resposta = adiciona.adicionarUsuarios(usuarios);
            
            if(resposta == 1){
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso.");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados.");
            }
            
            conexao.desconectar(conn);
        }
    }
}
