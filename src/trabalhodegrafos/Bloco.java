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
public class Bloco {
    private List<Aresta> arestas = new ArrayList<>();
    
    
    public void add(Aresta aresta){
        arestas.add(aresta);
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }
    
    
}
