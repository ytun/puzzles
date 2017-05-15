import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {

  public static int missingNumber(int[] nums){

  	if(nums.length==1 && ){

  	}

  	int sum=0;
  	for(int i: nums){
  		sum+=i;
  	}

  	int n = nums[nums.length-1];
  	int s = nums[0]-1;
  	return ( n * (n+1) )/2 - sum - ( s * (s+1))/2;
  }


  public static void main(String[] args) {
  	int[] nums={0};//{0,1,3,4};//{4,5,6,8};
    System.out.println(missingNumber(nums));
  }




}


