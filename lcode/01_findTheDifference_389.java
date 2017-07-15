import java.util.Arrays;

public class Solution {
  public static char findTheDifference_Inefficient(String s, String t) {

    for (char c : s.toCharArray()) {
      t = t.replaceFirst(Character.toString(c), "");
    }

    System.out.println("---->" + t);
    return t.charAt(0);

  }

  public static char findTheDifference(String s, String t){

  	int[] alphaArr = new int[26];
  	char curr= '\0';
  	int currAscii = 0;

  	for(int i=0; i<s.length(); i++){
  		currAscii = (int)s.charAt(i);
      // System.out.println(currAscii-97);
  		alphaArr[currAscii-97] += 1;
      // System.out.println(alphaArr[currAscii-97]);
  	}

    // System.out.println(Arrays.toString(alphaArr));

  	for(int i=0; i<t.length(); i++){
  		currAscii = (int)t.charAt(i);

      alphaArr[currAscii-97] --;

  		if(alphaArr[currAscii-97] <0){
  			return t.charAt(i);
  		}
  	}

  	return '\0';
  }

  public static void main(String[] args){

  	String a = "abc";
  	String[] arr = {"cbea", "bca", ""};

  	System.out.println(a+"\n");

  	for(int i=0; i<arr.length; i++){
  		System.out.println(a+", "+arr[i]+": "+findTheDifference(a,arr[i]));
  	}

    String s ="a";
    String t = "aa";
    System.out.println(s+", "+t+": "+findTheDifference(s, t));


  }
}