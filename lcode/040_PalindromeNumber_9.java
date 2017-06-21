
public class SolutionJun {

  public int getDivider(int x){
    return (int)Math.pow(10, getNumDigit(x) -1);
  }

  public int getNumDigit(int x){
    return (int)Math.floor(Math.log10(x))+1;
  }

  public boolean isPalindrome(int ori){
    if(ori==0){
      return true;
    }
    else if(ori<0){
      return false;
    }

    int nDigits = getNumDigit(ori);
    int x1 = ori;
    int x2 = ori;

    int d1 = -1;
    int d2 = 10;

    int r1 = ori;
    int r2 = ori;
    int counter= 0;

    // System.out.println("nDigits: "+nDigits+", "+nDigits/2);


    //integer division rounds down
    while( x1 == r2 && nDigits/2!=counter){ 

      int div =getDivider(r1);

      if(x1==0 || (d1!=-1 && div*10 != d1)){
        d1 = d1/10;
        // x1 = (r1==0)? 0: (int)Math.floor(r1/d1); 
        // r1 = (r1==0)? 0: r1%d1;  
      }
      else{
        d1 = div;
        
      }

      x1 = (r1==0)? 0: (int)Math.floor(r1/d1); //this first important before r1 modified
      r1 = (r1==0)? 0: r1%d1;  

      r2 = x2%d2;
      x2 = (x2==0)? 0: (int)Math.floor(x2/d2);

      // System.out.println("x1: "+x1+", r1: "+r1 +", d1: "+d1);
      // System.out.println("r2: "+r2+", x2: "+x2);

      counter++;

    }

    return (x1==r2);

  }
  

  public static void main(String[] args){
    SolutionJun sol = new SolutionJun();

    int[] list = new int[]{1001001001,1000110001, 1000000001,-2147483648,1,12321,121,122,1231,0, 1000, 10301};
    int x=0;

    for(int i =0; i<list.length; i++){
      x= list[i];
      System.out.println("x: "+ x);
      System.out.println("answer: \n"+sol.isPalindrome(x)+"\n");
    }
    
  }

}

















