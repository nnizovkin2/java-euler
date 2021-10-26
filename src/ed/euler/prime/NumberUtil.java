package ed.euler.prime;

public class NumberUtil {
    public static long glue(int x1, int x2) {
        long r = x1;
        int rx2 = 0;
        while(x2 != 0) {
            rx2 = rx2 * 10 + x2 % 10;
            x2 /= 10;
        }

        while(rx2 != 0) {
            r = r * 10 + rx2 % 10;
            rx2 /= 10;
        }

        return r;
    }

    public static int findSB(long n) {
        int p = -1;
        while(n != 0) {
            p++;
            n>>=1;
        }

        return p;
    }
}
