import java.util.Arrays;

public class EditDistance{



	public static int ed_helper(String X, String Y, int m, int n, int[][] table){

		if(m==-1 || n==-1){
			return 0;
		}
		else{
			if(X.charAt(m)== Y.charAt(n)){
				return ed_helper(X,Y, m-1, n-1);
			}
			else{

				// insert, remove, replace
				return 1+ Math.min( Math.min(ed_helper(X, Y, m, n-1), ed_helper(X, Y, m-1, n)), ed_helper(X, Y, m-1, n-1));
			}
		}
	}

	public static int ed(String X, String Y){
		int[][] table = new int[X.length()-1][Y.length()-1];
		return ed_helper(X, Y, X.length()-1, Y.length()-1, table);
	}

	public static void main(String[] args){
		String X = "sunday";//"geek";
		String Y = "saturday";//"gesek";
		System.out.println(ed(X, Y));
	}
}


