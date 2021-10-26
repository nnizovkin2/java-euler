package ed.euler.prime;

import java.util.ArrayList;

public class PrimeUtil {
    public static ArrayList<Integer> primesTill(int n) {
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

    public static boolean isPrime(long i) {
        long l = (long)Math.sqrt(i) + 1;
        for (long j = 2; j <= l; j++) {
            if(i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(long i, ArrayList<Integer> pn) {
        long l = (long)Math.sqrt(i) + 1;
        int size = pn.size();
        for (int d : pn) {
            if (d >= l) {
                return true;
            }

            if (i % d == 0) {
                return false;
            }
        }
        return true;
    }
}
