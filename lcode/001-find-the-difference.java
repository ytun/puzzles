public class Solution {
  public char findTheDifference(String s, String t) {

    for (char c : s.toCharArray()) {
      t = t.replaceFirst(Character.toString(c), "");
    }

    System.out.println("---->" + t);
    return t.charAt(0);

  }
}