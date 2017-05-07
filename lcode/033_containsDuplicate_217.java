import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {

  //space and time trade off
  //compare all possible pairs - O(n^2) time, O(1) space
  //sort and compare consecutive elements - O(nlog n ) time, O(1) space (excluding space for sorting)
  //O(n) time, O(n) space

  //Quicksort has O(n log n) average and O(n^2) worst case performance
  //BEST Average Case sort algorithm, there are other algos with same performance, but quicksort tends to perform better than most

  //dumb: use hashset for all elements
  public static boolean containsDuplicate(int[] nums) {
    // System.out.println(Arrays.toString(nums));
    Set<Integer> set = new HashSet<Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (!set.add(nums[i])) {
        return true;
      }
    }
    return false;

  }
  // //dumb: use hashset for all elements
  // public static boolean containsDuplicate(int[] nums){
  // 	// System.out.println(Arrays.toString(nums));
  // 	Set<Integer> set = new HashSet<Integer>();

  // 	for(int i=0; i<nums.length; i++){
  // 		if(!set.contains(nums[i])){
  // 			set.add(nums[i]);
  // 		}
  // 		else{
  // 			// System.out.println(set);

  // 			return true;
  // 		}
  // 	}
  // 	return false;

  // }


  public static void main(String[] args) {

    int[][] nums = {{}, {0}, {1, 2, 3}, {1, 2, 3, 3, 3}};

    for (int i = 0; i < nums.length; i++) {
      System.out.println(containsDuplicate(nums[i]));
    }
  }


}


