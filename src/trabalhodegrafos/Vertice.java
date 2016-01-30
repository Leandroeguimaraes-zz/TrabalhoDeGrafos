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
    private int pe=0;
    private int ps=0;
    
    public Vertice(String letra){
        this.letra=letra;
    }
    public Vertice(int numero){
        this.numero=numero;
    }
    public void addVizinho(Vertice v){
        vizinhos.add(v);
    }
    
    public void imprimeVizinhos(){
        for (int i = 0; i < vizinhos.size(); i++) {
            System.out.println(this.numero+ "-> " + vizinhos.get(i).getNumero());
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
    
}
