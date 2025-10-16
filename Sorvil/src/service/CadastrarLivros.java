package service;

import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Livros;
import view.CadastroLivros;
import view.TelaInicial;

/**
 *
 * @author Lohanny
 */

public class CadastrarLivros {
    
    TelaInicial inicio;
    CadastroLivros cadastro;
    Livros livros = new Livros();
    AdicionarLivrosBD adiciona = new AdicionarLivrosBD();
    AtualizarTabelaLivros atualiza = new AtualizarTabelaLivros(inicio);
    Conexao conexao = new ConectarBD();
    
    
    
    public CadastrarLivros(CadastroLivros cadastro, AtualizarTabelaLivros atualiza) {
        this.cadastro = cadastro;
        this.atualiza = atualiza;
    }
    
    public void cadastrarLivros(){
        
        VerificacaoLivro verifica = new VerificacaoLivro(cadastro);
        Connection conn = conexao.conectar();
        boolean verificacao = verifica.verificarLivro();

        if(verificacao == true){
            int resposta;
            
            livros.setNomeLivro(cadastro.getNomeLivro());
            livros.setISBN(cadastro.getISBN());
            livros.setDataPublicacao(cadastro.getData());
            livros.setNomeAutor(cadastro.getAutor());
            livros.setEditora(cadastro.getEditora());
            livros.setQntdPaginas(Integer.parseInt(cadastro.getQntdPaginas()));
            resposta = adiciona.adicionarLivros(livros);
            atualiza.atualiza();
            
            if(resposta == 1){
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso.");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados.");
            }
            
            conexao.desconectar(conn);
        } 
    }
}
