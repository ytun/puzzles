import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;


public class Solution {


  //inefficient way- combine 2 array, sort and find median

  //more efficient- 

  //if even, median is latter: 1,2,3,4 -> median = (2+3)/2

  public static int binarySearch(int[] nums2, int t){

    int start = 0;
    int end = nums2.length-1;
    int midIndex = -1; // (end-start)/2; //round up if even

    while(start < end){
      midIndex = (end+start)/2;

      if(t < nums2[midIndex]){
        end = midIndex -1; 
      }
      else{
        start = midIndex + 1;
        // midIndex += (nums.length - 1 - midIndex)/2;
      }

      // System.out.println(nums2[midIndex]+", midIndex: "+midIndex);
      
    }

    return (t < nums2[start])? start: start+1;


  }

  public static double getMedium(int[] nums){
    int midindex = nums.length/2;

    if(nums.length%2 ==0){
      return (nums[midindex-1]+nums[midindex])/2.0;
    }
    else{
       return nums[midindex];
    }
  }


  public static double findMedianSortedArrays(int[] nums1, int[] nums2){

    if(nums1.length==0 && nums2.length==0){
      return -1;
    }
    else if(nums1.length==0 ){
      return getMedium(nums2);
    }
    else if(nums2.length==0){
      return getMedium(nums1);
    }

    double mediumPoint1 = (nums1.length-1)/ 2.0;
   int mediumIndex1 = (int)mediumPoint1;
    // System.out.println("median in num1: "+nums1[mediumIndex1]);


    int posMedianInNums2 = binarySearch(nums2, nums1[mediumIndex1]);
    // System.out.println("posMedianInNums2: "+posMedianInNums2);


    if(posMedianInNums2 <= (nums2.length-1)/ 2.0 ){
      // System.out.println(" **");
      return helper(nums1, nums2);//, mediumPoint1, mediumIndex1, posMedianInNums2);
    }
    else{
      // System.out.println(" else");

      return helper(nums2, nums1);//, mediumPoint1, mediumIndex1, posMedianInNums2);
    }

  }

  public static double helper(int[] nums1, int[] nums2){ //, double mediumPoint1, int mediumIndex1, int posMedianInNums2){
  

    double mediumPoint1 = (nums1.length-1)/ 2.0;
   int mediumIndex1 = (int)mediumPoint1;
    // System.out.println("median in num1: "+nums1[mediumIndex1]);


    int posMedianInNums2 = binarySearch(nums2, nums1[mediumIndex1]);
    // System.out.println("posMedianInNums2: "+posMedianInNums2);

    
    double offsetInNums1 = 0;

    if(nums1.length%2==0){
      offsetInNums1 = -0.5;
    }

    double newMedium = (nums1.length + nums2.length -1) /2.0;

    double offset = newMedium - mediumPoint1 - posMedianInNums2 ; 
    // posMedianInNums2 is because to consider numbers before medium 2
    
    // System.out.println("mediumPoint1: "+mediumPoint1);
    // System.out.println("newMedium: "+newMedium);

    int i = 0;
    //start moving from old to actual median
    int curri1 = (int)(mediumIndex1 - offsetInNums1)+1;
    int curri2 = posMedianInNums2;
    int prev = 0;
    int curr = 0;  

    // need to find one more element insertion for decimal medium
    if( (newMedium%1)!=0 ){
      offset++;
      
    }
    // System.out.println("offset: "+offset);

    while(offset>0 && (curri1< nums1.length || curri2< nums2.length) ){


      if(curri1>= nums1.length && curri2< nums2.length){
        prev= curr;
        curr = nums2[curri2];
        curri2 ++;
      }

      else if(curri2>= nums2.length && curri1< nums1.length){
        prev= curr;
        curr = nums1[curri1];
        curri1 ++;
      }

      else{

        // System.out.println("curri1: "+nums1[curri1]+", curri2: "+nums2[curri2]);

        if(nums1[curri1] < nums2[curri2]){
          prev= curr;
          curr = nums1[curri1];

          if(curri1< nums1.length){
            curri1 ++;
          }
          
        }else{
          prev= curr;
          curr = nums2[curri2];
          
          if(curri2< nums2.length){
            curri2 ++;
          }
        }

      }
      // System.out.println("i: "+i+", curr: "+curr);

      offset--;
      // System.out.println("offset: "+offset+"\n");


    }

    //full integer
    if( (newMedium%1) ==0 ){
      return curr;
    }
    else{
      return (prev+curr)/2.0;
    }



  }

  public static void testBinarySearch(){
    int[] nums2 = {0,2,3,5,10,12};
    System.out.println(Arrays.toString(nums2));
    System.out.println("0: "+binarySearch(nums2, 0));
    System.out.println("-1: "+binarySearch(nums2, -1));
    System.out.println("13: "+binarySearch(nums2, 13));
    System.out.println("3: "+binarySearch(nums2, 3));
    System.out.println("7: "+binarySearch(nums2, 7));
  }

  public static void main(String[] args) {

    // working every case except {1}, {1}

    // 5, 8, 2.5, 2.5, 1, 2.5
    int[][] arr1 = {{}, {1}, {1,3,7,9}, {1,3,7,12}, {1,2}, {1,3}, {1,3}, {3,4}};
    int[][] arr2 = {{1}, {1},{2,5,12}, {8,9,10},{3,4}, {2,4}, {2}, {1,2}};

    for(int i=0; i<arr1.length; i++){
      System.out.println(Arrays.toString(arr1[i])+"\n"+Arrays.toString(arr2[i]));
      System.out.println("> "+findMedianSortedArrays(arr1[i], arr2[i])+"\n");
    }

  }


}