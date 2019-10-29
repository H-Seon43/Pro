/*
https://www.acmicpc.net/problem/1520
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

3
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1520 {

	static int dp[][], arr[][];
	static int m, n;
	static int wx[] = {-1, 0, 1, 0};
	static int wy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		dp = new int[m][n];
		
		for(int[] i : dp) {
			Arrays.fill(i, -1);
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(m-1,n-1));
			
	}
	
	public static int dfs(int x, int y) {
		if(x == 0 && y == 0)
			return 1;
		
		if(dp[x][y] == -1) {
			dp[x][y] = 0;
			
			for(int i = 0 ; i < 4 ; i++) {
				int nx = wx[i] + x;
				int ny = wy[i] + y;
				
				if(nx > -1 && ny > -1 && nx < m && ny < n) {
					if(arr[nx][ny] > arr[x][y])
						dp[x][y] += dfs(nx, ny);
				}
			}
		}
		
		return dp[x][y];
	}

}
