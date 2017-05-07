import java.util.Arrays;

// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class MinCostPath {


  public static int mcp(int[][] cost, int m, int n, int[][] table) {


    if ( m == -1 || n == -1) {
      return Integer.MAX_VALUE;
    } else if (table[m][n] == 0) {
      if ( m == 0 && n == 0) {
        table[m][n] = cost[m][n];
      } else {
        int min  = Math.min( Math.min(mcp(cost, m - 1, n, table), mcp(cost, m, n - 1, table)), mcp(cost, m - 1, n - 1, table) );
        //System.out.println("min: "+ min);
        //System.out.println("cost: "+cost[m][n]);

        table[m][n] = cost[m][n] + min;
      }
    }

    return table[m][n];
  }

  public static int mcpLoop(int[][] cost, int m, int n) {
    int[][] table = new int[m + 1][n + 1];
    table[0][0] = cost[0][0];

    // first column- one option to go down
    for (int i = 1; i < table.length; i++) {
      table[i][0] = table[i - 1][0] + cost[i][0];
    }

    // first row- one option to go right
    for (int i = 1; i < table.length; i++) {
      table[0][i] = table[0][i - 1] + cost[0][i];
    }

    for (int i = 1; i < table.length; i++) {
      for (int j = 1; j < table[i].length; j++) {
        table[i][j] = cost[i][j] + Math.min(Math.min(table[i][j - 1], table[i - 1][j]), table[i - 1][j - 1]);
      }
    }

    print2D(table);

    return table[m][n];
  }

  public static void main(String[] args) {
    int[][] cost = new int[][] {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
    int m = 2;
    int n = 2;
    System.out.println(cost[m][n]);

    int[][] table = new int[m + 1][n + 1];

    // for(int i=0; i<table.length; i++){
    // 	Arrays.fill(table[i], -1);
    // }

    // print2D(table);
    System.out.println(mcpLoop(cost, m, n));
    System.out.println(mcp(cost, m, n, table));
    print2D(table);
    System.out.println();
    print2D(cost);

  }

  private static void print2D(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }


}