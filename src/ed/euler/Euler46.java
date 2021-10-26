package ed.euler;

import java.util.HashSet;
import java.util.Set;

import static ed.euler.prime.PrimeUtil.primesTill;

public class Euler46 {
    public static void main(String[] args) {
        new Euler46().printNonComposite();
    }
    void printNonComposite() {
        Set<Integer> set = new HashSet<>(primesTill(1000000));
        int[] sq = doubleSquaresTill(1000000);
        for (int i = 0; i < 1000000; i++) {
            if (!isComposite(i, set, sq)) {
                System.out.println(i);
            }
        }
    }

    boolean isComposite(int n, Set<Integer> primes, int[] sq) {
        for (int i : sq) {
            if (primes.contains(n - i)) {
                return true;
            }
        }

        return false;
    }

    int[] doubleSquaresTill(int n) {
        int b = (int) Math.sqrt(n / 2);
        int[] res = new int[b];

        for (int i = 0; i < b; i++) {
            res[i] = 2 * i * i;
        }

        return res;
    }
}
