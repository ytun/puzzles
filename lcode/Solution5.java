
import java.util.Arrays;

public class Solution5 {

   

  public static void spiral(int[][] nums){
    int jsize= 0;

    if(nums.length>0){
      jsize = nums[0].length;
    }

    int isize = nums.length;
    int total = jsize * isize;
    int thres= 0;
    int i=0;

    int count = 0;


    while(count< total ){
      thres = jsize-1;

      for(int k=0; k<thres; k++){
        
        System.out.println(nums[i][j]);

      }

    }

    

  }


  public static void main(String[] args) {
  	int[][] nums = new int[][]{
      {1, 2, 3},
      {8, 9, 4},
      {7, 6, 5}
    };

    Solution5.spiral(nums);


  }




}


