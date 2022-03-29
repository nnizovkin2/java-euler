package leetcode;

public class S2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = gen(queries[i], intLength);
        }
        return res;
    }

    private long gen(int query, int l) {
        if(l==1) {
            if(query<10) {
                return query;
            } else {
                return -1;
            }
        }

        if (9 * (Math.pow(10, (l & 1) + (l >> 1) - 1)) < query) {
            return -1;
        }

        query--;
        long pref = 0;
        long suffix = 0;
        int dn = (l & 1) + l >> 1;
        int itN = 0;
        long m = 1;
        while (query != 0) {
            int d = query % 10;
            if (itN == 0 && (l & 1) == 1) {
                pref = d;
            } else if((l & 1) == 1) {
                m *= 100;
                pref = m * d + pref*10;
                suffix = suffix * 10 + d;
            } else {
                pref = 10 * (m * d + pref);
                suffix = suffix * 10 + d;
                m*=100;
            }
            query /= 10;
            itN++;
        }
        pref = (long)(Math.pow(10, l - 1) + pref * Math.pow(10, dn-itN));
        suffix = 1 + suffix * (long) Math.pow(10, dn - itN);

        return pref + suffix;
    }
}
