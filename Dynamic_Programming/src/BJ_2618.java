//https://www.acmicpc.net/problem/2618 - 경찰차

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2618{
	static int[][] D,K1,K2;
	static int W;
	static ArrayList<Integer> COP = new ArrayList<>();

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		D = new int[W+1][W+1];

		K1= new int[W+1][2];
		K2 = new int[W+1][2];
		K1[0][0] =1;
		K1[0][1] =1;
		K2[0][0] =N;
		K2[0][1] =N;
		StringTokenizer st;
		for(int i=1; i<=W; i++){
			st = new StringTokenizer(br.readLine());
			K1[i][0]=Integer.parseInt(st.nextToken());
			K2[i][0]=K1[i][0];
			K1[i][1]=Integer.parseInt(st.nextToken());
			K2[i][1]=K1[i][1];
		}
		br.close();

		for(int i=0;i<=W; i++){
			for(int j=0; j<=W; j++){
				D[i][j]=-1;
			}
		}

		System.out.println(move(0,0));
		path(0,0);
		for(int i:COP){
			System.out.println(i);
		}
	}
	public static int dist(int[] a,int[] b){
		return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
	}

	public static int move(int a, int b){
		int next=Math.max(a,b)+1;
		if(a ==W||b==W)
			return 0;
		if(D[a][b]!=-1)
			return D[a][b];

		int d1,d2;
		d1=move(next,b)+dist(K1[a],K1[next]);
		d2=move(a,next)+dist(K2[b],K1[next]);
		if(d1>d2)
			D[a][b]=d2;
		else
			D[a][b]=d1;
		return D[a][b];
	}
	public static int path(int a, int b){
		int next=Math.max(a,b)+1;
		if(a ==W||b==W)
			return 0;

		int d1,d2;
		d1=D[next][b]+dist(K1[a],K1[next]);
		d2=D[a][next]+dist(K2[b],K1[next]);
		if(d1>d2){
			COP.add(2);  
			path(a,next);
		}
		else{
			COP.add(1);
			path(next,b);
		}
		return D[a][b];
	}
}