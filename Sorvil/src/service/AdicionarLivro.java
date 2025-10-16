package service;

import java.sql.Connection;
import javax.swing.JOptionPane;
import model.LivrosEstante;
import view.AdicionaLivrosEstante;
import view.Estante;

/**
 *
 * @author Lohanny
 */

public class AdicionarLivro {
    
    Estante estante;
    AdicionaLivrosEstante adicao;
    LivrosEstante livroEstante = new LivrosEstante();
    AdicionarLivrosEstanteBD adiciona = new AdicionarLivrosEstanteBD();
    AtualizarTabelaEstante atualiza = new AtualizarTabelaEstante(estante);
    Conexao conexao = new ConectarBD();
    
    public AdicionarLivro(AdicionaLivrosEstante adicao, AtualizarTabelaEstante atualiza){
        this.adicao = adicao;
        this.atualiza = atualiza;
    }
        
    public void AdicionarLivro(){
        
        VerificarAdicao verifica = new VerificarAdicao(adicao);
        Connection conn = conexao.conectar();
        boolean verificacao = verifica.verificaAdicao();
        
        if(verificacao == true){
            int resposta;
            
            livroEstante.setNomeLivro(adicao.getNomeLivro());
            livroEstante.setNomeAutor(adicao.getAutor());
            livroEstante.setEditora(adicao.getEditora());
            livroEstante.setQntdPaginas(Integer.parseInt(adicao.getPaginas()));
            resposta = adiciona.adicionarLivroEstante(livroEstante);
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
