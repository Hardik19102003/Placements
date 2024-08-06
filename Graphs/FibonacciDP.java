import java.util.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// User function Template for Java

class Solution {

    static final int MOD = 1000000007;

    static long topDown(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return fibonacciTopDown(n, dp);
    }

    static long fibonacciTopDown(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = (fibonacciTopDown(n - 1, dp) + fibonacciTopDown(n - 2, dp)) % MOD;
        return dp[n];
    }

    static long bottomUp(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0;
        long b = 1;
        long current = 0;

        for (int i = 2; i <= n; i++) {
            current = (a + b) % MOD;
            a = b;
            b = current;
        }

        return current;
    }
}
