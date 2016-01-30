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
public class Grafo {
    
    List<Vertice> vertices= new ArrayList<>();
    List<Aresta> arestas= new ArrayList<>();
    
    
    int numVertices=0;
    
    public Grafo(int numVertices){
        this.numVertices=numVertices;
        
    }
    public void geraVertices(){
        for (int i = 1; i <= numVertices; i++) 
            this.vertices.add(new Vertice(i));
        
        
    }
    public void geraArestas(){
        
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                if(Probabilidade.geraProbabilidade() && i<j) { // i<j evita aresta repetida
                     arestas.add(new Aresta(vertices.get(i),vertices.get(j)));
                     vertices.get(i).addVizinho(vertices.get(j));   //criando listas dentro de listas
                     vertices.get(j).addVizinho(vertices.get(i));
                }
                
            }

        }
//        addVerticesIsolados();
    }
    public List<Aresta> geraGrafo(){
        
        geraVertices();
        geraArestas();
        return arestas;
        
    }
    public void addVerticesIsolados(){ // refazer o metodo para achar os vertices isolados
        boolean verticeIsolado=true;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if( vertices.get(j).vizinhos.size()> j)
                    if(vertices.get(j).vizinhos.get(j).numero==i)
                        verticeIsolado=false;
            }
            if(verticeIsolado)
                arestas.add(new Aresta(vertices.get(i),new Vertice(0)));
        
            verticeIsolado=true;
        }
        
    }
    
    public void imprimeGrafo(){
        for (Aresta aresta :arestas) {
            System.out.println(aresta.verticeA.numero + " " + aresta.verticeB.numero);
        }
    }
    
}
