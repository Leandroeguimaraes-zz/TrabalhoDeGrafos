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
                     
                      // adicionando agora pelo numero e não o vertice em si
                     vertices.get(i).addVizinho(vertices.get(j).getNumero());  
                     vertices.get(j).addVizinho(vertices.get(i).getNumero());
                }
                
            }

        }
        addVerticeIsolado();
    }
    public List<Aresta> geraGrafo(){
        
        geraVertices();
        geraArestas();
        return arestas;
        
    }
    public void addVerticeIsolado(){
        for (int i = 0; i < vertices.size(); i++) {
            
            if(vertices.get(i).getVizinhos().isEmpty())
                arestas.add(new Aresta(vertices.get(i),new Vertice(0)));          
        }
        
    }
       
    public void imprimeGrafo(){
        for (Aresta aresta :arestas) {
            System.out.println(aresta.getVerticeA().getNumero() + " " + aresta.getVerticeB().getNumero());
        }
    }
    
}
