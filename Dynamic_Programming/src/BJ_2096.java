import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2096 - 내려가기

public class BJ_2096 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][3];
		int dp[][] = new int[N+1][3];
		int ansMax, ansMin;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0 ; j < 3 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = dp[0][1] = dp[0][2] = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i-1][0];
			dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + arr[i-1][1];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + arr[i-1][2];
		}
		
		ansMax = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
		
		for(int i = 1 ; i <= N ; i++) {
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i-1][0];
			dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + arr[i-1][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i-1][2];
		}
		
		ansMin = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
		
		System.out.println(ansMax + " " + ansMin);		
				
	}

}
