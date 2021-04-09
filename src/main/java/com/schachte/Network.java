package com.schachte;

import com.schachte.subgraph.Subgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * We will classify the network as the parent network containing N disparate sub-graphs of identities
 */
public class Network {
    List<Subgraph> subgraphs;

    public Network() {
        this.subgraphs = new ArrayList<>();
    }

    public void addSubgraph(Subgraph subgraph) {
        this.subgraphs.add(subgraph);
    }

    public List<Subgraph> getSubgraphs() {
        return this.subgraphs;
    }
}
