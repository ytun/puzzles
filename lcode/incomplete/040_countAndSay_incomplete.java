// The count-and-say sequence is the sequence of integers with the first five terms as following:

// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth term of the count-and-say sequence.

// Note: Each term of the sequence of integers will be represented as a string.

// Example 1:

// Input: 1
// Output: "1"
// Example 2:

// Input: 4
// Output: "1211"




// http://www.careercup.com/question?id=4425679

// "Count and Say problem" Write a code to do following:

// n String to print
// 0 1
// 1 1 1
// 2 2 1
// 3 1 2 1 1
// ...
// Base case: n = 0 print "1"
// for n = 1, look at previous string and write number of times a digit is seen and the digit itself. In this case,
// digit 1 is seen 1 time in a row... so print "1 1"
// for n = 2, digit 1 is seen two times in a row, so print "2 1"
// for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1"
// for n = 4 you will print "1 1 1 2 2 1"
// Consider the numbers as integers for simplicity. e.g. if previous string is "10 1" then the next will be "1 10 1 1" and the next one will be "1 1 1 10 2 1"

import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

  public class Solution {

    public String countAndSay(int n){

      String nStr = Integer.toString(n);

      if(nStr==null || nStr.length()<=1){
        return nStr;
      }

      char prevC = '\0';//nStr.charAt(0);

      String result = "";
      int count =0;//1;

      // System.out.println("nStr: "+nStr + ", len: "+nStr.length());

      int i=0;

      while(i<nStr.length()){

        count++;

        if( i==nStr.length()-1 || ( i+1<nStr.length() && nStr.charAt(i)!=nStr.charAt(i+1))){
          result += Integer.toString(count) + nStr.charAt(i);
          count=0;
        }
        
        // System.out.println("count: "+count + ", cc: "+nStr.charAt(i)+ ", " + result);
       
        i++;
      }

      return result;

    }


    //below is inefficient- not totally working.
      // for(int i= 1; i<nStr.length(); i++){

      //   // c = nStr.charAt(i);
      //   System.out.println("count: "+count + ", cc: "+nStr.charAt(i)+ ", " + result);

      //   if(count==0 || prevC==nStr.charAt(i)){
      //     count++;
      //   }
      //   else{
      //     result += Integer.toString(count)+prevC;
      //     count =1;
      //   }

      //   prevC = nStr.charAt(i);
      // }
      // return result;

    public static void main(String[] args){
      Solution sol = new Solution();
      int n = 1000; //111221;
      System.out.println(sol.countAndSay(n));

    }

}

















