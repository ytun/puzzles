import java.util.Map;
import java.util.HashMap;

public class Solution1 {

  //assuming no kind of repeating letter like missisipi
  // public int strStr(String haystack, String needle){

  //   int ih = 0;
  //   int in=0;
  //   int index = -1;

  //   ArrayList<Integer> indexList  = new ArrayList<Integer>();
  //   // int ii =0;

  //   if(needle.length()==0 ){
  //     return 0;
  //   }

  //   // buffer still is not hit yet
  //   //(in< needle.length()) && 
  //   //&& 
  //   for(int ii=0 ; ii<indexList.length(); ii++){

      
  //     while( ih < haystack.length() && in < needle.length() && index > 0){

  //       // System.out.println(haystack.charAt(ih) +", "+ih );

  //       if(haystack.charAt(ih) == needle.charAt(in)) {
  //         if(in==0){
  //           index = ih;
  //           indexList.add(ih);
  //         }
  //         in++;
  //       }
  //       else{
  //         index = -1;
  //         in = 0;
  //       }

  //       if(indexList.){
  //         ih = indexList.get(ii);
  //       }
  //       else{
  //         ih++;
  //       }
        
  //       // System.out.println( "index "+index );

  //     }

  //   }
  //   return index;
    
  // }



//assuming no kind of repeating letter like missisipi
  public int strStr(String haystack, String needle){

    int ih = 0;
    int in=0;
    int index = -1;

    // ArrayList<Integer> indexList  = new ArrayList<Integer>();
    // int ii =0;

    if(needle.length()==0 ){
      return 0;
    }

    // buffer still is not hit yet
    //(in< needle.length()) && 
    //&& 
    while( (ih < haystack.length() && in < needle.length() && index > 0) || (ih <= haystack.length() - needle.length() && index < 0) ){

      // System.out.println(haystack.charAt(ih) +", "+ih );

      if(haystack.charAt(ih) == needle.charAt(in)) {
        if(in==0){
          index = ih;
          // indexList.add(ih);
        }
        in++;
      }
      else{
        index = -1;
        in = 0;
      }

      ih++;
      // System.out.println( "index "+index );

    }

    return index;
    
  }

  public int strStr_short(String haystack, String needle){
    return haystack.indexOf(needle);
  }

  public static void main(String[] args){
//     "mississippi"
// "issip"
    String[] haystacklist = {"0abc0", "0123", "", "mississippi"};
    String needle = "issip";//"";//"abc"; //""

    for(int i=0; i<haystacklist.length; i++){
      String haystack = haystacklist[i];
      System.out.println(haystack+": "+new Solution1().strStr(haystack, needle));
    }
  }


}


