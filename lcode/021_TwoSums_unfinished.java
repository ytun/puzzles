import java.util.Arrays;

public class Solution {


  public static int[] twoSum(int[] numbers, int target) {


    // -1, 1, 2, ... 7, 9 , 10
    //  x                x
    // -> search for 0
    //     x -> eliminate 9 and search for 1's complement = 8
    if (numbers.length > 0) {

      int i1 = 0;
      int i2 = numbers.length - 1;
      int complement;

      while (i1 != i2) {

        //potential here found, find complement
        if (numbers[i2] <= target) {
          complement = target - numbers[i2];

          //too small-> keep going to search i1, i2 stays
          if (numbers[i1] < complement) {
            i1++;
          } else if (numbers[i1] > complement) { //both are too big -> cus sum is big
            i1++;
            i2--;
          } else { //found it!
            return new int[] {i1 + 1, i2 + 1};
          }
        } else { //elimnate i2, i1 might have potential
          i2--;
        }

      }
    }
    return new int[] {};

  }

  public static void main(String[] args) {
    int[] numbers = { -1, 1, 2, 5, 7, 9, 10};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(numbers, target)));
  }

}