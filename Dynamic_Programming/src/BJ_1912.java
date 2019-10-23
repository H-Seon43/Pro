import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1912 - ¿¬¼ÓÇÕ

public class BJ_1912 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int dp[] = new int[n];
		int answer;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = answer = arr[0];
		
		for(int i = 1 ; i < n ; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			
			answer = Math.max(dp[i], answer);
		}
		
		System.out.println(answer);
	}
}
