package com.schachte.subgraph;

import java.util.HashMap;
import java.util.Map;

public class Edge {
    private Map<String, String> properties;
    Node n1;
    Node n2;

    public Edge(Node n1, Node n2) {
        this.properties = new HashMap<>();
        this.n1 = n1;
        this.n2 = n2;
    }

    public Edge(Node n1, Node n2, Map<String, String> props) {
        this(n1, n2);
        this.properties = props;
    }

    public Map<String, String> getProperties() {
                                             return this.properties;
                                                                    }

    public Node getNode1() {
                         return this.n1;
                                        }

    public Node getNode2() {
                         return this.n2;
                                        }

}
