package ed.euler.graph;

import ed.euler.prime.MillerRabinTest;

import java.util.HashSet;

import static ed.euler.prime.NumberUtil.glue;
import static ed.euler.prime.PrimeUtil.primesTill;

public class PrimeGraphFactory {
    public static Graph buildGraph(int n) {
        var test = new MillerRabinTest();
        var g = new Graph();
        g.v = primesTill(n);
        g.e = new HashSet<>();
        int i = 0;
        for (Integer v1 : g.v) {
            for (Integer v2 : g.v) {
                if(test.isPrime(glue(v1, v2)) && test.isPrime(glue(v2, v1))) {
                    g.e.add(new Edge(v1, v2));
                }
            }
        }
        return g;
    }
}
