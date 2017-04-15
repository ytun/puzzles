
import java.util.Arrays;

public class LongestCommonSubsequence{




	public static int lcs_helper(String X, String Y, int m, int n, int[][] lcsTable){
		System.out.println("m,n: "+m+", "+n);

		if(m == -1 || n == -1){
			return 0;
		}
		if(lcsTable[m][n]>-1){
			return lcsTable[m][n];
		}

		int prevLength=0;


		//match
		if(X.charAt(m) == Y.charAt(n)){
			
			// int mm = (m==0)? 0: m-1;
			// int nn = (n==0)? 0: n-1;  

			// if(m == 0 && n ==0){
			// 	prevLength = 0;
			// }
			// else{
			// 	prevLength = lcs_helper(X, Y, mm, nn, lcsTable);
			// }

			lcsTable[m][n]  = 1 + lcs_helper(X, Y, m-1, n-1, lcsTable);

			print(lcsTable);
			return lcsTable[m][n];
		}
		else{
			// prevLength = (m == 0 && n ==0)? 0 : \
			// 	Math.max(lcs_helper(X, Y, m, n-1, lcsTable), lcs_helper(X, Y, m-1, n, lcsTable));


			// if(m == 0 && n ==0){
			// 	prevLength = 0;
			// }
			// else if(m==0){

			// 	// System.out.println("m,n : "+m +", "+n);
			// 	prevLength = lcs_helper(X, Y, m, n-1, lcsTable);
			// }
			// else if(n==0){
			// 	prevLength = lcs_helper(X, Y, m-1, n, lcsTable);
			// }
			// else{
				prevLength = Math.max(lcs_helper(X, Y, m,  n-1, lcsTable), lcs_helper(X, Y, m-1, n, lcsTable));
			// }

			lcsTable[m][n] = prevLength;

			print(lcsTable);
			// System.out.println(Arrays.deepToString(lcsTable)+"\n");

			return prevLength;	
		}
	}

	// public int lcs(){

	// 	// for(int m=0; m<X.length; m++){
	// 	// 	for(int n=0; n<Y.length; n++){
	// 	// 		lcs_helper() ;

	// 	// 	}

	// 	// }

	// }
	public static void print(int[][] table){
		for(int i=0;i<table.length; i ++){
			System.out.println(Arrays.toString(table[i]));
		}
		System.out.println();
	}

	public static void main(String[] args){

		String X = "agtb";//"aggtab"; //6
		String Y = "gxtxayb"; //7

		int[][] lcsTable = new int[X.length()][Y.length()];

		for(int i=0 ; i<X.length(); i++){
			Arrays.fill(lcsTable[i], -1);
		}
		print(lcsTable);
		
		// System.out.println(Arrays.deepToString(lcsTable));
		System.out.println(lcs_helper(X, Y, X.length()-1, Y.length()-1, lcsTable));

	}
}