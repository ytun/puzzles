import java.util.Arrays;

public class Dynamic{

	public static int fib_tab(int n, int[] lookup){

		lookup[0]=1;
		lookup[1]=1;

		for(int i=2; i<=n ; i++){
			lookup[i] = lookup[i-1]+lookup[i-2]; 
		}

		return lookup[n];
	}

	public static int fib_mem(int n, int[] lookup){

		if( n==0 || n==1){
			lookup[n] = 1;
			return 1;
		}
		else{	
			// int a = n-1;
			// int b = n-2;

			// if(lookup[a]!=0){
			// 	a = lookup[b];
			// }
			// else{
			// 	a = fib(a, lookup);
			// }

			// if(lookup[b]!=0){
			// 	b = lookup[b];
			// }
			// else{
			// 	b= fib(b, lookup);
			// }

			if(lookup[n] ==0){
				lookup[n] = fib_mem(n-1, lookup) + fib_mem(n-2, lookup);
			}

			return lookup[n];
		}

	}

	public static void main(String[] args){
		int n = 5;
		int[] lookup = new int[n+1];
		fib_mem(n, lookup);
		System.out.println(Arrays.toString(lookup));

		lookup = new int[n+1];
		fib_tab(n, lookup);
		System.out.println(Arrays.toString(lookup));



	}

}