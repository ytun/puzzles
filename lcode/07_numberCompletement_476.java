
import java.util.Arrays;
import java.lang.Byte;

public class Solution{

 // saw sample soln hint
  public int findComplement(int num){
    
    int x = num;
    int allOnes = 1;
    int nBits = 1; //number of bits of num

    // round up to nearest 2 exponential
    while(x/2 >= 1){
      allOnes += Math.pow(2, nBits);
      x = x/2;
      nBits++;
    }

    // System.out.println("n bits: "+nBits);
    // System.out.println("allOnes: "+allOnes);


    return (allOnes - num);

  }

  public static void main(String[] args){

    //1, 2, 0, 1
    int[] nums = {2, 5, 1, 0};

    for(int i=0; i<nums.length; i++){
      System.out.println(nums[i]+", "+new Solution().findComplement(nums[i]));
    }
    
  }


}