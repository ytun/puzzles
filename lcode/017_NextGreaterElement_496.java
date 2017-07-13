import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;


public class Solution2 {


  // nums: [9 8 7 3 2 1 6]
  // stack:[9 8 7 3 2 1 x] -> 1<6 => pop =>[9 8 7> 6]- must be decreasing subsequence
  // map: [1 - 6, 2 - 6, 3 - 6]

  public int[] nextGreaterElement(int[] findNums, int[] nums) {

    Stack<Integer> stack = new Stack<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for(int i =0; i<nums.length; i++){


      while(stack.size()>0 && stack.peek()< nums[i]){
        map.put(stack.pop(), nums[i]);
      }

      stack.push(nums[i]);
    }

    // System.out.println(map);

    for(int i =0 ; i<findNums.length; i++){
      Integer an = map.get(findNums[i]);
      findNums[i] = (an == null)? -1 : an;
    }

    return findNums;


  }











  public int[] nextGreaterElement_mysol_longer(int[] findNums, int[] nums) {

    int[] greaterArr = new int[findNums.length];
    List<Integer> list= new ArrayList<Integer>();
    // java8: IntStream.of(ints).boxed().collect(Collectors.toList());
    //Arrays.asList(nums);

    for(int i=0; i<nums.length; i++){
      list.add(nums[i]);
    }

    // System.out.println("arr:\n"+Arrays.toString(list.toArray()));

    for(int i =0; i<findNums.length; i++){
      int indexEl=list.indexOf(findNums[i]);
      // System.out.println(findNums[i]+" position: "+indexEl);

      greaterArr[i] = -1;

      while( indexEl<list.size()){
        int curr = list.get(indexEl);

        if(curr>findNums[i]){
          greaterArr[i] = curr;
          break;
        }

        indexEl++;
      }
    }

    return greaterArr;

  }

  public static void main(String[] args){

    int[] findNums = {4,1,2};
    int[] nums = {1,3,4,2};

    System.out.println("findNums:\n"+Arrays.toString(findNums));
    System.out.println("nums:\n"+Arrays.toString(nums));

    System.out.println(Arrays.toString(new Solution2().nextGreaterElement(findNums, nums)));
  }

}


