package DynamicProgramming;

import java.util.Scanner;

public class Problem1_Fibonacci {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		int n = 6;
//		int ans = fibo_rec(n);
//		int ans = fibo_TD(n, new int[n + 1]);
//		int ans = fibo_BU(n);
		int ans = fibo_optimal(n);
		System.out.println(ans);
	}

	private static int fibo_rec(int n) {
		if (n <= 1) {
			return n;
		}
		int sp1 = fibo_rec(n - 1);
		int sp2 = fibo_rec(n - 2);
		int ans = sp1 + sp2;
		return ans;
	}

	private static int fibo_TD(int n, int[] dp) {
		if (n <= 1) {
			dp[n] = n;
			return n;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int sp1 = fibo_TD(n - 1, dp);
		int sp2 = fibo_TD(n - 2, dp);
		dp[n] = sp1 + sp2;
		return dp[n];
	}

	private static int fibo_BU(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	private static int fibo_optimal(int n) {
		if (n <= 1) {
			return n;
		}

		int ans = 0;

		int sp1 = 0;
		int sp2 = 1;

		for (int i = 2; i <= n; i++) {
			ans = sp1 + sp2;
			sp1 = sp2;
			sp2 = ans;
		}
		return ans;
	}
}
