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
public class Aresta {

    private Vertice verticeA, verticeB;
    private int peso;

    public Aresta(Vertice verticeA, Vertice verticeB, int peso) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
    }
    public Aresta(Vertice verticeA, Vertice verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = 1;
    }

    public Vertice getVerticeA() {
        return verticeA;
    }

    public Vertice getVerticeB() {
        return verticeB;
    }

    public int getPeso() {
        return peso;
    }

}
