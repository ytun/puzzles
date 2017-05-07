import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static String convertToBase7(int num) {

    String b7 = "";
    int quotient = num;

    if (Math.abs(num) < 7) {
      return String.valueOf(num);
    }

    while (quotient != 0 ) {
      b7 =  String.valueOf( Math.abs(quotient % 7)) + b7;
      // System.out.println("--: "+b7);
      quotient = quotient / 7;
    }

    if (num < 0) {
      b7 = "-" + b7;
    }
    return b7;

  }


  public static void main(String[] args) {

    int[] nums = { -7}; //{-8, 0, 6, 7, -7, -6, -7, 7, 100, -7};

    for (int num : nums) {
      System.out.println(convertToBase7(num));
    }

  }


}


