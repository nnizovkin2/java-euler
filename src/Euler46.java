import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Euler46 {
    public static void main(String[] args) {
        new Euler46().printNonComposite();
    }
    void printNonComposite() {
        Set<Integer> set = new HashSet<>(primesTill(1000000));
        int[] sq = doubleSquaresTill(1000000);
        for (int i = 0; i < 1000000; i++) {
            if (!isComposite(i, set, sq)) {
                System.out.println(i);;
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

    static ArrayList<Integer> primesTill(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 2;
        while (i <= n) {
            if(i % 10000000 == 0) {
                System.out.println(System.currentTimeMillis());
            }
            boolean isPrime = true;
            int lim = (int)Math.sqrt(i) + 1;
            for (Integer p : res) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
                if(p > lim) {
                    break;
                }
            }
            if (isPrime) {
                res.add(i);
            }
            i++;
        }

        return res;
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
