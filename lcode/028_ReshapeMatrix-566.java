import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.lang.System;

public class Solution{

	//super slow
	//find more efficient way
	public static int[][] matrixReshape2(int[][] nums, int r, int c){

		int r0=nums.length;
		int c0=nums[0].length;
		int size = r0*c0;
		//check if possible
		if(size != r*c){
			return nums;
		}

		int[][] newArr = new int[r][c];
		// int index = 0; //index of each item from 0 to r*c-1
		int[] rC = new int[2];
		

		for(int ir=0; ir< r; ir++){

			for(int ic=0; ic<c; ic++){
				// System.out.println(ir + ", "+ ic);
				rC = indexToRC(ir, ic,  r, c, r0, c0);
				// System.out.println(Arrays.toString(rC));
				newArr[ir][ic] = nums[rC[0]][rC[1]];
			}
		}

		return newArr;

	}

	// one of the two fastest
	public static int[][] matrixReshape1(int[][] nums, int r, int c){

		int r0=nums.length;
		int c0=nums[0].length;
		//check if possible
		if( (r0==r && c0==c) || (r0*c0 != r*c) ){
			return nums;
		}

		int[][] newArr = new int[r][c];
		
		int ir0=0;
		int ic0=0;

		for(int ir=0; ir< r; ir++){
			for(int ic=0; ic<c; ic++){
				newArr[ir][ic] = nums[ir0][ic0];
				ic0++;

				if(ic0== c0){
					ic0=0;
					ir0++;

					// no need for this ir0 always increment correctly, won't go over ever, just incrementing is ok, only column repeats with modulus
					// if(ir0==r0){
					// 	ir0=0;
					// }
				}
			}
		}

		return newArr;

	}
	// one of the two fastest
	public static int[][] matrixReshape(int[][] nums, int r, int c){

		int r0=nums.length;
		int c0=nums[0].length;
		int size = r0*c0;

		System.out.println("r0,c0: "+r0 +"," + c0);

		//check if possible
		if(size != r*c){
			return nums;
		}
	
		int[][] newArr = new int[r][c];
		// int ir0=0;
		// int ic0=0;

		for(int i=0; i< size; i++){
			
			// System.out.println(i/c +","+ i%r);
			// System.out.println(i/c0 +","+ i%r0);
			// System.out.println();
			// i/c -> no need to round up cus c is already -1 since it starts from 0
			newArr[i/c][i%c] = nums[i/c0][i%c0];
		}

		return newArr;

	}
	public static int[] indexToRC(int ri0, int ci0, int r0, int c0, int row, int col){

		int i= (ri0 * c0) + ci0 + 1;
		// System.out.println("i: "+i);

		int remainder = ((i)%col) -1;
		// System.out.println("remainder: "+remainder);

		return new int[]{  (int)Math.ceil((double)i/col)  -1 , (remainder == -1)? col-1: remainder };
	}

	public static void print2D(int[][] arr){
		for(int[] row: arr){
			System.out.println(Arrays.toString(row));
		}
	}


	public static void main(String[] args){
		
		// int[][] nums = {{1,2,3}, {4,5,6}};
		// int r=3;
		// int c=2;
	
		int[][] nums = {{1,2,3,4}};//{{1,2}, {3,4}};
		int r=2;
		int c=2;

		
		print2D(matrixReshape(nums, r, c));

	}



// int[] rCNew = new int[2];

		// System.out.println("r0, c0: "+r0 + ", "+ c0);
		// System.out.println("r, c: "+r + ", "+ c);

		// for(int ir=0; ir<r ; ir++){
		// 	rC=indexToRC(index, r0 ,c0);
		// 	// System.arraycopy(nums[], rC[1], newArr[ir], ir*c, c);
		// 	index = ir*c;
		// }

		// for(int i =0 ; i<size; i++){
		// 	rC=indexToRC(i, r0 ,c0);
		// 	rCNew=indexToRC(i, r ,c);

		// 	System.out.println("rC: "+Arrays.toString(rC));
		// 	System.out.println("rCNew: "+Arrays.toString(rCNew));

		// 	newArr[rCNew[0]][rCNew[1]]= 
		// 	nums[rC[0]][rC[1]];
		// }


	
}



