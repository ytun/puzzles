public class Solution {


  public boolean detectCapitalUse(String word) {

    //1. Dummy- checking if each letter obeys rule-> linear O(3n)
    //2. Smarter calculation- O(n)
    // rule: difference - 0 or 32 or 32 * length


    for (int i = 0; i < word.length; i++) {
      //1 . if first letter is small -> all the rest has to be small
      //2. else -> all the rest is big or all the rest is small

      if (Character.isUpperCase(word.charAt(0))) {

      }

    }

    return false;

    // return ();

    // Character.isUpperCase('C')
  }




  public static void main(String[] args) {
    // System.out.println(detectCapitalUse(word));
    System.out.println((int)'a');
    System.out.println((int)'A');
    System.out.println((int)'z' - (int)'Z');

  }


}