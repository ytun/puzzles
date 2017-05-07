public class Solution {

  public static int findMaxConsecutiveOnes(int[] nums) {
    int curr_ones = 0;
    int max_ones = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        curr_ones++;
      } else {
        if (curr_ones > max_ones) {
          max_ones = curr_ones;
        }
        curr_ones = 0;
      }

      //if see zero or end of list, max=curr if greater and reset curr to 0
      //only if curr>max, replace max with curr
      // System.out.println(curr_ones);

    }
    if (curr_ones > max_ones) {
      max_ones = curr_ones;
    }

    return max_ones;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 0, 1, 1, 1};
    System.out.println(findMaxConsecutiveOnes(nums));

  }
}