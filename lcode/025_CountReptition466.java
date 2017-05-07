import java.util.Arrays;

public class Solution {

  public static String connectString(String s, int n) {
    String conS = "";

    for (int i = 0; i < n; i++) {
      conS = conS + s;
    }
    return conS;
  }

  public static int maxConvert(String longerS, String s, String s1) {
    // if(longerS.length() > s.length()){
    // 	return 0;
    // }
    int sIL = 0;
    int sI = 0;



    // for(int i=0; i<longerS.length(); i++){

    while (sI < s.length() && sIL < longerS.length()) {

      if ( longerS.charAt(sIL) == s.charAt(sI) ) {
        sI++;
      }

      sIL++;



      // return (index + a)/s1.length();
      // if( ){
      // 	break;
      // }
    }

    // System.out.println("sIL: "+sIL);
    // System.out.println("sI: "+sI);

    int a = 0;
    for (int i = 0; i < s1.length(); i++) {

      if ( ((sIL + a) % (s.length())) == 0) {
        return (sIL + a) / (s.length());
      }

      a++;
    }

    return 0;


    // return ( sIL+ a)/s.length;
    // return (index+a)/s1.length();

  }

  public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {

    if (s1 == s2) {
      // System.out.println("aa");
      // System.out.println(n1 + ","+n1/n2);
      return (int)(n1 / n2);
    }

    String ls1 = connectString(s1, n1);
    String ls2 = connectString(s2, n2);



    // System.out.println("longerS: "+ls1);
    // System.out.println("S2: "+ls2);
    // System.out.println("s1: "+s1);
    return maxConvert(ls1, ls2, s1);
  }

  public static void main(String[] args) {
    // String s1 = "acbi"; int n1=4;
    // String s2 = "ab"; int n2=2;
    String s1 = "lovelive"; int n1 = 100000;
    String s2 = "lovelive"; int n2 = 100000;

    System.out.println(getMaxRepetitions(s1, n1, s2, n2));

  }


}