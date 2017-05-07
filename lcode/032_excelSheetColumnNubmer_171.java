import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution{

	public static int titleToNumber(String s){
 
 		int base = 0;
 		int x = 0;

 		for(int i=0; i<s.length(); i++){
 			// System.out.println((int)s.charAt(s.length()-1-i));
 			// System.out.println((int)Math.pow(26,i));
 			x =  x +  ( (int)Math.pow(26,i) * ( (int)s.charAt(s.length()-1-i) - 64 ) );
 			// System.out.println(x);
 		}
 		return x;
	}


	public static void main(String[] args){

		String[] slist = {"AB", "A", "Z", "AAB"};

		for(String s: slist){
			System.out.println(s + ": "+ titleToNumber(s));
		}
	}


}


