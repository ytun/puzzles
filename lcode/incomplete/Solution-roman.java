import java.util.Map;
import java.util.HashMap;

public class Solution {

  // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
  // Special character exists

  static char[] letters = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

  // static Map<Integer, Character> map = new HashMap<Integer, Character>(){{
  //   put(1,'I');
  //   put(5,'V');
  //   put(10,'X');
  //   put(50,'L');
  //   put(100,'C');
  //   put(500,'D');
  //   put(1000,'M');
  // }};


 //alternate 2 and 5 multilply
// 5  = 5 
// 10 = 5*2
// 50 = 5*2*5
// 100= 5*2*5*2
// 500= 5*2*5*2*5 

// for(int i = 0; i<7; i++){
//       if(i%2 >0){
//         prev = prev * 5;
//       }
//       else{
//         prev = prev * 2;
//       }

//       System.out.println(prev);

//     }


  private static int getNumDigit(int x){

    return (int)Math.floor(Math.log10(x)) ;
  }

  // compute combination of 1, 5, 10, etc 
  // eg. 4 = -1 + 5 (if increasing, smaller one has negative)
  //     6 = 5 + 1 (always decreasing)
  public static String IntToRoman(int n){

    String s = "";
    String val = "";

    int d = (int)Math.pow(10, getNumDigit(n)) * 5 ; // 5
    int r = n; //8
    int q = 0;


    while(r > 0){ // (8 > 5)

      // n =9

      // d=5
      // 9 + 1 == 5*2
      if( d>1 && r+ d/5  == d*2 ){

      // System.out.print("n="+r+",d= "+d);

        r = d*2; //10
        q = d/5; //1
        d = d*10;


        s = s + ", " + q ;
      }
      else{
      // System.out.print("n="+n+",d= "+d);

      
       // d = d*5;
        n = r;     //8  //3  //2 //1



        r = (r<4)? (n-d) : n%d; //3  //3  //2 //1
        // System.out.println("xx r: "+r);
        q = n - r; //5  //2  //1 //0
     



      // System.out.println(",r="+r+",q="+q);

      if(q==d){
        s = s + ", " + d ;
      }

      // else{
        d = (d<5)? 1: d/5; //5  //1  //1 //1 

      // }

      }
      // System.out.println(s);


    }
      


    


    // int d = 1;

    // while(){
    //   if(i%2 >0){
    //     d = d * 5;
    //   }
    //   else{
    //     d = d * 2;
    //   }


    //   if(){
    //     s = s + ;
    //   }


    //   System.out.println(d);

    // }

    // while(){



    //   s = s + val;

    // }

    
    return s;
   
  }

  public static void main(String[] args) {

    // int[] list = new int[]{1, };
    // int n = 48;  

    for(int i=1; i<=20; i++){
      System.out.println(i+"\n"+Solution.IntToRoman(i));
    }  


  }



}


