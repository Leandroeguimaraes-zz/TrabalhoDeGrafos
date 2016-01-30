/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodegrafos;

import java.util.List;

/**
 *
 * @author Leandro
 */
public class Profundidade {
    Grafo g;
    int raiz;
    List<Aresta> arestasDepth;
    
    public Profundidade(Grafo g){
        this.g=g;
    }
    
    public void selecionaRaiz(){
        raiz = (int) (Math.random()*g.numVertices +1);
    }
    
    public void constroiArvore(){
        
    }
}
