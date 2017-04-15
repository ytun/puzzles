import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution{

	// [1, 2, 2 , 1] , [2,2] -> [2]
	// O(n^2)

	//O(n logn) -> sort, find each number in n1
	//O(n)
	public static int[] intersection(int[] n1, int[] n2){
		Set<Integer> h = new HashSet<Integer>();
		for(int i=0; i<n1.length ; i++){
			h.add(n1[i]) ;
		}

		Set<Integer> intersect = new HashSet<Integer>();
		for(int i=0; i< n2.length; i ++){
			if(h.contains(n2[i])){
				intersect.add(n2[i]);
			}
		}

		int [] result = new int[intersect.size()];
		int i =0;
		for(int n: intersect){
			result[i] = n;
			i++;
		}
		// for(int i = 0 ;i < intersect.size(); i ++){
		// 	result[i] = intersect.get(i);
		// }

		return result;

	}

	public static void main(String[] args){
		
		int[] n1 = {1, 2,2,3 };
		int[] n2 = {3,5};
		System.out.println(Arrays.toString(intersection(n1, n2)));
	}

}