import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class Solution{

	// for-show giant just big enough of actual min
	//but min itself can't be giant

	//6,5
	//4,3
	//2,1

	//goal : make min as big as I can, so giant must be just big enough 
	// find smallest giant
	// giant <-> min = distance between them minimized
	// adjacent numbers has minimum distance
	// sort first
	// sum the last, last -2, last -4, etc.. alternate number

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

	public static int arrayPairSum(int[] nums){
		quickSort(nums, 0, nums.length-1);
		// System.out.println(Arrays.toString(nums));

		int sum=0;
		//add alternate numbers
		for(int i=nums.length-2; i>=0; i=i-2){
			sum = sum+ nums[i];
			// System.out.println(nums[i]);
		}
		return sum;

	}

	public static void main(String[] args){
		int[] arr = {1,4,3,2};//{4,5,3,2,1,6};
		
		System.out.println(arrayPairSum(arr));

	}



	
}



