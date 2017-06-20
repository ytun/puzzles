public class Solution {
  public String reverseString(String s) {
    String n = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      n = n + s.charAt(i);
    }
    return n;
  }
}