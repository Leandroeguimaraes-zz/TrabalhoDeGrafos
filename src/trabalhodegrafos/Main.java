/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodegrafos;

/**
 *
 * @author Leandro
 */
public class Main {
    
    public static void main(String[] args) {
          Grafo g = new Grafo();
          g.criaGrafoFixo();
          g.buscaEmProfundidade();
          
          System.out.println("------>"+g.isConexo());
          
//        System.out.println("Arestas");
//        g.imprimeGrafo();
//        System.out.println("  ---  ");
//        System.out.println("Vizinhos de um Vertice");
//        for (Vertice v: g.getVertices()) {
//            v.imprimeVizinhos();
//        }
//        System.out.println("Arestas de retornos");
//        g.imprimeArestasDeRetorno();
        
//        System.out.println("Arvore:");
//        g.buscaEmProfundidade();
       //  m.criaVertices();
//        System.out.println("\nArticulação: ");
//        g.imprimeArticulacao();
//          g.imprimePonte();
//        System.out.println("\n\nÉ árvore: " + g.isArvore());
//        System.out.println("Tem ciclo: " +g.hasCiclo());
//        System.out.println("É bipartido: " +g.isBipartido());
//        System.out.println("É conexo: " +g.isConexo());
//            
        
    }
    
}
