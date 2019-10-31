/*
https://www.acmicpc.net/problem/5557 - 1ÇÐ³â
11
8 3 2 4 8 7 2 4 0 8 8

10
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5557 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		long dp[][] = new long[n][21];
		
		st = new StringTokenizer(br.readLine());
		int next = Integer.parseInt(st.nextToken());
		
		dp[1][next] = 1;
		
		for(int i = 1 ; i < n-1 ; i++) {
			next = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; j <= 20 ; j++) {
				if(dp[i][j] != 0) {
					if(j + next <= 20)
						dp[i+1][j+next] += dp[i][j];
					
					if(j - next >= 0)
						dp[i+1][j-next] += dp[i][j];
				}
			}
		}
		
		next = Integer.parseInt(st.nextToken());
		System.out.println(dp[n-1][next]);
	}

}
