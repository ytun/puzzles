
import java.util.Arrays;

public class LongestCommonSubsequence {


  //sol is not totally workking -- string apending i mean

  public static int lcs_helper_recursive(String X, String Y, int m, int n, int[][] lcsTable) {
    int length = 0;

    // System.out.println("m: "+m +", n: "+n);

    if(m==0 || n==0){
      length= 0;

      if(X.charAt(m)==Y.charAt(n)){
        // sol+= X.charAt(m);
        length= 1;
      }
    }
    else{
      if(X.charAt(m)==Y.charAt(n)){
        // sol += X.charAt(m); 
        length= (lcsTable[m-1][n-1]>-1)? lcsTable[m-1][n-1] +1 : lcs_helper_recursive(X, Y, m-1, n-1, lcsTable) + 1;
      }
      else{
        length=  Math.max( (lcsTable[m][n-1]>-1)? lcsTable[m][n-1]: lcs_helper_recursive(X, Y, m, n-1, lcsTable), (lcsTable[m-1][n]>-1)? lcsTable[m-1][n]: lcs_helper_recursive(X, Y, m-1, n, lcsTable) ) ;
      }
    
    }

    lcsTable[m][n] = length;

    if(m==X.length()-1 && n==Y.length()-1){
      print(lcsTable);
      // System.out.println("sol: "+sol);

    }

    return length;

  }

  public static int lcs_iterative(String X, String Y){
    int[][] lcsTable = new int[X.length()][Y.length()];

    for (int i = 0 ; i < X.length(); i++) {
      Arrays.fill(lcsTable[i], -1);
    }
    String sol="";

    int m = X.length()-1;
    int n= Y.length() -1;

    for(int i=0; i<X.length(); i++){
      for(int j=0; j<Y.length(); j++){


        // System.out.println(i+", "+j);

        if(i==0 || j==0){
          lcsTable[i][j] =0;

          if(X.charAt(i)==Y.charAt(j)){
            sol+= X.charAt(i);
            lcsTable[i][j]=1;
          }
        }
        else{
          if(X.charAt(i)==Y.charAt(j)){
            lcsTable[i][j] = 1+ lcsTable[i-1][j-1];
            sol+= X.charAt(i);
          }
          else{
            

            lcsTable[i][j] = Math.max(lcsTable[i-1][j], lcsTable[i][j-1]);
          }
        }
        


      }
      // print(lcsTable);

    }
    
    System.out.println("sol: "+sol);

    print(lcsTable);

    return lcsTable[m][n];

  }


  public static void print(int[][] table) {
    for (int i = 0; i < table.length; i ++) {
      System.out.println(Arrays.toString(table[i]));
    }
    System.out.println();
  }

  public static void main(String[] args) {

    String Y = "AGGTAB";//"aggtab"; //6
    String X = "GXTXAYB"; //7

    int[][] lcsTable = new int[X.length()][Y.length()];

    for (int i = 0 ; i < X.length(); i++) {
      Arrays.fill(lcsTable[i], -1);
    }

    

    // System.out.println(Arrays.deepToString(lcsTable));

    System.out.println(lcs_helper_recursive(X, Y, X.length()-1 , Y.length()-1 , lcsTable));
    System.out.println(lcs_iterative(X, Y));

  }
}