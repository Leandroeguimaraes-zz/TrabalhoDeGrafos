package trabalhodegrafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Grafo {

    private List<Vertice> vertices = new ArrayList<>();
    private List<Aresta> arestas = new ArrayList<>();
    private Blocos blocos = new Blocos();
    private Bloco bloco;
    private Stack<Aresta> pilha = new Stack<>();
    private List<Aresta> circuitoEuleriano = new ArrayList<>();
    private List<Aresta> retorno = new ArrayList<>();
    private List<Aresta> arestasArvore = new ArrayList<>();

    private boolean bipartido = true;

    private static int t;

    public Grafo(int numVertices) {
        geraVertices(numVertices);
        geraArestas();
    }
    public Grafo() {
       
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
        for (Vertice vertice : vertices) {
            if (vertice.getVizinhos().isEmpty()) {
                arestas.add(new Aresta(vertice, new Vertice(0)));
//                vertices.get(i).addVizinho(new Vertice(0));
            }
        }
    }

    public void buscaEmProfundidade() {
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
                arestasArvore.add(new Aresta(v,w));
                pilha.add(new Aresta(v, w)); // empilhar vw
                circuitoEuleriano.add(new Aresta(v, w));
                w.setCor(1 - v.getCor());
                buscaEmProfundidade(w);

                if (w.getBack() >= v.getPE()) { // se back(w)>=PE(v) desempilhar e imprimir tudo até vw
                    Aresta a = new Aresta(v, w);
//                    System.out.println("\nBloco: ");
                    bloco = new Bloco();
                    while (a.comparaAresta(pilha.peek()) == false) {

                        Aresta apilha = pilha.pop();
                        bloco.add(apilha);  // adicionando arestas ao bloco
//                        System.out.print(apilha.getVerticeA().getNumero() + "-" + apilha.getVerticeB().getNumero() + ",");

                    }
                    Aresta apilha2 = pilha.pop();
                    bloco.add(apilha2);   // adicionando arestas ao bloco
//                    System.out.print(apilha2.getVerticeA().getNumero() + "-" + apilha2.getVerticeB().getNumero() + ",");
                    blocos.addBloco(bloco); // no fim, adiciona todo o bloco a lista de blocos.
                }

                v.setBack(Math.min(v.getBack(), w.getBack()));
            } else {
                if (w.getPS() == 0 && v.getPai() != null && v.getPai().getNumero() != w.getNumero()) {
                    w.addArestaDeRetorno(v);    // aresta de retorno
                    retorno.add(new Aresta(v,w));                   
                    pilha.add(new Aresta(v, w)); // empilhar vw
                    circuitoEuleriano.add(new Aresta(v, w));
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
            System.out.println(aresta.getVerticeA().getNumero() + "-" + aresta.getVerticeB().getNumero());
        }
    }
    public void imprimeArvore(){
        for (Aresta aresta: arestasArvore) {
            System.out.println(aresta.getVerticeA().getNumero() + "->" + aresta.getVerticeB().getNumero());
        }
    }

    public void imprimeArticulacao() {
        blocos.identificaArticulacao();
    }

    public void imprimePonte() {
        blocos.identificaPontes();
    }
    public void imprimeArestaDeRetorno(){
        for (Aresta aresta : retorno) {
            System.out.println(aresta.getVerticeA().getNumero()+ "->" + aresta.getVerticeB().getNumero());
        }
    }

    public boolean isEuleriano() {
        for (Aresta a1 : circuitoEuleriano) {
            for (Aresta a2 : circuitoEuleriano) {
                if (a1.comparaArestaSemOrdem(a2)) {
                    return false;
                } 
            }
        }
        return true;
    }
    public boolean isCircuitoEuleriano(){
        return this.isEuleriano() && 
      (circuitoEuleriano.get(circuitoEuleriano.size()-1).getVerticeB().getNumero()==
                                circuitoEuleriano.get(0).getVerticeA().getNumero());
    }
    public void imprimeCaminhoEuleriano(){
        for (Aresta aresta : circuitoEuleriano) {
            System.out.println(aresta.getVerticeA().getNumero()+" ->" + aresta.getVerticeB().getNumero());
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
                buscaEmProfundidade(v);
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
            v.resetVertice();
        }
    }
//    public void imprimeArestasDeRetorno(){
//        for (Vertice v: vertices) {
//            List<Aresta>  retornos = v.getRetornos();
//            for (Aresta retorno : retornos) 
//                System.out.println(retorno.getVerticeA().getNumero() + " ---> " + retorno.getVerticeB().getNumero());
//        }

    public Blocos getBlocos() {
        return blocos;
    }

    public void setBlocos(Blocos blocos) {
        this.blocos = blocos;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public Stack<Aresta> getPilha() {
        return pilha;
    }

    public void setPilha(Stack<Aresta> pilha) {
        this.pilha = pilha;
    }

    public List<Aresta> getCircuitoEuleriano() {
        return circuitoEuleriano;
    }

    public void setCircuitoEuleriano(List<Aresta> circuitoEuleriano) {
        this.circuitoEuleriano = circuitoEuleriano;
    }

    public List<Aresta> getRetorno() {
        return retorno;
    }

    public void setRetorno(List<Aresta> retorno) {
        this.retorno = retorno;
    }

    public static int getT() {
        return t;
    }

    public static void setT(int t) {
        Grafo.t = t;
    }

    public void criaGrafoFixo() {
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
        vertices = Arrays.asList(new Vertice[]{a,b,c,d,e,f,g});
        
    }

}
