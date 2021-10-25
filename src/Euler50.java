import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Euler50 {
    public static void main(String[] args) {
        ArrayList<Integer> p = Euler46.primesTill(1000000);
        Set<Integer> set = new HashSet<>(p);
        int[] sums = new int[p.size() + 1];
        int sum = 0;
        for (int i = 0; i < sums.length; i++) {
             sums[i] = sum;
             if(i < p.size()) {
                 sum += p.get(i);
             }
        }

        int num = 0;
        int s = 0;
        int e = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                if(set.contains(sums[j] - sums[i]) && (e-s) < (j - i)) {
                    num = sums[j] - sums[i];
                    e = j;
                    s = i;
                }
            }
        }
        System.out.println(s + " " + e + " " + (e-s) + " " + num);
    }
}
