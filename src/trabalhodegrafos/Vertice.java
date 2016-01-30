/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodegrafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class Vertice {
    String letra = null;
    int numero = 0;
    List<Vertice> vizinhos = new ArrayList<>();
    
    public Vertice(String letra){
        this.letra=letra;
    }
    public Vertice(int numero){
        this.numero=numero;
    }
    public void addVizinho(Vertice v){
        vizinhos.add(v);
    }
    
    public void imprimeVizinhos(){
        for (int i = 0; i < vizinhos.size(); i++) {
            System.out.println(this.numero+ "-> " + vizinhos.get(i).numero);
        }
        
    }
}
