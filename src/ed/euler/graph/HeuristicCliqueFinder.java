package ed.euler.graph;

import java.util.ArrayList;

public class HeuristicCliqueFinder {
    private Graph g;

    public HeuristicCliqueFinder(Graph g) {
        this.g = g;
    }

    public Cliques findCliques() {
        var c = createCliques();
        fillCliques(c);
        return c;
    }

    private Cliques createCliques() {
        ArrayList<ArrayList<Integer>> c = new ArrayList<>();
        for (Edge edge: g.e) {
            if(edge.x < edge.y) {
                ArrayList<Integer> cl = new ArrayList<>();
                c.add(cl);
                cl.add(edge.x);
                cl.add(edge.y);
            }
        }

        return new Cliques(c);
    }

    private void fillCliques(Cliques c) {
        for (ArrayList<Integer> clique : c.val) {
            for (Integer ve : g.v) {
                if(canAddToClique(g, clique, ve)) {
                    clique.add(ve);
                }
            }
        }
    }

    boolean canAddToClique(Graph g, ArrayList<Integer> clique, int vertex) {
        if(clique.contains(vertex)) {
            return false;
        }
        for (Integer cv : clique) {
            if(!g.isEdge(cv, vertex)) {
                return false;
            }
        }

        return true;
    }

}
