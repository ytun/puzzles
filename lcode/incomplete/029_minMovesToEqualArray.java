import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {

  //increment (n-1) items by 1= 1 move
  //indexNot = index of item that won't be incremented
  public static void makeMove(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      nums[i]++;
    }
  }

  public static void swapElements(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }


  //make it more efficient!!!
  // note: the only element that could be bigger than the last one is the one before last one
  // after all swaps  are done
  public static int minMoves(int[] nums) {
    int nMoves = 0;
    int lastIndex = nums.length - 1;

    if (nums.length > 1 && nums[lastIndex - 1] < nums[lastIndex]) {
      int i = lastIndex; // i is the index to the left of equal numbers in sorted array
      //eg. 2,3,4,4 -> 3's index = 1 = i
      // sort first
      quickSort(nums, 0, nums.length - 1);

      System.out.println(Arrays.toString(nums));


      while (i > 0) { //>-1 && nums[i-1] != nums[i]){

        System.out.println("after move: \n" + Arrays.toString(nums));

        if (nums[lastIndex - 1] > nums[lastIndex]) {
          swapElements(nums, lastIndex - 1, lastIndex);
          System.out.println("after swap:\n" + Arrays.toString(nums));
        }

        makeMove(nums);
        nMoves++;

        if (i > 0 && nums[i - 1] == nums[i]) {
          i = i - 1;
          System.out.println("i: " + i);
        }
      }
    }
    return nMoves;
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;

    if (low >= high)
      return;

    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];

    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    // recursively sort two sub parts
    if (low < j)
      quickSort(arr, low, j);

    if (high > i)
      quickSort(arr, i, high);
  }

  public static void main(String[] args) {

    int[] nums = {1, 10}; //{0};//{1, 2, 3};
    System.out.println(minMoves(nums));

  }


}


