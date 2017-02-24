package dynamicProgramming;

import java.lang.Math;
import java.util.Scanner;

public class MinimumSteps {
	public int getMinimumSteps() {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter value: ");
			int number = s.nextInt();
			int dp[] = new int[number+1];
			dp[1] = 0;
			for (int i = 2; i <= number; i++) {
				dp[i] = 1 + dp[i-1];

				if (i % 2 == 0)
					dp[i] = Math.min(dp[i], 1 + dp[i/2]);
				if (i % 3 == 0)
					dp[i] = Math.min(dp[i], 1 + dp[i/3]);
			}
			return dp[number];
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static void main(String args[]) {
		MinimumSteps ms = new MinimumSteps();
		int result = ms.getMinimumSteps();
		System.out.println(result);
	}
}
