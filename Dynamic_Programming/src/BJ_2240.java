/*
https://www.acmicpc.net/problem/2240 - 자두나무
7 2
2
1
1
2
2
1
1

6
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2240 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[t+1][w+1];
		
		for(int i = 1 ; i <= t ; i++) {
			int tree = Integer.parseInt(br.readLine());
			
			for(int j = 0 ; j <= w ; j++) {
				if(j == 0) {
					if(tree == 1)
						dp[i][j] = dp[i-1][j] + 1;
					else
						dp[i][j] = dp[i-1][j];
				} else {
					if(j % 2 != 0) {
						if(tree == 1)
							dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1); 
						else
							dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
					} else {
						if(tree == 1)
							dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
						else
							dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
					}
				}
			}
		}
		
		int answer = 0;
		for(int i = 0 ; i <= w ; i++) {
			answer = Math.max(answer, dp[t][i]);
		}
		
		System.out.println(answer);
	}
}
