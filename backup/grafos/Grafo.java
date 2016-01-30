package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private static int t;
	
	private Vertice raiz;
	private List<Vertice> vertices;
	
	private boolean bipartido = true;
	
	public Grafo() {
		vertices = new ArrayList<>();
	}
	
	public void geraGrafo(){
		Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");

        a.addVertice(b);
        a.addVertice(c);
        b.addVertice(a);
        b.addVertice(c);
        c.addVertice(a);
        c.addVertice(b);
        c.addVertice(d);
        d.addVertice(c);
       
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        
        raiz = a;
	}
	
	public void resetVertices(){
		for (Vertice v : vertices) {
			v.resteVertice();
		}
	}
	
	public void buscaEmProfundidade(){
    	t = 0;
    	Vertice raiz = getRaiz();
    	raiz.setCor(0);
		buscaEmProfundidade(raiz);
    }
	private void buscaEmProfundidade(Vertice v){
        t++;
        v.setPE(t);
        List<Vertice> vizinhos = v.getVizinhos();
        for (Vertice w : vizinhos) {
            if(w.getPE() == 0){
                w.setFoiVisitado(true);
                w.setPai(v);
                w.setCor(1 - v.getCor());
                buscaEmProfundidade(w);
            }else{
                if(w.getPS() == 0 && (v.getPai() != null && v.getPai().getNome().equals(w.getNome()) )){
                	w.addArestaDeRetorno(v);
                	if(w.getCor() != v.getCor()){
                		this.bipartido = false;
                	}
                }
            }
        }
        t++;
        v.setPS(t);
    }
	
	public boolean hasCiclo(){
		return hasArestaDeRetorno();
	}
	
	public boolean isBipartido(){
		return bipartido;
	}
	
	public boolean isConexo() {
		resetVertices();
		int c = 0;
		for (Vertice v : vertices) {
			if(v.getPE() == 0){
				c++;
				buscaEmProfundidade();
			}
		}
		return c == vertices.size();
	}
	
	public boolean isArvore(){
		return !hasArestaDeRetorno();
	}

	private boolean hasArestaDeRetorno() {
		for (Vertice v : vertices) {
			if(v.hasArestaDeRetorno()){
				return true;
			}
		}
		return false;
	}
	
	public Vertice getRaiz() {
		return raiz;
	}
	
	public void setRaiz(Vertice raiz) {
		this.raiz = raiz;
	}
	
	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}
	
	public void setBipartido(boolean bipartido) {
		this.bipartido = bipartido;
	}

}
