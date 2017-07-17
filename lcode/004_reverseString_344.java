import java.util.Arrays;

public class Solution {

  public static String reverseString(String s){
    char[] charArr= new char[s.length()];

    String newS= "";

    for(int i=0; i<s.length(); i++){
      charArr[i] = s.charAt(s.length()-1-i);
    }

    return new String(charArr);
  }

  //takes long to append string cus everytime we create new string
  public static String reverseString1(String s){
    
    String newS= "";

    for(int i=0; i<s.length(); i++){
      newS = s.charAt(i) + newS;
    }

    return newS;

  }

  public static void main(String[] args){

    String[] arr ={"abc", ""};

    for(int i=0; i<arr.length; i++){
      System.out.println(arr[i]+": "+reverseString(arr[i]));
  
    }
    
  }
}

















