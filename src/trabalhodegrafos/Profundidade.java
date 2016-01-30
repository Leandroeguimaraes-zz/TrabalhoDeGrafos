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
    int t=0;
    
    public Profundidade(Grafo g){
        this.g=g;
    }
    
    public void selecionaRaiz(){
        int vEscolhido = (int) (Math.random()*g.getVertices().size());
        for (int i = 0; i < g.getVertices().size(); i++) {
            if(vEscolhido== g.getVertices().get(i).getNumero())
                raiz=g.getVertices().get(i).getNumero();
        }   
    }
    
//    public Vertice buscaMenorNumero(Vertice v){
//        int aux=v.getVizinhos().get(0);
//        Vertice vMenor = null;
//        
//        for (int i = 1; i < v.getVizinhos().size(); i++) 
//            if(v.getVizinhos().get(i)<aux){
//                aux=v.getVizinhos().get(i);
//                vMenor=v;
//            }
//                
//        return vMenor;
//        
//        
//    }
    public void constroiArvore(int v){
        
        
    }
}
