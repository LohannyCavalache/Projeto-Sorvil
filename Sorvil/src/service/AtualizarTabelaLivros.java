package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Livros;
import view.TelaInicial;

/**
 *
 * @author Lohanny
 */

public class AtualizarTabelaLivros extends AtualizaTabelas{

    TelaInicial inicio;
    public AtualizarTabelaLivros(TelaInicial inicio) {
       this.inicio = inicio;
    }
    
    
    PegarInfoLivrosBD info = new PegarInfoLivrosBD();
    Conexao conexao = new ConectarBD();
    
    
    
    @Override
    public void atualiza() {
        try{
            Connection conn = conexao.conectar();
            
            if(conn != null){
                String sql = "SELECT * FROM livros";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                List<Livros> listaLivros = info.getLivros();
                
                DefaultTableModel modeloTabela = (DefaultTableModel) inicio.getTabela();
                modeloTabela.setNumRows(0);
            
                for(Livros livros : listaLivros){
                    Object[] obj = new Object[]{
                        livros.getNomeLivro(), 
                        livros.getISBN(), 
                        livros.getDataPublicacao(), 
                        livros.getNomeAutor(), 
                        livros.getEditora(), 
                        livros.getQntdPaginas()
                    };
                    modeloTabela.addRow(obj);
                }
            
                rs.close();
                conexao.desconectar(conn);
            }   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao listar tabela." + e.getMessage());
        }
    }
}
