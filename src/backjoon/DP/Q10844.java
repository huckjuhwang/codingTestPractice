package backjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q10844 {

    final static long mod = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j + 1] % mod;
                } else if (j == 9) {
                    dp[i][j] += dp[i - 1][j - 1]% mod;
                } else {
                    dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j + 1])% mod;
                }
            }
        }


        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= mod;
        }

        System.out.println(result);
    }

}