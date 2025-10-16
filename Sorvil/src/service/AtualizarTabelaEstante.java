package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LivrosEstante;
import view.Estante;

/**
 *
 * @author Lohanny
 */

public class AtualizarTabelaEstante extends AtualizaTabelas{
    
    Estante estante;
    public AtualizarTabelaEstante(Estante estante){
        this.estante = estante;
    }
    
    PegarInfoEstanteBD info = new PegarInfoEstanteBD();
    Conexao conexao = new ConectarBD();
    
    @Override
    public void atualiza() {
        try{
            Connection conn = conexao.conectar();
            
            if(conn != null){
                String sql = "SELECT * FROM estantes";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                List<LivrosEstante> listaLivrosEstante = info.getLivrosEstante();
                
                DefaultTableModel modeloTabela = (DefaultTableModel) estante.getTabela();
                modeloTabela.setNumRows(0);
            
                for(LivrosEstante livroEstante : listaLivrosEstante){
                    Object[] obj = new Object[]{
                        livroEstante.getNomeLivro(),
                        livroEstante.getNomeAutor(),
                        livroEstante.getEditora(),
                        livroEstante.getQntdPaginas()
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
