/*
https://www.acmicpc.net/problem/1937 - øÂΩ…¿Ô¿Ã ∆«¥Ÿ
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8

4
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1937 {
	
	static int arr[][], dp[][];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	static int n;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp[i], -1);
		}
		
		int answer = 0;
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				answer = Math.max(answer, solve(i, j));
			}
		}
		
		System.out.println(answer);
	}

	static int solve(int x, int y) {
		if(dp[x][y] != -1)
			return dp[x][y];
		
		int day = 1;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(nx, ny) || arr[x][y] >= arr[nx][ny])
				continue;
			
			day = Math.max(day, solve(nx, ny) + 1);
		}
		
		return dp[x][y] = day;
	}
	
	static boolean isRange(int x, int y) {
		if(x < 0 || x >= n || y < 0 || y >=n)
			return false;
		
		return true;
	}
}
