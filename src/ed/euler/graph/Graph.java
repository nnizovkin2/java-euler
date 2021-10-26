package ed.euler.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    public Set<Edge> e;
    public ArrayList<Integer> v;

    boolean isEdge(int v1, int v2) {
        return e.contains(new Edge(v1, v2));
    }

    public Graph cl() {
        var g = new Graph();
        g.e = new HashSet<>(e);
        g.v = new ArrayList<>();

        return g;
    }
}

