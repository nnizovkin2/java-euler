package ed.euler;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Euler44 {
    int size = (5482660 + 1) / 3;
    void check() {
        HashSet<Long> s = new HashSet<>();
        long[] a = new long[(int)(size * 1.5)];
        for (long i = 0; i < (long)(size * 1.5); i++) {
            long p = (3 * i - 1) * i / 2;
            s.add(p);
            a[(int)i] = p;
        }

        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int i = 1; i < size; i++) {
            int finalI = i;
            executor.submit(()-> {
                for (int j = 1; j < size; j++) {
                    if (finalI != j && s.contains(a[finalI] - a[j]) && s.contains(a[finalI] + a[j]) && a[finalI] - a[j] < 5482660) {
                        System.out.println(a[finalI] - a[j]);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new Euler44().check();
    }
}
