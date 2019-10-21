/*
https://www.acmicpc.net/problem/10164 - 격자상의 경로
3 5 8

9
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10164 {

	static int N, M, K;
	static int dp[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][M+1];
		dp[0][1] = 1;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		System.out.println(solve());
	}
	
	public static int solve() {
		if(K == 0)
			return dp[N][M];
		else {
			int ax, ay, bx, by;
			
			ax = K/M + (K%M > 0 ? 1 : 0);
			ay = K - (ax - 1) * M;
			bx = N - ax + 1;
			by = M - ay + 1;
			
			return dp[ax][ay] * dp[bx][by];
		}
	}
}