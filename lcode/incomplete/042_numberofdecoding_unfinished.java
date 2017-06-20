import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

  public class Solution {


    //0 -> A, AB, ABC
    //1 -> B, BC
    //2 -> C 

    //

    // ABC 
    //-> 111, A, B, C
    //-> 12, A, BC
    //-> 21, AB, C
    //-> 3, ABC


    public int numDecodings(String s){

      int i=0; int x=0;
      int nways=0;

      //while(i<s.length){
      for(int i=0; i<s.length; i++){
        x =Integer.valueOf(s.charAt(i));

        if(x>=0 && x<=26){
          nways++;
        }
      }

    }


    public static void main(String[] args){
      String[] arr = {"3","12","123"};

      for(int i=0; i<arr.length; i++){
        System.out.println(numDecodings(arr[i]));
      }
    }

}

















