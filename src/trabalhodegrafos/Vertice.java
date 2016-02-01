/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodegrafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class Vertice {
    private String letra = null;
    
    private int numero = 0;
    
    private List<Vertice> vizinhos = new ArrayList<>();
    private List<Aresta> retornos= new ArrayList<>();
    
    private int PE=0;
    private int PS=0;
    private int cor=0;
    private int back=0;
    
    private Vertice pai;
    
    private boolean foiVisitado;
    
    public Vertice(String letra){
        this.letra=letra;
    }
    public Vertice(int numero){
        this.numero=numero;
    }
    public void addVizinho(Vertice v){
        vizinhos.add(v);
    }
    
    public void addArestaDeRetorno(Vertice destino){
        if(this.retornos == null){
            this.retornos = new ArrayList<>();
        }
        this.retornos.add(new Aresta(this, destino));
    }
    
    public void imprimeVizinhos(){
        for (Vertice vizinho : vizinhos) {
            System.out.println(this.numero+ "-> " + vizinho.getNumero());
        }
       
    }
   
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Vertice> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<Vertice> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public int getPE() {
        return PE;
    }

    public void setPE(int PE) {
        this.PE =PE;
    }

    public int getPS() {
        return PS;
    }

    public void setPS(int PS) {
        this.PS = PS;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }
    public boolean isFoiVisitado() {
        return foiVisitado;
    }

    public void setFoiVisitado(boolean foiVisitado) {
        this.foiVisitado = foiVisitado;
    }
    public boolean hasArestaDeRetorno(){
    	return retornos.size() > 0;
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

    public List<Aresta> getRetornos() {
        return retornos;
    }

    public void setRetornos(List<Aresta> retornos) {
        this.retornos = retornos;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }
    
}
