import java.util.Arrays;
import java.util.List;

//LongestIncreasingSubseq

public class LongestIncreasingSubsequence{

	// public static int[] longestSubseq(int[] arr){

	// 	int[] subseq = new int[arr.length];//arr.clone();
	// 	System.out.println(Arrays.toString(subseq));

	// 	subseq[0] = arr[0];

	// 	int si = 1;

	// 	for(int i=1; i<arr.length; i++){
	// 		// choose only number after + slope
	// 		if(arr[i] > subseq[si-1]){
	// 			subseq[i] = arr[i]; //Integer.MAX_VALUE;
	// 		}
	// 	}
	// 	return subseq;
	// }

	

	// public static int findMax(int[] lisList, int start, int end){
	// 	int max=lisList[start];

	// 	for(int i =start+1; i <=end; i++){
	// 		if(max > lisList[i]){
	// 			
	// 		}
	// 	}
	// }

	//subsequence including item i
	public static int l(int[] arr, int i, int[] lisList){
		if(i==0){
			lisList[i] = 1;
			return 1;
		}

		int maxIncreasingLength = 0;
		// go backward because the max is more likely to exist closer to i
		 for(int j=i-1 ; j>=0 ; j--){

		// 	lisList[j] = l();

		 	int lj=0;

		 	if(lisList[j]== 0){
		 		lj = l(arr, j, lisList);
		 	}
		 	else{
		 		lj = lisList[j];
		 	}

			if(arr[i] > arr[j] &&  lj > maxIncreasingLength){ //yes found increasing
				
				maxIncreasingLength=lisList[j];

				// return lisLis[i];
			}
			// else iterate

		 }

		lisList[i] = 1 + maxIncreasingLength;
		// maxIncreasingLength will be 0 if no such j exists such that arr[i] > arr[j]
		// lisLis[i] = 1;

		System.out.println("lisList: ");
		System.out.println(Arrays.toString(lisList));
		return lisList[i];

	}

	public static int lis(int[] arr){

		int[] lisList = new int[arr.length];

		int ii = l(arr, arr.length-1, lisList);
		System.out.println("last length: "+ii);

		// find maximum
		if(arr.length>0){
			int max = arr[0];

			for(int k =1 ; k < arr.length ; k ++){
				if(max < lisList[k]){
		 			max = lisList[k];
		 		}
			}
			return max;
		}
		
		return -1;
	}

	public static void main(String[] args){

		int[] arr = new int[]{10,22,9,33,21,50,41,60,80};  //{3,10,2,1,20};

		System.out.println(Arrays.toString(arr));
		System.out.println(lis(arr));

	}

}