package com.schachte.subgraph;

import com.schachte.NodeType;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String identifier;
    public List<Edge> edges;
    public NodeType type;
    public Subgraph subgraph;

    public Node(String identifier, NodeType type, Subgraph subgraph) {
        this.identifier = identifier;
        this.type = type;
        this.edges = new ArrayList<>();
        this.subgraph = subgraph;
    }

    public void addEdge(Node connectedNode)  {
        List<Edge> createdEdges = new ArrayList<>();
        createdEdges.add(new Edge(this, connectedNode));
        createdEdges.add(new Edge(connectedNode, this));

        this.edges.add(createdEdges.get(0));
        connectedNode.edges.add(createdEdges.get(1));
        subgraph.addEdges(createdEdges);
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public String getIdentifier() {
        return this.identifier;
    }


}
