import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.lang.Integer;

public class Solution {

  // public static int getMaxIntDigit(){
  //    return (int)Math.floor(Math.log10(Integer.MAX_VALUE)) + 1;
  // }

  public static int reverse(int x){

    String s = String.valueOf(x);
    String revS = "";
    String prefix = "";

    if(s.length()>0 && s.charAt(0)=='-'){
      prefix = "-";
      s= s.substring(1);
    }

    for(int i=s.length()-1; i>=0; i--){
       revS += s.charAt(i); // Character.getNumbericValue(s.charAt(i))
    }
    revS= prefix+revS;

    try{
      return Integer.parseInt(revS);  
    }
    catch(java.lang.NumberFormatException e){
      return 0;
    }
    
  }


  public static void main(String[] args){

    int[] arr = {123, -321, 0, 214748364, 2147483647};

    for(int i=0; i<arr.length; i++){
      System.out.println(arr[i]+": "+reverse(arr[i]));
  
    }
    
  }
}

















