package ed.euler;
import ed.euler.graph.*;

public class Euler60 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Graph g = PrimeGraphFactory.buildGraph(10000);
        var ss = new ExactCliqueFinder(g);
        var c = ss.findClique(5).stream().mapToInt(i->i).sum();
        System.out.println(c);
        System.out.println(System.currentTimeMillis()  - start);
    }

}
