/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lohcfsz
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
