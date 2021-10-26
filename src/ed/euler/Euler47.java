package ed.euler;

import java.util.ArrayList;
import java.util.List;

import static ed.euler.prime.PrimeUtil.primesTill;

public class Euler47 {
    public static void main(String[] args) {
        System.out.println(new Euler47().find(1000000));
    }
    int find(int max) {
        int[] divNum = new int[max];
        ArrayList<Integer> primes = primesTill(max);
        for (int i = 0; i < max; i++) {
            divNum[i] = getPrimeDiv(i, primes).size();
        }

        for (int i = 0; i < divNum.length - 4; i++) {
            if(divNum[i] == 4 && divNum[i+1] == 4 && divNum[i+2] == 4 && divNum[i+3] == 4) {
                return i;
            }
        }

        return -1;
    }

    List<Integer> getPrimeDiv(int n, ArrayList<Integer> primes) {
        int i = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(n > 1) {
            if(n % primes.get(i) == 0) {
                n/=primes.get(i);
                if((res.isEmpty() || !res.get(res.size() - 1).equals(primes.get(i)))) {
                    res.add(primes.get(i));
                }
            } else {
                i++;
            }
        }

        return res;
    }
}
