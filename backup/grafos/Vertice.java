/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pauloarthur
 */
public class Vertice {
    private String nome;
    private int PE;
    private int PS;
    private int cor;
    private Vertice pai;
    private List<Vertice> vizinhos;
    private List<Aresta> retornos;
    private boolean foiVisitado;

    public void addVertice(Vertice vertice){
        if(this.vizinhos == null){
            this.vizinhos = new ArrayList<>();
        }
        this.vizinhos.add(vertice);
    }
    
    public void resteVertice(){
	    this.PE = 0;
	    this.PS = 0;
	    this.cor = 0;
	    this.pai = null;
	    this.vizinhos = new ArrayList<>();
	    this.retornos = new ArrayList<>();
	    this.foiVisitado = false;
    }
    
    public void addArestaDeRetorno(Vertice destino){
        if(this.retornos == null){
            this.retornos = new ArrayList<>();
        }
        this.retornos.add(new Aresta(this, destino));
    }
    
    public boolean hasArestaDeRetorno(){
    	return retornos.size() > 0;
    }
    
    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vertice> getVizinhos() {
        return vizinhos;
    }
    
    public int getPE() {
        return PE;
    }

    public void setPE(int PE) {
        this.PE = PE;
    }

    public int getPS() {
        return PS;
    }

    public void setPS(int PS) {
        this.PS = PS;
    }

    public boolean isFoiVisitado() {
        return foiVisitado;
    }

    public void setFoiVisitado(boolean foiVisitado) {
        this.foiVisitado = foiVisitado;
    }
    
    @Override
    public String toString() {
    	return nome;
    }

	public List<Aresta> getRetornos() {
		return retornos;
	}

	public void setRetornos(List<Aresta> retornos) {
		this.retornos = retornos;
	}

	public void setVizinhos(List<Vertice> vizinhos) {
		this.vizinhos = vizinhos;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}
    
}
