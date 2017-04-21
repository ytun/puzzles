import java.util.Arrays;

// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class CoinChange{

	// number of ways
	public static int coinChange(int[] coins, int nCoins, int x){
		
		if(x<0 || (nCoins<=0 && x>0)){
			return 0;
		}
		else if(x==0 ){
			return 1;
		}
		else{
			return coinChange(coins, nCoins, x - coins[nCoins-1]) + coinChange(coins, nCoins -1, x);
		}

	}
	
	public static int coinChangeLoop(int[] coins, int x){

		int[][] table = new int[coins.length][x];

		for(int i=0; i<x; i++){
			table[0][i] = 1; //one way if amount is 0- no coins put
		}

		for(int c=0; c<table.length; c++){
			for(int i=1; i<=x; i++){

				table[c][i] = table[c-1][i] + table[c][i - coins[c-1]];

			}
		}

		return table[coins.length-1][x];
	}

	static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++){
            for (int j=S[i]; j<=n; j++){
                table[j] += table[j-S[i]];
            	System.out.println(i+", "+j+" "+Arrays.toString(table));
            }
        }
 

        return table[n];
    }

	public static void main(String[] args){
		
		int[] coins = new int[]{1,2,3};
		int x = 3;
		// System.out.println(coinChange(coins, coins.length, x));
		System.out.println(countWays(coins, coins.length,x));

	}

	
}