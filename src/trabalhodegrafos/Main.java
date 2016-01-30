/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodegrafos;

import java.util.List;

/**
 *
 * @author Leandro
 */
public class Main {

    
    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.geraGrafo();
        System.out.println("Arestas");
        g.imprimeGrafo();
        System.out.println("  ---  ");
        System.out.println("Vizinhos de um Vertice");
        for (Vertice v: g.getVertices()) {
            v.imprimeVizinhos();
        }
            
        
    }
    
}
