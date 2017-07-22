
import java.util.Arrays;

public class LongestCommonPalindrome {

  public static String reverseString(String s){
    String rev="";

    for(int i=0; i<s.length(); i++){
      rev = s.charAt(i) + rev;
    }
    return rev;
  }

  //sol is not totally workking -- string apending i mean

  public static int lcs_helper_recursive(String X, int m, int n, int[][] lcsTable, String sol) {
    int length = 0;

    // System.out.println("m: "+m +", n: "+n);

    
    if(m==n ){
      sol +=  X.charAt(m) ; 
      length =1;
    }
    
    else if(m+1 ==n && X.charAt(m)==X.charAt(n)){
        sol += X.charAt(m) +  X.charAt(n); 
        length= 2;
    }
    else{
      if(X.charAt(m)==X.charAt(n)){
         sol = X.charAt(m) + sol + X.charAt(n); 
        length=  (lcsTable[m+1][n-1]>-1)? lcsTable[m+1][n-1] +1 : lcs_helper_recursive(X, m+1, n-1, lcsTable, sol) + 2;
      }
      else{
        length=  Math.max( (lcsTable[m+1][n]>-1)? lcsTable[m+1][n]: lcs_helper_recursive(X, m+1, n, lcsTable, sol), (lcsTable[m][n-1]>-1)? lcsTable[m][n-1]: lcs_helper_recursive(X, m, n-1, lcsTable, sol) ) ;
      }
    
    }

    lcsTable[m][n] = length;

    // if(m==X.length()-1){
    //   print(lcsTable);
    //   System.out.println("sol: "+sol);

    // }

    return length;

  }


  // i, j
  // 0, 2  -> cl = (j-i) 

  // 0, 1
  // 1, 2 

  // 0, 0
  // 1, 1
  // 2, 2


  public static int lcp_iterative(String X){
    int[][] lcsTable = new int[X.length()][X.length()];

    String sol="";

    for (int i = 0 ; i < X.length(); i++) {
      Arrays.fill(lcsTable[i], -1);
    }

    String Y = reverseString(X);

    System.out.println(X+"\n"+Y);

    for(int i=0; i<X.length(); i++ ){
      sol += X.charAt(i) ; 
      lcsTable[i][i]=1;
    }

    print(lcsTable);

    int m = X.length()-1;
    int n= Y.length() -1;

    int j=0;

    for(int cl=1; cl<X.length(); cl++){
        for(int i=0; i<X.length(); i++){

        j = cl + i ;

        if(j>X.length()-1){
          continue;
        }
        // System.out.println(i+", "+j);

        
        if(i+1 ==j && X.charAt(i)==X.charAt(j)){
          // System.out.println("**2: "+i+", "+j);
          sol += X.charAt(i) +  X.charAt(j); 
          lcsTable[i][j]=2;
        }
        else{
          if(X.charAt(i)==X.charAt(j)){
            sol = X.charAt(i) + sol + X.charAt(j); 

            lcsTable[i][j] = 2+ lcsTable[i+1][j-1];
          }
          else{

            lcsTable[i][j] = Math.max(lcsTable[i+1][j], lcsTable[i][j-1]);
          }
        }
      }
      // print(lcsTable);
    }
    
    System.out.println("sol: "+sol);

    print(lcsTable);

    return lcsTable[m][n];

  }

  public static int lcp_recursive(String X){
    int[][] lcsTable = new int[X.length()][X.length()];

    for (int i = 0 ; i < X.length(); i++) {
      Arrays.fill(lcsTable[i], -1);
    }

    String Y = reverseString(X);
    String sol="";
    System.out.println(X+"\n"+Y);

    int x= lcs_helper_recursive(X, 0 , X.length()-1 , lcsTable, sol);
    print(lcsTable);
    System.out.println(sol);
    return x;
  }

  //solution
  static int lps(String seq)
    {
       int n = seq.length();
       int i, j, cl;
       int L[][] = new int[n][n];  // Create a table to store results of subproblems
      
       // Strings of length 1 are palindrome of lentgh 1
       for (i = 0; i < n; i++)
           L[i][i] = 1;
              
        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // http://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                   L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                   L[i][j] = L[i+1][j-1] + 2;
                else
                   L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
            }
        }
        
        print(L);
        return L[0][n-1];
    }


  public static void print(int[][] table) {
    for (int i = 0; i < table.length; i ++) {
      System.out.println(Arrays.toString(table[i]));
    }
    System.out.println();
  }

  public static void main(String[] args) {

    // String Y = "AGGTAB";//"aggtab"; //6
    // String X = "GXTXAYB"; //7

    String X = "BBABCBCAB";

    // System.out.println(Arrays.deepToString(lcsTable));

    // System.out.println(lps(X));

    // System.out.println(lcp_recursive(X));
    System.out.println(lcp_iterative(X));


  }
}