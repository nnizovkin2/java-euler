import java.util.HashSet;
import java.util.Set;

public class Euler58 {
    public static void main(String[] args) {
//        Set<Integer> s = new HashSet<>(Euler46.primesTill(500000000));
        long[] ta = {3, 5, 7, 9};
        long pn = 3;
        long total = 5;

        while(pn * 10 >= total) {
            for (int i = 0; i < ta.length; i++) {
                ta[i] += (i + total) * 2;
                if(isPrime(ta[i])) {
                    pn++;
                }
            }
            total+=4;
            if(total % 100000 < 4) {
                System.out.println(pn + " " + total);
            }
        }
        System.out.println(total / 2 + 1);
    }

    static boolean isPrime(long i) {
        long l = (long)Math.sqrt(i) + 1;
        for (long j = 2; j <= l; j++) {
             if(i % j == 0) {
                 return false;
             }
        }
        return true;
    }
}
