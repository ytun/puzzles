import java.util.Arrays;

public class Solution {


  public static int findContentChildren(int[] g, int[] s) {

    int numChild = 0;
    int i = 0;


    Arrays.sort(g);
    Arrays.sort(s);

    System.out.println(Arrays.toString(g));
    System.out.println(Arrays.toString(s));
    //assuming sorted


    int si = 0;
    int gi = 0;

    //as long as cookie is enough, consider giving to rest of children
    while (si < s.length && gi < g.length ) {

      //right cookie! this kid gotta eat
      if (s[si] >= g[gi]) {
        numChild++;
        //si++; //next cookie cus this cookie is gone
        gi++; //next kid
      }
      //next bigger cookie, cus this cookie is useless
      // else if(s[si]<g[gi]){
      //this kid but next cookie
      // }
      si++;
    }
    return numChild;

  }

  public static void main(String[] args) {
    // [7,8,9,10]
    // [5,6,7,8]
    int[] g = {2, 3, 4, 5, 6}; //{10,9,8,7};
    int[] s = {5, 6, 7, 8};
    System.out.println(findContentChildren(g, s));

  }
}