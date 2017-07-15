import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {

  // S(n) * 2 = n * (n+1)
  // S(n) = n (n+1) / 2

  // + + +
  // x + +
  // x x +
  // x x x



  public static int missingNumber(int[] nums){

    if(nums.length==0){
      return 0;
    }

    int sum=0;
    int max = 0;

    for(int i=0; i<nums.length; i++){
      sum += nums[i];

      if(nums[i]>max){
        max = nums[i];
      }
    }

    int expectedSum = max * (max+1) /2;
    int diff = (expectedSum - sum);

    // System.out.println("sum: "+sum + ", max: "+max+", exSum: "+expectedSum+", diff: "+diff);

    //edge cases

    //missing 0
    if(diff == 0){
      if(nums.length-1 != max){
        return 0; 
      }
      //missing last number {0,1} -> {2}
      else{
        return max+1;
      }
    }
    return diff; 

  }

  // // if sorted
  // public static int missingNumber(int[] nums){

  //   if(nums.length==0 || nums[0]!=0){
  //     return 0;
  //   }

  //   for(int i=1; i<nums.length; i++){
  //     if(nums[i] - nums[i-1] != 1){
  //       return nums[i-1]+1;
  //     }
  //   }

  //   return nums[nums.length-1]+1;

  // }


  public static void main(String[] args){

    int[][] nums = { {0}, {0, 1, 3} , {}, {0,1}, {1, 0}, {1,2}};

    for(int i=0; i<nums.length; i++){
      System.out.println(Arrays.toString(nums[i])+"\n"+missingNumber(nums[i]));
    }
  }

}


