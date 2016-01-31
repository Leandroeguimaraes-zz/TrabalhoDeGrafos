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
public class Grafo {

    private List<Vertice> vertices = new ArrayList<>();
    private List<Aresta> arestas = new ArrayList<>();
    private Stack<Aresta> pilha = new Stack<>();

    private boolean bipartido = true;

    private static int t;

    public Grafo(int numVertices) {
        geraVertices(numVertices);
        geraArestas();
    }

    public void geraVertices(int numVertices) {
        for (int i = 1; i <= numVertices; i++) {
            this.vertices.add(new Vertice(i)); // valor que vai entrar no vertice
        }

    }

    public void geraArestas() {

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                if (Probabilidade.geraProbabilidade() && i < j) { // i<j evita aresta repetida
                    arestas.add(new Aresta(vertices.get(i), vertices.get(j)));

                    // adicionando agora pelo numero e não o vertice em si
                    vertices.get(i).addVizinho(vertices.get(j));
                    vertices.get(j).addVizinho(vertices.get(i));
                }

            }

        }
        addVerticeIsolado();
    }

    public void addVerticeIsolado() {
        for (int i = 0; i < vertices.size(); i++) {

            if (vertices.get(i).getVizinhos().isEmpty()) {
                arestas.add(new Aresta(vertices.get(i), new Vertice(0)));
//                vertices.get(i).addVizinho(new Vertice(0));
            }
        }
    }

    public void buscaEmProfundidade() {
        int t = 0;
        Vertice raiz = getRaiz();
        raiz.setCor(0);
        buscaEmProfundidade(raiz);
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
                    while (a.comparaAresta(pilha.peek()) == false) {
                        Aresta apilha = pilha.pop();
                        System.out.print(apilha.getVerticeA().getNumero() + "-" + apilha.getVerticeB().getNumero() + ",");
                    }
                    Aresta apilha2 = pilha.pop();
                    System.out.print(apilha2.getVerticeA().getNumero() + "-" + apilha2.getVerticeB().getNumero() + ",");
                }
                
                v.setBack(Math.min(v.getBack(), w.getBack()));
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

    public void imprimeGrafo() {
        for (Aresta aresta : arestas) {
            System.out.println(aresta.getVerticeA().getNumero() + " " + aresta.getVerticeB().getNumero());
        }
    }

    public Vertice getRaiz() {
        int vEscolhido = (int) (Math.random() * this.vertices.size());
        return this.vertices.get(vEscolhido);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public boolean hasCiclo() {
        return hasArestaDeRetorno();
    }

    public boolean isBipartido() {
        return bipartido;
    }

    public boolean isConexo() {
        resetVertices();
        int c = 0;
        for (Vertice v : vertices) {
            if (v.getPE() == 0) {
                c++;
                buscaEmProfundidade();
            }
        }
        return c == vertices.size();
    }

    public boolean isArvore() {
        return !hasArestaDeRetorno();
    }

    private boolean hasArestaDeRetorno() {
        for (Vertice v : vertices) {
            if (v.hasArestaDeRetorno()) {
                return true;
            }
        }
        return false;
    }

    public void resetVertices() {
        for (Vertice v : vertices) {
            v.resteVertice();
        }
    }

}
