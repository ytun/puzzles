public class e_BabySteps {


  public static int numberWays(int n) {
    // edge
    if (n == 1) {
      return 2;
    } else if (n == 0) {
      return 1;
    } else {
      return numberWays(n - 1) + numberWays(n - 2);
    }
  }

  public static void main(String[] args) {

    int n = 5;
    System.out.println(numberWays(n));

  }

}