
import java.util.Arrays;

public class Solution{

  // idea: 
  // 0, 2, 3, 7, 8, 11, 15

  // p1, p2
  // 0, 15  (p1 + p2) >t
  // 0, 11
  // 0, 8   (p1 + p2) <t  => i1++  , else => i2--;
  // 2, 8     ** i2 stays as it is -> cause (0+11)> t => (2+11) > t for sure => so good with (0+8) , (2+8) 
  // 2, 7   (p1 + p2) ==t => return 

  public int[] twoSum(int[] nums, int t){
    int[] indexArr = new int[2];    
    int i1=0; 
    int i2=nums.length-1;

    if(nums.length==0 ){
      return indexArr;
    }

    while( i1<i2 ){
      // System.out.println(nums[i1]+", "+nums[i2]);

      if(nums[i1] + nums[i2] > t){
        i2--;
      }
      else if(nums[i1] + nums[i2] < t){
        i1++;
      }
      else{
        indexArr = new int[]{i1+1 , i2+1};
        break;
      }


    }

    return indexArr;
  }

  public static void main(String[] args){

    int[] numbers = {0, 2, 3, 7, 8, 11, 15};
    int target = 9;


    System.out.println(Arrays.toString(new Solution().twoSum(numbers, target)));

  }


}