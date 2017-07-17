import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

  public static List<String> fizzBuzz(int n) {

    List<String> list = new ArrayList<String>();

    for(int i=1; i<=n; i++){

      if(i%3==0){
        

        if(i%5==0){
          list.add("FizzBuzz");
        }
        else{
          list.add("Fizz");
        }
      }
      else if(i%5==0){
        list.add("Buzz");

      }
      else{
        list.add(String.valueOf(i));
      }
    }

    return list;
  }

  public static void main(String[] args){

    int[] arr ={1, 5, 15};

    for(int i=0; i<arr.length; i++){
      System.out.println(arr[i]+": ");
      System.out.println(Arrays.toString(fizzBuzz(arr[i]).toArray(new String[arr.length])) );

    }
    
  }
}

















