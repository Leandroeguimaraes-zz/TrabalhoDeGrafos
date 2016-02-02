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
public class Blocos {

    private List<Bloco> blocos = new ArrayList<>();
    private List<Vertice> articulacoes = new ArrayList<>();
    private List<Aresta> pontes = new ArrayList<>();

    private List<Aresta> arestasDeArticulacoes = new ArrayList<>();

    public void addBloco(Bloco bloco) {
        blocos.add(bloco);
    }

    public void identificaArticulacao() {
        for (int i = 0; i < blocos.size() - 1; i++) { // -1 para evitar o nullPointer do ultimo caso.
            for (int j = 0; j < blocos.get(i).getArestas().size(); j++) { // numero de arestas no bloco
                for (int k = 0; k < blocos.get(i + 1).getArestas().size(); k++) { // numero de arestas do bloco seguinte
                    if (blocos.get(i).getArestas().get(j).verificaVerticeEmComumEntreArestas(blocos.get(i + 1).getArestas().get(k))) {
                        Vertice v = blocos.get(i).getArestas().get(j).retornaVerticesEmComumEntreArestas(blocos.get(i + 1).getArestas().get(k));
                        if (!articulacoes.contains(v)) // evita repetido
                        {
                            articulacoes.add(v);
                        }

                    }
                }

            }
        }
        for (Vertice v : articulacoes) {
            System.out.print(v.getNumero() + ";");
        }

    }

    public void identificaPontes() {
        this.combinacaoDeArestasComVertices();
        for (Bloco bloco : blocos) {
            for (int j = 0; j < bloco.getArestas().size(); j++) {
                for (Aresta arestasDeArticulacoe : arestasDeArticulacoes) {
                    if (bloco.getArestas().get(j).comparaArestaSemOrdem(arestasDeArticulacoe)) {
                        Aresta a = arestasDeArticulacoe;
                        if (!pontes.contains(a)) {
                            pontes.add(a);
                        }
                    }
                }
            }
        }
        for (Aresta aresta : pontes) {
            System.out.println(aresta.getVerticeA().getNumero() + "-" + aresta.getVerticeB().getNumero() + "; ");
        }

    }

    public void combinacaoDeArestasComVertices() {
        if (articulacoes.size() > 1) {
            for (int i = 0; i < articulacoes.size(); i++) {
                for (int j = 0; j < articulacoes.size(); j++) {
                    if (i < j) {
                        arestasDeArticulacoes.add(new Aresta(articulacoes.get(i), articulacoes.get(j)));
                    }
                }
            }
        }

    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<Bloco> blocos) {
        this.blocos = blocos;
    }

    public List<Vertice> getArticulacoes() {
        return articulacoes;
    }

    public void setArticulacoes(List<Vertice> articulacoes) {
        this.articulacoes = articulacoes;
    }

    public List<Aresta> getPontes() {
        return pontes;
    }

    public void setPontes(List<Aresta> pontes) {
        this.pontes = pontes;
    }

}
