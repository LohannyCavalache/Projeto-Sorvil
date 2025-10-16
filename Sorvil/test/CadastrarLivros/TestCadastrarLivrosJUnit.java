package CadastrarLivros;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import model.Livros;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.ConectarBD;
import service.Conexao;
import service.AdicionarLivrosBD;

/**
 *
 * @author Lohanny
 */

public class TestCadastrarLivrosJUnit {
    
    public TestCadastrarLivrosJUnit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCadastrarLivros() throws SQLException{
        Conexao conexao = new ConectarBD();
        AdicionarLivrosBD adiciona = new AdicionarLivrosBD();
        
        String nome = "b";
        String isbn = "1234567891123";
        Date dataPublicacao = new Date(02/03/2013);
        String nomeAutor = "bb";
        String editora = "bbb";
        int qntdPaginas = 123;
  
        int resposta;
        
        Livros livros = new Livros();
        
        livros.setNomeLivro(nome);
        livros.setISBN(isbn);
        livros.setDataPublicacao(dataPublicacao);
        livros.setNomeAutor(nomeAutor);
        livros.setEditora(editora);
        livros.setQntdPaginas(qntdPaginas);
        resposta = adiciona.adicionarLivros(livros);

        String query = "SELECT id = 1 FROM livros";
        ResultSet rs;
        Connection conn = conexao.conectar();
        PreparedStatement pssmt = conn.prepareStatement(query);
        rs = pssmt.executeQuery();
        
        
    }
}
