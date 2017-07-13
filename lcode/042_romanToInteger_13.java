import java.util.Map;
import java.util.HashMap;

public class Solution {

  // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
  // Special character exists

  static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
    put('I',1);
    put('V',5);
    put('X',10);
    put('L',50);
    put('C',100);
    put('D',500);
    put('M',1000);
  }};

  public static int romanToInt(String s){

    int val = 0;
    int cVal = 0;
    char c = '\0';

    for(int i=0; i<s.length(); i++){

      c = s.charAt(i);
      cVal = map.get(c);

      if( i+1 <s.length() && cVal < map.get(s.charAt(i+1))){
        val -= cVal;
      }
      else{
        val += cVal;
      }
    }

    return val;

  }

  public static void main(String[] args) {
    
    String s= "IV";
    System.out.println(Solution.romanToInt(s));


  }



}


