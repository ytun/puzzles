import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution{

	// if not contains in the set, returns

	public static int firstUniqChar(String s){
		
		Set<Character> repeat = new HashSet<Character>();
		Set<Character> unique = new HashSet<Character>();

		char c= '\0';

		for(int i=0; i < s.length(); i++){
			// System.out.println("bf: unique: "+Arrays.toString(unique.toArray()));
			// System.out.println("bf: repeated"+Arrays.toString(repeat.toArray()));

			c =s.charAt(i);
			// not anymore unique
			if(unique.contains(c)){
				repeat.add(c);
				unique.remove(c);
			}
			else if(repeat.contains(c)){ //repeated, but not in unique 

			}
			else{
				unique.add(c);
			}


			// // only unique ones here
			// if(!repeat.contains(s.charAt(i))){
			// 	unique.add(s.charAt(i));
			// }
			// else{
			// 	unique.remove(s.charAt(i));
			// }
			// System.out.println("af: unique: "+Arrays.toString(unique.toArray()));
			// System.out.println("af: repeated"+Arrays.toString(repeat.toArray())+"\n");

		}

		// System.out.println("========");

		for(int i=0; i<s.length(); i++){ //char c: s.toCharArray
			// System.out.println("af: unique: "+Arrays.toString(unique.toArray()) + s.charAt(i));
			if(unique.contains(s.charAt(i))){
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args){
		
		String s="adddaadd"; //"adddaadd"
		System.out.println(firstUniqChar(s));
	}

}