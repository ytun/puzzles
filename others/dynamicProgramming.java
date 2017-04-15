import java.util.Arrays;


public class Solution{



	// public static int sum(int n, int sum){
	// 	if(n==1){
	// 		return 1; 
	// 	}
	// 	else if (n==0){
	// 		return 1;
	// 	}
	// 	else if (n==2){
	// 		return 2;
	// 	}
	// 	else{
	// 		sum  = ;
	// 		return numberWays(n-1) + sum;
	// 	}
	// }

	// public static int mixie(int n, int sumPrev){
	// 	// edge
	// 	if(n ==1){
	// 		return 1;
	// 	}
	// 	else if(n==0){
	// 		return 1;
	// 	}
	// 	else if (n==2){
	// 		return numberWays(1, sumPrev) + numberWays(0, sumPrev);
	// 	}
	// 	else{
	// 		// f(3)
	// 		// sum = 0 + f(1) = 1
	// 		// sumPrev = sumPrev + numberWays(n-2, sumPrev);
	// 		//return f(2) + f(1)= 2 + 1
	// 		int sum = 0 ; 

	// 		for(int i = 0 ; i < n ; i++){
	// 			sum = sum+numberWays(i);
	// 		}

	// 		return sum;
	// 		// return (numberWays(n-1, sumPrev)+ sumPrev);
	// 	}
	// }


//WRONG!!!!!!
	public static int[] numberWays(int[] cumulativeWays, int n, int i){
		// edge
		if(i ==1){
			System.out.println(cumulativeWays.length);
			cumulativeWays[0] = 1;
			cumulativeWays[1] = 1;
			return cumulativeWays;
		}
		else if(i==0){
			cumulativeWays[0] = 1;
			return cumulativeWays;
		}
		else if(i==n){ //n
			return cumulativeWays;
		}
		else{		
			System.out.println(Arrays.toString(numberWays(cumulativeWays, n, i-1)));
			System.out.println(Arrays.toString(numberWays(cumulativeWays, n,i-2)));

			cumulativeWays[i] = numberWays(cumulativeWays, n, i-1)[i-1] + numberWays(cumulativeWays, n,i-2)[i-2];
			System.out.println(Arrays.toString(cumulativeWays));

			// cumulativeWays[i] = cumulativeWays[i-1] + cumulativeWays[i-2];
			return  numberWays(cumulativeWays, n,i+1);
		}
	}

	// public static int cumulativeSum(int i){//} int sum){
	// 	if(i==0){
	// 		return 0;
	// 	}
	// 	else{

	// 		// sum = i + cumulativeSum(i-1);//, sum);
	// 		return i + cumulativeSum(i-1);//cumulativeSum(i-1, sum);
	// 	}
	// }

	public static int[] cumulativeSumArray(int[] arr, int i){
		if (i ==arr.length){
			return arr;
		}
		else{
			if(i>0){
				arr[i] = arr[i] + arr[i-1];
			}//else do nothing
			return cumulativeSumArray(arr, i+1);
		}
	}

	public static void main(String[] args){

		// int sumPrev = 0;

		// int[] arr={1,2,3,4,5};
		// int i = 0;
		// System.out.println(Arrays.toString(cumulativeSumArray(arr, i)));
		

		//-------

		// int n = 1;
		// int j=2;
		// int[] cumArr = new int[n];

		for (int n =0 ; n<=5; n++){
			int j=0;
			int[] cumArr = new int[n+1];
			System.out.println(Arrays.toString(numberWays(cumArr, n,j )));
		}
	}

}
