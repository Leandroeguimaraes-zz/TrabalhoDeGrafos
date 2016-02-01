/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodegrafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Leandro
 */
public class Main {
    private List<Vertice> vertices = new ArrayList<>();
    private List<Aresta> arestas = new ArrayList<>();
    private Blocos blocos = new Blocos();
    private Bloco bloco;
    private Stack<Aresta> pilha = new Stack<>();

    private boolean bipartido = true;

    private static int t;
    
    
    public  void criaVertices(){
         Vertice a = new Vertice(1);
         Vertice b = new Vertice(2);
         Vertice c = new Vertice(3);
         Vertice d = new Vertice(4);
         Vertice e = new Vertice(5);
         Vertice f = new Vertice(6);
         Vertice g = new Vertice(7);
         
         a.addVizinho(b);
         a.addVizinho(c);
         a.addVizinho(d);
         
         b.addVizinho(a);
         b.addVizinho(d);
         
         c.addVizinho(a);
         c.addVizinho(d);
         c.addVizinho(e);
         
         d.addVizinho(b);
         d.addVizinho(c);
         d.addVizinho(a);
         
         e.addVizinho(c);
         e.addVizinho(f);
         e.addVizinho(g);
         
         f.addVizinho(e);
         f.addVizinho(g);
         
         g.addVizinho(e);
         g.addVizinho(f);
         
         buscaEmProfundidade(e);
         System.out.println("\nArticulações: ");
         blocos.identificaArticulacao();
         System.out.println("\n Pontes: ");
         blocos.identificaPontes();
    }
    private void buscaEmProfundidade(Vertice v) {
        t++;
        v.setPE(t);
        v.setBack(v.getPE());
        List<Vertice> vizinhos = v.getVizinhos();
        for (Vertice w : vizinhos) {
            if (w.getPE() == 0) {
                w.setFoiVisitado(true);
                w.setPai(v);
                System.out.print(v.getNumero() + "-> " + w.getNumero() + " -> ");
                pilha.add(new Aresta(v, w)); // empilhar vw
                w.setCor(1 - v.getCor());
                buscaEmProfundidade(w);
                
                if (w.getBack() >= v.getPE()) { // se back(w)>=PE(v) desempilhar e imprimir tudo até vw
                    Aresta a = new Aresta(v, w);
                    System.out.println("\nBloco: ");
                    bloco = new Bloco();
                    while (a.comparaAresta(pilha.peek()) == false) {
                       
                        Aresta apilha = pilha.pop();
                        bloco.add(apilha);  // adicionando arestas ao bloco
                        System.out.print(apilha.getVerticeA().getNumero() + "-" + apilha.getVerticeB().getNumero() + ",");
                        
                    }
                    Aresta apilha2 = pilha.pop();
                    bloco.add(apilha2);   // adicionando arestas ao bloco
                    System.out.print(apilha2.getVerticeA().getNumero() + "-" + apilha2.getVerticeB().getNumero() + ",");
                    blocos.addBloco(bloco); // no fim, adiciona todo o bloco a lista de blocos.
                }
                
                v.setBack(Math.min(v.getBack(), w.getBack()));
//                if(w.getBack()!=0){
//                    if(v.getBack() != w.getBack()){
//                        System.out.println("Ponte :" + v.getNumero() +"-"+ w.getNumero());
//                        System.out.println("Articulação: "+ v.getNumero());
//                    }
//                }
            } else {
                if (w.getPS() == 0 && v.getPai() != null && v.getPai().getNumero() != w.getNumero()) { 
                    w.addArestaDeRetorno(v);    // aresta de retorno
                    System.out.println("\n Aresta de Retorno = " + v.getNumero() +" --> " + w.getNumero() );
                    pilha.add(new Aresta(v,w)); // empilhar vw
                    v.setBack(Math.min(v.getBack(), w.getPE()));
                    if (w.getCor() != v.getCor()) {
                        this.bipartido = false;
                    }
                }
            }
        }
        t++;
        v.setPS(t);
    }
    
    public static void main(String[] args) {
        Main m = new Main();
//        Grafo g = new Grafo(5);
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
         m.criaVertices();
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
