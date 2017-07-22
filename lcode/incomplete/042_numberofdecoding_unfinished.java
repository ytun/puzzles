// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.


import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.lang.Integer;

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


    // 5
    // 11111
    // 1112
    // 1121
    // 1211
    // 2111
    // 212
    // 221


    // public static int numDecodings(String ori){
    //   if(ori.length()==0){
    //     return 0;
    //   }

    //   // s = '0'
    //   if(Integer.parseInt(ori.substring(0,1))==0){
    //     return 0;
    //   }

    //   String s=ori;
    //   // replace 'x0' with single digit '9'
    //   for(int i=1; i<ori.length(); i++){
    //     if(Integer.parseInt(ori.substring(i,i+1)) == 0 ){

    //       if(Integer.parseInt(ori.substring(i-1,i)) > 0){
    //         s = ori.substring(0,i-1)+ '9'+ori.substring(i+1);
    //       }
    //       else{
    //         return 0;
    //       }
    //     }
    //   }

    //   int n = s.length();
    //   int nWays = 1; 

    //   // System.out.println(s);


    //   for(int start=0; start<n-1; start++){
    //     int pairNum = Integer.parseInt(s.substring(start, start+2));
    //     // System.out.println("start: "+start+", "+s.substring(start, start+2));
    //     if( pairNum>=10 && pairNum <= 26 ){
    //       if(start >= 2){
    //         nWays++;  //for starting with 2
    //       }
    //       nWays++;
    //     }
    //   }

    //   return nWays;
    // }

    public static int numDecodings(String ori){
      if(ori.length()==0){
        return 0;
      }

      if(Integer.parseInt(ori.substring(0,1))==0){
        return 0;
      }

      // String s=ori;
      // // replace 'x0' with single digit '9'
      // for(int i=1; i<ori.length(); i++){
      //   if(Integer.parseInt(ori.substring(i,i+1)) == 0 ){

      //     if(Integer.parseInt(ori.substring(i-1,i)) > 0){
      //       s = ori.substring(0,i-1)+ '9'+ori.substring(i+1);
      //     }
      //     else{
      //       return 0;
      //     }
      //   }
      // }

      // System.out.println(s);

      int n = ori.length();
      int nWays = 1; 

      // if(ori.length() > s.length()){
      //   nWays = 0;
      // }
      boolean containZero = false;

      int start=0;

      for(int end=n; end>=2; end--){ //start=0; start<n-1; start++){
        start = end-2;
        int pairNum = Integer.parseInt(ori.substring(start, end)); //start, start+2));

        // System.out.println("p: "+pairNum);

        if(pairNum>=10 && pairNum <= 26){
          if(start >= 2){
            nWays++;  //for starting with 2
          }
          if(n - end >=2){
            nWays++;
          }
          nWays++;
        }
        else{
          containZero= true;

          if(start >= 2){
            nWays--;  //for starting with 2
          }
          if(n - end >=2){
            nWays--;
          }
          nWays--;
        }

        if(pairNum==0){

          if(start >= 2){
            nWays--;  //for starting with 2
          }
          if(n - end >=2){
            nWays--;
          }
          nWays--;
        
        }
        

        // System.out.println(ori.substring(start, start+2)+", nway: "+nWays);
      }

      // no 111s
      if(containZero){
        nWays--;
      }
      return nWays;
    }


    public static void main(String[] args){
      String[] arr = { "10","110" , "00", "100", "3","12","123", "1212", "12121", "12345", "1234", "123", "0", "10110", "320101"};

      for(int i=0; i<arr.length; i++){
        System.out.println(arr[i]+":");
        System.out.println("nWays: "+numDecodings(arr[i])+"\n");
      }
    }

}

















