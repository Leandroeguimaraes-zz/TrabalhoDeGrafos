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
public class Arestas {

    String verticeA, verticeB;
    int peso;

    public Arestas(String verticeA, String verticeB, int peso) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
    }
    public Arestas(String verticeA, String verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = 1;
    }

    public String getVerticeA() {
        return verticeA;
    }

    public String getVerticeB() {
        return verticeB;
    }

    public int getPeso() {
        return peso;
    }

}
