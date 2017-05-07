public class Solution {



  //O(n)
  public static int exOr(int[] nums) {
    int difference = 0;

    if (nums.length > 0) {
      difference = nums[0];
    }

    for (int i = 1; i < nums.length; i++) {
      difference = difference ^ nums[i];
    }


    return difference;

  }

  //below 2 solutions do not work because subtracting needs order
  public static int singleNumber(int[] nums) {

    int neg = 0; //negative direction total
    int pos = 0; //positive direction total

    for (int i = 0 ; i < nums.length; i++) {
      if (nums[i] < 0) {
        neg = Math.abs(neg - nums[i]);
      } else if (nums[i] > 0) {
        pos = Math.abs(pos - nums[i]);
      }
    }

    System.out.println("neg: " + neg);
    System.out.println("pos: " + pos);
    if (pos != 0) {
      return pos;
    } else {
      return neg;
    }
  }

  //O(n)
  public static int dumbSingleNumber(int[] nums) {
    int difference = 0;

    //single negative number
    if (nums.length == 1) {
      difference = nums[0];
    } else {
      for (int i = 0; i < nums.length; i++) {
        difference = Math.abs(difference - nums[i]);
      }
    }

    return difference;

  }

  public static void main(String[] args) {

    int[] nums = {3, 2, 1, 2, 1}; // {1,3,3,1,5};//{-1,3,3,-1,5};
    System.out.println(exOr(nums));
  }

}