import java.util.Arrays;

public class Solution{

	// = target area
	// L >= W
	// as square as possible

	// public int prime(int i){

	// }

	public static int[] constructRectangle(int area) {
        double perfect = Math.sqrt(area);
        int[] result = new int[2];
        // if area is a perfect square 
        if(perfect==Math.floor(perfect) && !Double.isInfinite(perfect)){
        	result = new int[]{(int)perfect, (int)perfect};
        }
        else {

			int downhill = (int)perfect;
			int uphill = (int)perfect;
			int factor1 = downhill; //downhill first
			int factor2=0;

			boolean decreasing = true;

			//loop till we find factor
			while(area%factor1 > 0){

				if(!decreasing){
					downhill --;
					factor1=downhill;
					decreasing=true;
					
				}
				else{
					uphill ++;
					factor1=uphill;
					decreasing=false;
				}
			}

			factor2=area/factor1;

			if(factor1<factor2){
				result = new int[]{factor2, factor1};
			}
			else{
				result = new int[]{factor1, factor2};
			}

			
        }

        return result;
    }

	public static void main(String[] args){
		
		int area=35;
		System.out.println(Arrays.toString(constructRectangle(area)));
	}

	// 21 = 7 * 3
	// 35 = 7 * 5
	// 12 = 4* 3 , 6*2, 12* 1


	// sqrt(12) = 3.46 => round up => 4 => x/4 
	// sqrt(35) = 5.9 => round up => 6 => x % 6 > 0  => + 1 => -1 
}