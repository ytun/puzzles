import java.util.Arrays;

public class Solution {

  // [0,1,0,3,0,0,5,12]

  // //bring numbers to the front
  // [1,0,0,3,0,0,5,12] //remember where u were
  // [1,3,5,12,0,0,0,0] //continue from there

  // [12,1,0,3,0,0,5,0] //update current zero index ++
  // [12,1,3,0,0,5,0,0]  //update index for zero at the end

  // [12,1,3,0,5,0,0] //shift the number right one up and switch
  // [12,1,3,5,0,0,0]

  // [1,0,0,3,12]
  // [1,0,0,3,12]
  // [1,0,3,0,12]

  //move the zeros to the end
  // public static void moveZeroes(int[] nums){
  // 	int i_zero = 0;
  // 	int i_num = 0;

  // 	while(i_num < nums.length-1 && i_zero < nums.length -1){

  // 		//if number
  // 		if(nums[i_num]>0 && i_num < nums.length){

  // 			i_zero ++;
  // 			//find nearest zero
  // 			while(nums[i_zero]!=0  && i_zero< nums.length-1){
  // 				i_zero ++;
  // 			}

  // 			if (i_zero< nums.length-1){

  // 			}
  // 			nums[i_zero] = nums[i_num];
  // 			nums[i_num+1] = 0;
  // 			i_num--;
  // 			i_zero++;
  // 		}
  // 		else{
  // 			nums[]
  // 		}
  // 	}

  // }

  public static void moveZeroes_faster(int[] nums) {

    int i = 0;
    int i_num = 0;
    int zero_count = 0;

    while (i_num <= nums.length - 1) {

      if (nums[i_num] != 0) {
        nums[i] = nums[i_num];
        i++; //increment spot only after substituting
      } else {
        zero_count++;
      }
      i_num++; //always finding number
    }

    System.out.println("zero_count: " + zero_count);
    System.out.println(Arrays.toString(nums));

    for (int j = nums.length - 1; j >= nums.length - zero_count; j--) {
      nums[j] = 0;
    }
  }

  public static void moveZeroes(int[] nums) {
    int i_zero = 0;
    int i_num = 0;
    // int zero_count = 0;


    //this satisfies the condition when there is no zero, or empty array
    while ( i_zero <= nums.length - 1 && i_num <= nums.length - 1) { //i_zero< (nums.length-1 - zero_count) ){

      //key is first find zero. then, find num (to the right of zero)
      // only after zero is found

      // System.out.println(Arrays.toString(nums));
      // System.out.println("i_zero: "+i_zero+", i_num: "+i_num); //+", zero_count: "+zero_count);

      //increment till zero or num is found

      if (nums[i_zero] == 0 && nums[i_num] != 0) {

        if (i_zero < i_num) {
          //swipe
          nums[i_zero] = nums[i_num];
          nums[i_num] = 0;
          //i_zero= i_num;

          // i_num= i_zero+1;
          // zero_count--; //to avoid double-counting zero
        }
        //below is important- to avoid case of forever loop when [1,12,0,1] --i_zero: 2, i_num: 0
        // i_zero=i_num;  // in any case (i_zero>=i_num) or after (i_zero<i_num)

        i_num = i_zero + 1;

      }

      // System.out.println("mid: i_zero: "+i_zero+", i_num: "+i_num); //+", zero_count: "+zero_count);

      if (nums[i_zero] != 0) {
        i_zero++;
      }
      //only if zero has passed number
      // else if(nums[i_zero]==0 && i_num< i_zero && i_zero<nums.length-1){
      // 	i_num=i_zero+1; //find num to the right of zero
      // 	// zero_count++;
      // }

      //pause if num found

      //limit for i_num because i_num could be over limit
      if (i_num <= nums.length - 1 && nums[i_num] == 0) {
        i_num++;
        // zero_count++;
      }


    }

  }

  public static void main(String[] args) {


    int[] nums = { -1, -2, 0, -4, 0, -5}; //{1,12,0,1};////{-959151711,623836953,209446690,-1950418142,1339915067,-733626417,481171539,-2125997010,-1225423476,1462109565,147434687,-1800073781,-1431212205,-450443973,50097298,753533734,-747189404,-2070885638,0,-1484353894,-340296594,-2133744570,619639811,-1626162038,669689561,0,112220218,502447212,-787793179,0,-726846372,-1611013491,204107194,1605165582,-566891128,2082852116,0,532995238,-1502590712,0,2136989777,-2031153343,371398938,-1907397429,342796391,609166045,-2007448660,-1096076344,-323570318,0,-2082980371,2129956379,-243553361,-1549960929,1502383415,0,-1394618779,694799815,78595689,-1439173023,-1416578800,685225786,-333502212,-1181308536,-380569313,772035354,0,-915266376,663709718,1443496021,-777017729,-883300731,-387828385,1907473488,-725483724,-972961871,-1255712537,383120918,1383877998,1722751914,0,-1156050682,1952527902,-560244497,1304305692,1173974542,-1313227247,-201476579,-298899493,-1828496581,-1724396350,1933643204,1531804925,1728655262,-955565449,0,-69843702,-461760848,268336768,1446130876};

    //{0,1,0,3,0,0,5,12};//{1,0};//{0,1,0,3,12};////{1,12,0,1};////;//{0,0,0};//{1,2,3};//{}; //{0,1,0,3,0,0,5,12};
    moveZeroes(nums);

    System.out.println("\nFINAL\n" + Arrays.toString(nums));




  }

}