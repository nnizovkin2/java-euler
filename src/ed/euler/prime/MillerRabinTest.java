package ed.euler.prime;

import java.util.Random;

import static ed.euler.prime.NumberUtil.findSB;

public class MillerRabinTest {
    public static void main(String[] args) {
        var test = new MillerRabinTest();
        System.out.println(test.isPrime(2));
        System.out.println(test.isPrime(3));
        System.out.println(test.isPrime(5));
        System.out.println(test.isPrime(7));
        System.out.println(test.isPrime(11));
        System.out.println(test.isPrime(13));
    }

    Random r = new Random();

    public boolean isPrime(long n) {
        if((n & 1) == 0 && n != 2) {
            return false;
        }

        int bound = Integer.MAX_VALUE;
        if(bound > n - 1) {
            bound = (int)(n - 1);
        }

        int sb = findSB(n - 1);

        for (int i = 0; i < 5; i++) {
            int a = r.nextInt(bound) + 1;

            if(witness(a, n, sb)) {
                return false;
            }
        }

        return true;
    }

    private boolean witness(long a, long n, int sb) {
        long d = 1;
        for (int i = sb; i >= 0; i--) {
            long x = d;
            d = (d * d) % n;
            if(d == 1 && x != 1 && x != n - 1) {
                return true;
            }

            if(((n - 1) & (1L << i)) != 0) {
                d = (d * a) % n;
            }
        }

        return d != 1;
    }
}
