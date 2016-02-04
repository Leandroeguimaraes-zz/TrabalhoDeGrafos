package trabalhodegrafos;

public class Main {
    
    public static void main(String[] args) {
          Grafo g = new Grafo();
          
          System.out.println("Grafo");
          g.imprimeGrafo();
          
          System.out.println("Arvore");
          g.buscaEmProfundidade();
          g.imprimeArvore();
          
          System.out.println("\nAresta de Retorno :");
          g.imprimeArestaDeRetorno();
          
          g.getBlocos().imprimeBlocos();
          
          System.out.println("É conexo? \n"+g.isConexoParaLista());
          System.out.println("É Arvore?\n" + g.isArvore());
          System.out.println("É Bipartido?\n "+ g.isBipartido());
          System.out.println("Tem ciclo? \n"+ g.hasCiclo());
          System.out.println("É Circuito Euleriano?\n"+ g.isCircuitoEuleriano());
          
          System.out.println("Articulação :");
          g.imprimeArticulacao();
          
          System.out.println("\nPonte: ");
          g.imprimePonte();
          
          g.buscaCircuitoEuleriano();
          
//          System.out.println("----------------------------");
//          System.out.println(g.getCircuitoEuleriano());
//          
//          g.buscaCircuitoEuleriano();
    }
}
