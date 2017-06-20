import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

//how to get index after sorting
//http://stackoverflow.com/questions/4859261/get-the-indices-of-an-array-after-sorting
  public class Solution {



    // more straightforward lcode solution 
    // in each step of loop,
    // put each number one by one into hashmap 
    // map: (value, index)
    public int[] twoSum(int[] nums, int t){
      HashMap<Integer, Integer> map = new HashMap<>();
      Integer comple =0;

      for(int i=0; i<nums.length; i++){
        comple = (Integer)(t-nums[i]);  //important to cast otherwise, containskey is false
        if( map.containsKey(comple)){
          return new int[]{map.get(comple), i}; //order: earlier values are in the map, so that is first
        }

        map.put(nums[i], i);

        // System.out.println(Arrays.asList(map));
      }

      return new int[]{};

    }

    // using two pointers
    public int[] twoSum_me(int[] nums, int t){
      int[] indices = new int[nums.length];
      // Integer[] indices = new Integer[nums.length];

      for(int i=0; i<nums.length; i++){
        indices[i] = i;
      }

      
      quickSort(nums, indices, 0, nums.length-1);//sortOverride(nums, indices);
      System.out.println(Arrays.toString(indices));
      System.out.println(Arrays.toString(nums));
      // Arrays.sort(nums); //no this will ruin the order

      int i1 = 0;
      int i2 = nums.length -1;

      // no need for the following
      // if(nums[i2] < t || nums[i1]> t){
      //   return new int[]{};
      // }

      while(i1 != i2){

        // if(nums[i2] <= t){
          if(nums[i1] == (t- nums[i2]) ){
            return new int[]{indices[i1], indices[i2]};
          }
          else if(nums[i1] < (t- nums[i2])){
            i1++;
          }
          else{
            i2--;
          }
      }

      return new int[]{};
    }


  public static void sortOverride(int[] nums, Integer[] indices){
    Arrays.sort(indices, new Comparator<Integer>(){
      @Override 
      public int compare(final Integer o1, final Integer o2){
        return Integer.compare(nums[o1], nums[o2]);
      }
    });

    Arrays.sort(nums);

  }

  public static void quickSort(int[] arr, int[] indices, int low, int high) {
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


        temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;

        i++;
        j--;
      }
    }

    // recursively sort two sub parts
    if (low < j)
      quickSort(arr, indices, low, j);

    if (high > i)
      quickSort(arr, indices, i, high);
  }


    // //ways to get indexes after sorting

    // public Object[] sortMeWithIndex(int[] arr){
    //   Map<Integer, Integer> map = new TreeMap<>();

    //   for(int i=0; i<arr.length; i++){
    //     map.put(arr[i], i);
    //   }

    //   Integer[] indices = map.values().toArray(new Integer[map.size()]);
    //   Integer[] sortedArr = map.keys().toArray(new Integer[map.size()]);

    //   return new Object[]{indices, sortedArr};

    // Object[] sorting = sortMeWithIndex(arr);
    //   Integer[] indices = (Integer[])sorting[0];
    //   Integer[] nums = (Integer[])sorting[1];
    // }

    public static void main(String[] args){
      int[] nums = {0, 1, 2,7,11,15};//{2,5,5,11};//{3,2,4};//{2,5,5,11};//{3,2,4};//{0, 1, 2,7,11,15};
      int target = 9;//10;//6;//10;//6;//9;

      Solution sol = new Solution();
      System.out.println(Arrays.toString(sol.twoSum(nums, target)));
    }

}

















