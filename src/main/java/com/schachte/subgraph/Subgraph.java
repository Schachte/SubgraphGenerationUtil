package com.schachte.subgraph;

import java.util.*;

public class Subgraph {
    private Random random = new Random();
    Map<String, Set<String>> associations = new HashMap<>();
    List<Node> nodes;
    List<Edge> edges;

    public Subgraph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Subgraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addEdges(List<Edge> edges) {
        this.edges.addAll(edges);
        for (Edge edge : edges) {
            Node n1 = edge.getNode1();
            Node n2 = edge.getNode2();

            Set<String> n1Associations = associations.getOrDefault(n1.getIdentifier(), new HashSet<>());
            Set<String> n2Associations = associations.getOrDefault(n2.getIdentifier(), new HashSet<>());

            n1Associations.add(n2.getIdentifier());
            n2Associations.add(n1.getIdentifier());

            associations.put(n1.getIdentifier(), n1Associations);
            associations.put(n2.getIdentifier(), n2Associations);
        }
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public Node getRandomNode() {
        return this.nodes.get(random.nextInt(this.nodes.size()));
    }
}
