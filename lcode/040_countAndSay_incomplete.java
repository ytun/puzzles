import java.util.Map;
import java.util.HashMap;

public class Solution {

  public String helper(String prev){
    String curr="";
    int freq= 1;
    int j = 1;

    while(j<prev.length()){

      if( prev.charAt(j) == prev.charAt(j-1) ){
        freq++;
      }
      else{
        curr = curr + freq+ prev.charAt(j-1) ;
        freq= 1;
      }
      // System.out.println("j: "+ j+", "+curr+"\n");
      j++;

    }

    curr = curr + freq+ prev.charAt(j-1) ;

    if(prev.length()==1){
      curr = "1" + prev;
    }
    return curr;
  }

  public String countAndSay(int n ){
    String curr = "";
    String prev= "1";

    if(n==1){
      return "1";
    }

    for(int i=1; i<n; i++){

      curr = helper(prev);
      prev = curr;
    }

    // System.out.println("i: "+i+"\n"+helper(prev)+"\n");

    return curr;    

  }

  public static void main(String[] args){

    int[] list = {1, 2, 3, 4, 5, 6};

    for(int n: list){
      System.out.println("n: "+n+"\n"+new Solution().countAndSay(n)+"\n");
    }

  }


}


