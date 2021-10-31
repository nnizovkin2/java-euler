package ed.euler.graph;

import java.util.stream.Collectors;

public class CliqueFinderTest {
    public static void main(String[] args) {
        Graph g = RandomGraphFactory.buildGraph(10000, 2000);
        System.out.println("Start strict method");
        long start = System.currentTimeMillis();
        var ss = new ExactCliqueFinder(g);
        var c = ss.findClique(10);
        long stop = System.currentTimeMillis();
        System.out.println(c + " Strict method. time " + (stop-start));

        System.out.println("Start heuristic method");
        start = System.currentTimeMillis();
        var hs = new HeuristicCliqueFinder(g);
        var cs = hs.findCliques();
        var r = cs.val.stream().filter(l->l.size() >=10).collect(Collectors.toList());
        stop = System.currentTimeMillis();
        System.out.println(r + " Heuristic method. time " + (stop-start));
    }
}
