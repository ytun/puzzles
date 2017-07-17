import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;


public class Solution {


  public static int singleNumber_slow(int[] nums) {

    Set<Integer> set = new HashSet<Integer>();
    int singleN = 0;

    for(int i=0; i<nums.length; i++){

      //seen before
      if(set.contains(nums[i])){ //wants constant time
        singleN=0;
        set.remove(nums[i]);
      }
      else{
        set.add(nums[i]);
      }
    }

    Iterator<Integer> it=set.iterator();

    if(it.hasNext()){
      return it.next();
    }

    return -1;

  }


  public static void main(String[] args) {
    int[][] arr = {{1,2,1,3,2}, {}};

    for(int i=0; i<arr.length; i++){
      System.out.println(Arrays.toString(arr[i])+":\n "+singleNumber(arr[i]));
    }

  }


}