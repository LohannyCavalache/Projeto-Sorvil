package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lohanny
 */

public class ListaEstante {
    
    public static final List<LivrosEstante> listaLivrosEstante = new ArrayList<>();
    
    public static List<LivrosEstante> listar(){
        
        return listaLivrosEstante;
    }
    
    public static void Adicionar(LivrosEstante livrosEstante){
        
        listaLivrosEstante.add(livrosEstante);
    }
}
