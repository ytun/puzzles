import java.util.Arrays;
import java.lang.StringBuilder;

public class Solution {
  public String longestCommonPrefix_clearcode(String[] strs){

    if (strs!= null && strs.length > 0){

      Arrays.sort(strs);

      String firstStr = strs[0];
      String lastStr = strs[strs.length-1];

      int index=0;

      while(index< Math.min(firstStr.length(), lastStr.length()) && firstStr.charAt(index) == lastStr.charAt(index)){
        index++;
      }

      return firstStr.substring(0, index);

    }

    return "";
  }

  public String longestCommonPrefix_1(String[] strs) {
    StringBuilder result = new StringBuilder();
    
    if (strs!= null && strs.length > 0){
    
      Arrays.sort(strs);
      
      char [] a = strs[0].toCharArray();
      char [] b = strs[strs.length-1].toCharArray();
      
      for (int i = 0; i < a.length; i ++){
        if (b.length > i && b[i] == a[i]){
            result.append(b[i]);
        }
        else {
            return result.toString();
        }
      }
      return result.toString();
    }
    return "";
  }

  //14ms - stringbuilder
  //17ms - concatenation string
  public String longestCommonPrefix_me_lcode_supposedtobeefficientbutdidntusestringbuilder(String[] strs){

    if(strs==null || strs.length==0){
      return "";
    }

    Arrays.sort(strs);

    String firstStr = strs[0];
    String lastStr = strs[strs.length-1];
    String prefix = "";
    char currChar = '\0';

    StringBuilder result = new StringBuilder();

    for(int i=0; i<firstStr.length(); i++){
      currChar = firstStr.charAt(i);
      if(i<lastStr.length() &&  currChar == lastStr.charAt(i)){
        result.append(currChar);
        // prefix += currChar;
      }
      else{
        // return prefix;
        return result.toString();
      }

    }

    return result.toString();
    // return prefix;


  }


  public String longestCommonPrefix_lcode_sol1_notsofast(String[] strs){


    if(strs==null || strs.length==0){
      return "";
    }

    int index=0;
    String pre = strs[0];
    int si=1;

    //prefix is first string whole

    while(si<strs.length){
     while(strs[si].indexOf(pre)!=0){
      pre = pre.substring(0, pre.length()-1 );
     } 
     si++;
    }
    return pre;
  }




  public String longestCommonPrefix_me_slow(String[] strs){

    int index = 0; //index of character
    int numStr = strs.length;
    String prefix = ""; 

    int si = 0;
    char currChar='\0';
  
    if(numStr==1){
      return strs[0];
    }

    while(si<numStr &&  index < strs[si].length() ){
      currChar = strs[si].charAt(index);

      if(si+1 < numStr && index < strs[si+1].length() && currChar == strs[si+1].charAt(index)){
        si++;
      }
      else{
        return prefix;
      }

      // if all strings are explored, prefix add and rewind to the beginning
      if(si == numStr || si+1 == numStr){
        prefix += currChar;
        index++;
        si = 0;
      }
    }
    return prefix;
    
  }

 public static void main(String[] args){


    String[][] strs = { {}, {"",""}, {"a"}, {"aa", "a"}, {"apple", "apples", "apps"}, {"a","b"}  }; 

    Solution sol = new Solution();

    for(String[] s: strs){
      System.out.println(Arrays.toString(s));
      System.out.println(sol.longestCommonPrefix(s));
    }

  }


}

