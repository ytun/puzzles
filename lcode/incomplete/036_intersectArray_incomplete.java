// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {

  // sol 1: dumb: HashMap (value,freq) -> Time: O(n) * 3 times. Space: O(n)
  // sol 2: sort. Compare consecutive elements. this is spacially and timely efficient. Time: O(nlogn)/O(n) * 2, Space: O(1)

  // 1. already sorted, yes this will optimize my algo
  // 2.
  public static int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    System.out.println(Arrays.toString(nums1));
    Arrays.sort(nums2);
    System.out.println(Arrays.toString(nums2));


    // int[] intersect =
    List<Integer> intersect = new ArrayList<Integer>();

    for (int p1 = 0, p2 = 0; p1 < nums1.length && p2 < nums2.length; ) {

      if (nums1[p1] < nums2[p2]) {
        p1++;
      } else if (nums1[p1] > nums2[p2]) {
        p2++;
      } else {
        intersect.add(nums1[p1]);
        p1++;
        p2++;
      }
    }

    int[] intersectArr = new int[intersect.size()];

    for (int i = 0; i < intersect.size(); i++) {
      intersectArr[i] = intersect.get(i);
    }

    return intersectArr;
  }


  public static void main(String[] args) {

    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 3, 2};
    System.out.println(Arrays.toString(intersect(nums1, nums2)));


  }



}



// int[] ints  = Ints.toArray(list);

// ArrayUtils.toPrimitive(intersect.toArray(arr));
// int[] arr = new int[intersect.size()];
// // arr = intersect.toArray(arr);
// int[] aa = ArrayUtils.toPrimitive(intersect.toArray(new Integer(intersect.size)));

