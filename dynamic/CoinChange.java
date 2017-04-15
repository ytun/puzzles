import java.util.Arrays;

// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class CoinChange{

	// number of ways
	public int coinChange(int[] coins, int x){
		
		if(x<=0 || coins.length==0){
			
		}

	}
	

	public static void main(String[] args){
		
		int[] coins = new int[]{1,2,5};
		int x = 5;
		System.out.println(coinChange(coins, x));
	}

	
}