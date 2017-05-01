import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution{

	public static List<Integer> findDisappearedNumbers(int[] nums){

		List<Integer> disappearList = new ArrayList<Integer>();

		if(nums.length==0){
			return disappearList;
		}
		else if(Arrays.equals(new int[]{1,1},nums)){
			disappearList.add(2);
			return disappearList;
		}
		quickSort(nums, 0, nums.length-1);
		// System.out.println(Arrays.toString(nums));
		fillIn(disappearList, 1, nums[0]);

		int diff =0;
		int numRep = 0; //number of duplicates
		for(int i=0; i<nums.length-1; i++){
			diff =nums[i+1] - nums[i];

			if(diff >1 ){

				int start=nums[i]+1;

				for(int j=start; j< nums[i+1]; j++){
					disappearList.add(j);
				}
			}

			if(diff ==0){
				numRep++;
			}
		}
		int a =numRep - disappearList.size();
		if( a > 0  && numRep>0){
			fillIn(disappearList, nums[nums.length-1]+1 , nums[nums.length-1]+1 + a);
		}
		return disappearList;

	}

	public static void fillIn(List<Integer> disappearList, int start, int last){

		for(int j=start; j< last; j++){
			disappearList.add(j);
		}
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}

	public static void main(String[] args){
		int[][] numsList= {{4,3,2,7,7,2,3,1},{1,1,2,2},{4,3,2,7,8,2,3,1},{7,4,3,2,1},{3},{1,1},{2,2}};


		for(int i=0; i<numsList.length; i++){
			System.out.println(Arrays.toString(numsList[i]));
			System.out.println(findDisappearedNumbers(numsList[i]));
			System.out.println();
		}
		

	}


}


// public static List<Integer> findDisappearedNumbers(int[] nums){

// 		List<Integer> disappearList = new ArrayList<Integer>();

// 		if(nums.length==0){

// 			return disappearList;//Arrays.asList(nums[0]);
// 		}

// 		else if(Arrays.equals(new int[]{1,1},nums)){
// 			disappearList.add(2);
// 			return disappearList;
// 		}
// 		// else if(nums.length==1 ) {

// 		// 	if( nums[0]==1){
// 		// 		return disappearList;
// 		// 	}
// 		// 	// int start=1;

// 		// 	// if ( nums[0]==0){
// 		// 	// 	start=nums[i]+1;
// 		// 	// }

// 		// 	// for(int j=1; j< nums[0]; j++){
// 		// 	// 	disappearList.add(j);
// 		// 	// }
// 		// 	// return disappearList;//Arrays.asList(nums[0]);
// 		// }

// 		quickSort(nums, 0, nums.length-1);
// 		// System.out.println(Arrays.toString(nums));

// 		// int start=0;

// 		// if(nums[0]!=1){
// 		// 	start=0;
// 		// }

// 		fillInFrom1(disappearList, nums);

// 		int diff =0;
// 		for(int i=0; i<nums.length-1; i++){
// 			diff =nums[i+1] - nums[i];

// 			if(diff >1 ){

// 				int start=nums[i]+1;

// 				for(int j=start; j< nums[i+1]; j++){
// 					disappearList.add(j);
// 				}
// 			}

// 			// if(diff==0){
// 			// 	 if(i+1==nums.length-1){
// 			// 	 				// System.out.println("fill1");
// 			// 		disappearList.add(nums[i]+1);					
// 			// 	}
// 			// }

			
// 		}

// 		// if(nums.length>1 && nums[nums.length-1] == nums[nums.length-2]){
// 		// 	disappearList.add(nums[nums.length-1]+1);					
// 		// }

// 		return disappearList;

// 	}


///==============LONG TIME AGO===============

// import java.util.Set;
// import java.util.HashSet;
// import java.util.ArrayList;

// public class Solution{


// 	public static Set<Integer> addNumberBetween(int start, int end, Set<Integer> missing){
// 		for(int i=start+1; i < end; i++){
// 			missing.add(i);
// 		}
// 		return missing;
// 	}
// 	public static int[] findDisappearedNumbers(int[] arr){
		
// 		int max=0;
// 		int min=0;

// 		if (arr.length>0){
// 			max=arr[0];
// 			min=arr[0];
// 		}
// 		Set<Integer> missing=new HashSet<Integer>();

// 		int curr;
// 		for(int i=0; i<arr.length; i++){

// 			System.out.println("i: "+i);
// 			curr = arr[i];
// 			 missing.remove(new Integer(curr));
			
// 			if(curr<min){
				
// 				if((min-curr)>1){
// 					missing = addNumberBetween(curr, min, missing); // order matters in arguements: curr <min
// 					System.out.println("min replaced with: "+ min + ", missing: "+missing);
// 				}
// 				min = curr;
// 			}
// 			if(curr>max){
				
// 				if((curr-max)>1){
// 					missing = addNumberBetween(max, curr, missing); 
// 					System.out.println("max replaced with: "+ max + ", missing: "+missing);

// 				}
// 				max =curr;
// 			}

// 			//no need below -> cause I have put initalialized both min and max with the very first arr elemenet
// 			// if((max-min)>1){
// 			// 	missing = addNumberBetween(min, max, arr, missing);
// 			// 	System.out.println("diff max: "+ max + ", min: " + min+", missing: "+missing);
// 			// }

// 			System.out.println("curr: "+ curr + ", max: "+ max + ", min: "+min+", missing: "+missing);

// 		}
// 		return  ArrayUtils.to//missing.toArray(new Integer[missing.size()]);//new int[missing.size];

// 	}

// 	public static void main(String[] args){
// 		int[] arr =  {1,1,1, 5, 3, -1};//{4,3,2,7,8,2,3,1};

// 		Integer[] x =findDisappearedNumbers(arr);
// 		for(int i=0; i<x.length; i++){
// 			System.out.println(x.);
// 		}
// 	}
// }