package ed.euler.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RandomGraphFactory {
    public static Graph buildGraph(int vn, int ad) {
        Random r = new Random();

        Graph g = new Graph();
        g.v = new ArrayList<>(vn);
        g.e = new HashSet<>();

        for (int i = 0; i < vn; i++) {
            g.v.add(i);
            int dn = r.nextInt(2 * ad);
            for (int j = 0; j < dn; j++) {
                int v = r.nextInt(vn);
                if(v != i) {
                    g.e.add(new Edge(i, v));
                }
            }
        }

        return g;
    }
}
