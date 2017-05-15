import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {

  public static void reverseWord(char[] sent, int start, int end) {


    int length = end - start + 1;

    // System.out.println("length: " + length + ", start: " + start + ", end: " + end);
    // String reverseW = "";

    //reverse half of word
    // for(int i=start; i< start+length/2; i++){
    // 	char tempC = sent.charAt(i);

    // 	w.length

    // }

    for (int i = 0; i < length / 2; i++) {
      //swap
      char tempC = sent[start + i];
      sent[start + i] = sent[end - i];
      sent[end - i] = tempC;
    }
    // System.out.println(Arrays.toString(sent));
  }

  // more effficient
  public static String reverseWords(String sentStr) {

    char[] sent = sentStr.toCharArray();

    // start index of a word
    int start = 0;
    int end = 0;

    for (int i = 0; i < sent.length; i++) {

      if (sent[i] == ' ') {
        end = i - 1; //update end
        reverseWord(sent, start, end);
        start = i + 1; //update start
      }
      if (i == sent.length - 1) {
        end = i; //update end
        reverseWord(sent, start, end);
        start = i + 1; //update start
      }

    }

    return new String(sent);

  }




	// not too efficient
  public static String reverseWords_split(String sent) {

    String reverse = "";
    String[] words = sent.split(" ");

    for (String w : words) {
      String rWord = "";
      //reverse the word itself
      for (int i = 0; i < w.length(); i++) {
        rWord = w.charAt(i) + rWord;
      }
      reverse = reverse + " " + rWord;
      // System.out.println(w);
    }

    return reverse.substring(1);

  }

  public static void main(String[] args) {
    String sent = "Let's take LeetCode contest";
    System.out.println(reverseWords(sent));
  }



}


