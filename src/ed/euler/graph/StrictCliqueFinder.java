package ed.euler.graph;

import java.util.*;
import java.util.stream.Collectors;

//strict solution with permutations
public class StrictCliqueFinder {
    Graph g;

    public StrictCliqueFinder(Graph g) {
        this.g = g.cl();
    }

    public List<Integer> findClique(int n) {
        var clusters = buildClusters(g);
        for (ArrayList<Integer> cluster : clusters) {
            cluster.sort(Integer::compareTo);
            var r = findClique(new int[0], cluster.get(0), cluster, 1, n);
            if(r!= null) {
                return Arrays.stream(r).boxed().toList();
            }
        }
        return new ArrayList<>();
    }

    private int[] findClique(int[] res, int el, ArrayList<Integer> elems, int ind, int rem) {
        if(rem == 0) {
            return res;
        }

        if(ind == elems.size()) {
            return null;
        }

        if(!isPartOfClique(res, el)) {
            return null;
        }

        res = Arrays.copyOf(res, res.length + 1);
        res[res.length - 1] = el;

        for (int i = ind; i < elems.size(); i++) {
            var r = findClique(res, elems.get(i), elems, i+1, rem - 1);
            if(r!= null) {
                return r;
            }
        }

        return null;
    }

    private boolean isPartOfClique(int[] v, int c) {
        for (int ve : v) {
            if(!g.isEdge(ve, c)) {
                return false;
            }
        }

        return true;
    }

    List<ArrayList<Integer>> buildClusters(Graph g) {
        TreeMap<Integer, ArrayList<Integer>> clusters = new TreeMap<>();
        for (Edge edge: new TreeSet<>(g.e)) {
            addVertexes(clusters, edge.x, edge.y);
            addVertexes(clusters, edge.y, edge.x);
        }
        var t = g.e.stream().filter(e->e.x==2&&e.y==2).collect(Collectors.toList());
        return new ArrayList<>(clusters.values());
    }

    private void addVertexes(Map<Integer, ArrayList<Integer>> clusters, int x, int y) {
        ArrayList<Integer> l = clusters.get(x);
        if(l == null) {
            l = new ArrayList<>();
            l.add(x);
        }
        l.add(y);

        clusters.put(x, l);
    }
}
