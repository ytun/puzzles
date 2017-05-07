import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class Solution {

  //Solution 1: this
  //Solution 2: use hashmap with 3 loops yes
  public static boolean isAnagram(String s, String t) {

    // first loop and second loop can't merge if we are gonna put if fail fast condition
    // cus -1 is gonna occur for sure while looping.. can't just return false


    int[] freqArr = new int[26];
    Arrays.fill(freqArr, 0);

    if (s == null || t == null) {
      System.out.println("null");
      return false;
    }

    if (s.length() != t.length()) {
      System.out.println("not same length");
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      freqArr[s.charAt(i) - 'a']++;
      //in ascii, 'c' -'a' = 99-97 = 2
    }
    for (int i = 0; i < t.length(); i++) {
      freqArr[t.charAt(i) - 'a']--;

      // System.out.println(Arrays.toString(freqArr));


      //for fail fast below is
      if (freqArr[t.charAt(i) - 'a'] < 0) {
        // System.out.println("fail fast");
        return false;
      }
    }

    // System.out.println(Arrays.toString(freqArr));

    for (int f : freqArr) {
      if (f != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String s = "ab"; //"cat";
    String t = "ba"; //"atc";
    // System.out.println('0'-'a');
    System.out.println(isAnagram(s, t));
  }


}




// freqArr[i] = freqArr[i]+1;
// freqArr[i] = freqArr[i] -1;
//wrong--> more like hashset


// Map<Character,Integer> bag = new HashMap<Character,Integer>();

// char c = '\0'; //unicode zero
// int freq =0;

// for(int i=0; i<s.length(); i++){
// 	c= s.charAt(i);
// 	freq =0;

// 	if(bag.containsKey(c)){
// 		freq = bag.get(c);
// 	}

// 	bag.put(c,++freq);
// }

// for(int i=0; i<s.length(); i++){
// 	if(bag.){

// 	}
// }

// System.out.println(Arrays.toString(bag.toArray(new Character[bag.size()])));