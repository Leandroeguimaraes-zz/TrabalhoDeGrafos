package grafos;

public class Main {

    public static void main(String[] args) {
    	Grafo g = new Grafo();
    	g.geraGrafo();
        g.buscaEmProfundidade();
        
        System.out.println("É árvore: " + g.isArvore());
        System.out.println("Tem ciclo: " +g.hasCiclo());
        System.out.println("É conexo: " +g.isConexo());
        System.out.println("É bipartido: " +g.isBipartido());
    }
    
}
