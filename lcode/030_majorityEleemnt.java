import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution{


//quick sort big O: space- log(n), O(n log (n)) best and average, O(n^2) worst
	public static int majorityElement_mysoln(int[] nums){
		int thresh = (int)Math.floor((double)nums.length/2);
		System.out.println("threshold: "+ thresh);

		quickSort(nums, 0, nums.length-1);

		int f = 0;

		for(int i=0; i<nums.length; i++){

			f++;

			if(f> thresh){
				return nums[i];
			}

			if(i<nums.length-1 && nums[i+1]!=nums[i]){
				f=0;
			}
		}
		return -1; //not exist
	}

// O(n) time space O(1)
	public static int majorityElement_moreefficient(int[] nums){

		//this algorithm took some time for figure out how it works
		// key: when count=0, major element is found.
		// when is count =0? it is when even number of each elements have been seen so far, so 
		// once we find next one we add element
		// problem: what if 1,2,1,2,3  -> count=0 at second 2, so major = 3 mistakenly
		// but this shouldn't be the problem as the problem assumes that there is always one answer only
		// here it is 2 answers: 1, 2.
		//also this algorithm need to check if the count itself is the floor n/2, but this algo
		//assumes answer always exists which is true, so finding highest is also enough. 		

		int bestElem= nums[0];
		int count=1; 

		for(int i=1; i<nums.length; i++){
			if(count ==0){ //current element could be answer/best guess
				// System.out.println("i: "+i);
				bestElem = nums[i];
				count++;
			}
			else if(bestElem== nums[i]){ //nums[i-1]==nums[i]){
				count++;
			}
			else  if(bestElem!=nums[i]){
				count--;
			}
		}

		return bestElem;


	}


	public static int findMostFrequentElement(int[] nums){
		int thresh = (int)Math.floor((double)nums.length/2);
		// HashTable<int, int> table = new HashTable<int, int>();

		System.out.println("threshold: "+ thresh);

		quickSort(nums, 0, nums.length-1);

		int oldF = 0 ;
		int f=0;
		int bestElem = 0; //correspond to highest f
		for(int i=0; i<nums.length; i++){
			
			// if(i==0 || (i>0 && nums[i-1]==nums[i]) ){
				
			// }
			 if(i>0 && nums[i-1]!=nums[i]){
				if( f > oldF){ 
					oldF=f;
					bestElem=nums[i-1]; //** not nums[i]

					System.out.println("	new: ");
				} //else oldF= oldF
				f = 0;

			}

			f++;

			System.out.println("i: " + nums[i] + ", f: "+f +", oldF: "+oldF+ ", bestElem: "+bestElem);
		}

		return bestElem;
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
		
		int[] nums = {8,8,7,7,7};//{0,1,1,1,1,2,2};
		System.out.println(majorityElement_moreefficient(nums));

	}


}


