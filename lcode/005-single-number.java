public class Solution {
    public int singleNumber(int[] nums) {
        System.out.println(nums);
        
        int e=nums[0];
        // boolean found=false;
        // int prev=nums[0];
        
        for(int i=1; i<nums.length ; i++){
            e=e-nums[i];
            System.out.println(e);
        }
     
        return (e<0? -e: e);   
    }
}