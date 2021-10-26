package ed.euler;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;

public class Euler45 {
//    ans = filter (\n->(n `elem` triangle) && (n `elem` pentagonal)) hexagonal
//            triangle = fromList(map (\n -> n*(n+1) `div` 2)[286..500000])
//    pentagonal = fromList(map (\n -> n*(3*n-1) `div` 2)[166..500000])
//    hexagonal = map (\n -> n*(2*n-1))[144..200000]
    void find() {
        Set<Long> tr = new HashSet<>();
        Set<Long> pen = new HashSet<>();
        for (long i = 166; i < 4000000; i++) {
            tr.add(i*(i+1)/2);
            pen.add(i*(3*i-1)/2);
        }

        LongStream.range(144, 1000000).parallel().map(i->i * (2 * i - 1)).filter(i->tr.contains(i) && pen.contains(i)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Euler45().find();
    }
}
