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
        Grafo g = new Grafo(4);
        System.out.println("Arestas");
        g.imprimeGrafo();
        System.out.println("  ---  ");
        System.out.println("Vizinhos de um Vertice");
//        for (Vertice v: g.getVertices()) {
//            v.imprimeVizinhos();
//        }
        g.buscaEmProfundidade();
        System.out.println("É árvore: " + g.isArvore());
        System.out.println("Tem ciclo: " +g.hasCiclo());
        System.out.println("É bipartido: " +g.isBipartido());
        System.out.println("É conexo: " +g.isConexo());
            
        
    }
    
}
