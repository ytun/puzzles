import java.util.Hashtable;

public class Solution {



  // dumb- search each letter in the O(n^2)
  // a, b
  // aa, ab
  // aa, aab
  //find if subset

  // aa  aab    baa
  // -	   -

  // use binary search O(n log n)
  // use hash set with frequencies

  //Use hashtable - O(n )
  public static boolean canConstruct(String ransomNote, String magazine) {

    Hashtable<Character, Integer> lookUp = new Hashtable<Character, Integer>();

    Integer freq = 0;
    char c = '\0';

    for (int i = 0 ; i < magazine.length(); i++) {
      c = magazine.charAt(i);
      freq = lookUp.get(c);
      if (freq == null) {
        lookUp.put(c, 1);
      } else {
        lookUp.put(c, freq + 1);
      }
    }

    int i = 0;

    // if(ransomNote.length()>0){
    // 	c = ransomNote.charAt(0);
    // 	freq = lookUp.get(c);
    // }
    while (i < ransomNote.length() ) {
      c = ransomNote.charAt(i);
      freq = lookUp.get(c);

      if (freq == null) {
        return false;
      }

      if (freq - 1 > 0) {
        lookUp.put(c, freq - 1);
      } else {
        lookUp.remove(c);
      }

      i++;

    }

    return true;


  }

  public static void main(String[] args) {

    System.out.println(canConstruct("", ""));
  }

}