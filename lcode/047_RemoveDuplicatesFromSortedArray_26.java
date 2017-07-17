import java.util.Arrays;

public class Solution {

  //constant memory
  public static int  removeDuplicates(int[] nums){
    int nNew = 0;
    int n = nums.length;

    if(n>0){
      nNew++;
    }

    int currI = 0;

    for(int i=1; i<n; i++){
       if( nums[i] - nums[i-1]> 0){
        currI++;
       }
       if(currI!=i){
        nums[currI] = nums[i];
       }


       // System.out.println(nums[i]);
    }
   // System.out.println(Arrays.toString(nums));

    return currI+1;
  }

  // public static int removeDuplicates(int[] A){
  //   if (A.length==0) return 0;
  //   int j=0;
  //   for (int i=0; i<A.length; i++)
  //       if (A[i]!=A[j]) A[++j]=A[i];

  //   System.out.println(Arrays.toString(A));

  //   return ++j;
  // }


  public static void main(String[] args){

    //sorted array

    //3,2,0
    int[][] arr = {{1,1,2},{-1,1,1,1,2}, {1,2}, {} };

    for(int i=0; i<arr.length; i++){
      System.out.println(Arrays.toString(arr[i])+": "+removeDuplicates(arr[i]));
  
    }
    
  }
}

















