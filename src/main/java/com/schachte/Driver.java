package com.schachte;

import com.schachte.subgraph.Node;
import com.schachte.subgraph.Subgraph;

import java.util.*;
import java.util.function.Supplier;

/** Random subgraph generation utility*/
public class Driver {
    private static final NodeType[] NODE_TYPES = NodeType.values();
    private static final Random RANDOM = new Random();
    private static Set<String> guidCache = new HashSet<>();
    private static Supplier<String> guidSupplier = () -> java.util.UUID.randomUUID().toString();

    public static void main(String[] args) {
        int subgraphCount = 5;
        int maxSubgraphSize = 100;
        Network network = new Network();

        for (int i = 0; i < subgraphCount; i++) {
            Subgraph subgraph = new Subgraph();
            network.addSubgraph(subgraph);
            generateRandomNodes(RANDOM.nextInt(maxSubgraphSize), subgraph);
            generateRandomEdges(subgraph);
        }

        System.out.println("Complete");
    }

    private static void generateRandomNodes(int nodeCount, Subgraph subgraph) {
        List<Node> nodes = new ArrayList<>();
        while (nodes.size() < nodeCount) {
            nodes.add(new Node(
                    getRandomIdentifier(),
                    getRandomNodeType(),
                    subgraph)
            );
        }
        subgraph.addNodes(nodes);
    }

    private static void generateRandomEdges(Subgraph subgraph) {
        final int MAX_OUT_DEGREE = NODE_TYPES.length;

        // Let's add 0 -> MAX_OUT_DEGREE edges to each node in the subgraph
        for (Node node : subgraph.getNodes()) {
            int outDegree = RANDOM.nextInt(MAX_OUT_DEGREE);
            for (int i = 0; i < outDegree; i++) {
                node.addEdge(subgraph.getRandomNode());
            }
        }
    }

    private static String getRandomIdentifier() {
        String guid = guidSupplier.get();
        while (guidCache.contains(guid)) {
            guid = guidSupplier.get();
            System.out.println("Hit cache");
        }
        guidCache.add(guid);
        return guid;
    }

    private static NodeType getRandomNodeType() {
        return NODE_TYPES[RANDOM.nextInt(NODE_TYPES.length)];
    }
}
