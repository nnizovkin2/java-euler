package ed.euler;
import ed.euler.graph.*;

public class Euler60 {
    public static void main(String[] args) {
        Graph g = PrimeGraphFactory.buildGraph(10000);
        var ss = new StrictCliqueFinder(g);
        var c = ss.findClique(5).stream().mapToInt(i->i).sum();
        System.out.println(c);
    }

}
