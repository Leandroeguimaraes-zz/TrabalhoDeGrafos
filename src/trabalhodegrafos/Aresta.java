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
    
    public boolean verificaVerticesEstaoContidosEmAresta(Vertice v1, Vertice v2){
        if((this.getVerticeA()==v1 && this.getVerticeB()==v2) || (this.getVerticeB()==v1 && this.getVerticeA()==v2))
            return true;
        else 
            return false;
    }
    public Aresta retornaArestaContemVertices(Vertice v1, Vertice v2){
        if((this.getVerticeA()==v1 && this.getVerticeB()==v2) || (this.getVerticeB()==v1 && this.getVerticeA()==v2))
            return this;
        else 
            return new Aresta(new Vertice(-1),new Vertice(-1));
    }
    public boolean comparaArestaSemOrdem(Aresta a){
        if((this.getVerticeA().getNumero()== a.getVerticeA().getNumero() && 
                this.getVerticeB().getNumero() == a.getVerticeB().getNumero()) ||
                (this.getVerticeA().getNumero()== a.getVerticeB().getNumero() &&
                this.getVerticeB().getNumero() == a.getVerticeA().getNumero()))
            return true;
        else 
            return false;
    }
    public boolean comparaAresta(Aresta a){
        return this.getVerticeA().getNumero()== a.getVerticeA().getNumero() && 
                this.getVerticeB().getNumero() == a.getVerticeB().getNumero();
    }
    public boolean verificaVerticeEmComumEntreArestas(Aresta a){
        if(this.getVerticeA().getNumero()== a.getVerticeA().getNumero())
            return true;
        else
            if(this.getVerticeA().getNumero() == a.getVerticeB().getNumero())
                return true;
            else
                if(this.getVerticeB().getNumero() == a.getVerticeA().getNumero())
                    return true;
                else
                    if(this.getVerticeB().getNumero() == a.getVerticeB().getNumero())
                        return true;
                    else
                        return false;
    
    }
    public Vertice retornaVerticesEmComumEntreArestas(Aresta a){
        if(this.getVerticeA().getNumero()== a.getVerticeA().getNumero())
            return this.getVerticeA();
        else
            if(this.getVerticeA().getNumero() == a.getVerticeB().getNumero())
                return this.getVerticeA();
            else
                if(this.getVerticeB().getNumero() == a.getVerticeA().getNumero())
                    return this.getVerticeB();
                else
                    if(this.getVerticeB().getNumero() == a.getVerticeB().getNumero())
                        return this.getVerticeB();
                    else
                        return new Vertice(-1);
    }

}
