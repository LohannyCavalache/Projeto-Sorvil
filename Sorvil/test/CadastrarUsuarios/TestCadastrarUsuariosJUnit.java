package CadastrarUsuarios;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.CadastrarUsuarios;
import service.ConectarBD;
import service.Conexao;
import view.Cadastro;
import model.Usuarios;
import service.AdicionarUsuariosBD;

/**
 *
 * @author Lohanny
 */

public class TestCadastrarUsuariosJUnit {
    
    public TestCadastrarUsuariosJUnit() {
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
    public void testCadastrarUsuarios() throws SQLException{
        Cadastro cadastro = new Cadastro();
        CadastrarUsuarios cadastrar = new CadastrarUsuarios(cadastro);
        Conexao conexao = new ConectarBD();
        AdicionarUsuariosBD adiciona = new AdicionarUsuariosBD();
        
        String nome = "b";
        String email = "b@gmail.com";
        String senha = "456";
        
        
        
        int resposta;
        
        Usuarios usuario = new Usuarios();
        
        usuario.setNomeUsuario(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        resposta = adiciona.adicionarUsuarios(usuario);

        String query = "SELECT id = 1 FROM usuarios";
        ResultSet rs;
        Connection conn = conexao.conectar();
        PreparedStatement pssmt = conn.prepareStatement(query);
        rs = pssmt.executeQuery();
        
        
    }
}
