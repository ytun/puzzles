import java.util.Map;
import java.util.HashMap;

public class Solution {

  // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
  // Special character exists

  static Map<Integer, Character> map = new HashMap<Integer, Character>(){{
    put(1,'I');
    put(5,'V');
    put(10,'X');
    put(50,'L');
    put(100,'C');
    put(500,'D');
    put(1000,'M');
  }};


  // compute combination of 1, 5, 10, etc 
  // eg. 4 = -1 + 5 (if increasing, smaller one has negative)
  //     6 = 5 + 1 (always decreasing)
  public static String IntToRoman(int n){

    String s = "";
    String val = "";

    int prev = 1;

    for(int i = 1; i<=7; i++){
      if(i%2 >0){
        prev = prev * 5;
      }
      else{
        prev = prev * 2;
      }
    }

    System.out.println(prev);
    // while(){



    //   s = s + val;

    // }

    
    return "";
   
  }

  public static void main(String[] args) {

    int n = 0;    
    System.out.println(Solution.IntToRoman(n));


  }



}


