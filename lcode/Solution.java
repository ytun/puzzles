import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

  public class Solution {


    public int strStr(String haystack, String needle){
      int hi=0;
      int ni=0;

      if(needle.length()<haystack.length()){
        return -1;
      }

      while(hi<haystack.length()){  //assuming needle is shorter than haystack already checked above
        if(haystack.charAt(hi)!=needle.charAt(ni)){

          if(needle.length() == haystack.length()-ni){
            System.out.println("xx");
            return -1;
          }

          ni++;
        }
        hi++;
      }

      return (ni==needle.length()-1)? (ni-needle.length()-1) : -1;

    }

    public static void main(String[] args){
      Solution sol = new Solution();
      String haystack = "abcfruit";
      String needle = "fruit";
      System.out.println(sol.strStr(haystack, needle));
    }

}

















