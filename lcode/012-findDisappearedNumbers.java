import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution{


	public static Set<Integer> addNumberBetween(int start, int end, Set<Integer> missing){
		for(int i=start+1; i < end; i++){
			missing.add(i);
		}
		return missing;
	}
	public static int[] findDisappearedNumbers(int[] arr){
		
		int max=0;
		int min=0;

		if (arr.length>0){
			max=arr[0];
			min=arr[0];
		}
		Set<Integer> missing=new HashSet<Integer>();

		int curr;
		for(int i=0; i<arr.length; i++){

			System.out.println("i: "+i);
			curr = arr[i];
			 missing.remove(new Integer(curr));
			
			if(curr<min){
				
				if((min-curr)>1){
					missing = addNumberBetween(curr, min, missing); // order matters in arguements: curr <min
					System.out.println("min replaced with: "+ min + ", missing: "+missing);
				}
				min = curr;
			}
			if(curr>max){
				
				if((curr-max)>1){
					missing = addNumberBetween(max, curr, missing); 
					System.out.println("max replaced with: "+ max + ", missing: "+missing);

				}
				max =curr;
			}

			//no need below -> cause I have put initalialized both min and max with the very first arr elemenet
			// if((max-min)>1){
			// 	missing = addNumberBetween(min, max, arr, missing);
			// 	System.out.println("diff max: "+ max + ", min: " + min+", missing: "+missing);
			// }

			System.out.println("curr: "+ curr + ", max: "+ max + ", min: "+min+", missing: "+missing);

		}
		return  ArrayUtils.to//missing.toArray(new Integer[missing.size()]);//new int[missing.size];

	}

	public static void main(String[] args){
		int[] arr =  {1,1,1, 5, 3, -1};//{4,3,2,7,8,2,3,1};

		Integer[] x =findDisappearedNumbers(arr);
		for(int i=0; i<x.length; i++){
			System.out.println(x.);
		}
	}
}