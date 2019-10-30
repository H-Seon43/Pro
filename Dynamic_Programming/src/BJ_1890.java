import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1890 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n][n];
		long dp[][] = new long[n][n];
		
		dp[0][0] = 1;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				int next = arr[i][j];
				
				if(dp[i][j] == 0 || next == 0)
					continue;
				
				if(i + next < n)
					dp[i + next][j] += dp[i][j];
				
				if(j + next < n)
					dp[i][j + next] += dp[i][j];
			}
		}
		
		System.out.println(dp[n-1][n-1]);
	}

}
