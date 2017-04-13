//009-IslandPerimeter.java
import java.util.Arrays;

public class Solution{
	public static int islandPerimeter(int[][] grid){

		int sum = 0;
		int num_touch_side = 0; //number of neighbors who are ones/lands
		//* this will be counted twice for 2 touching squares 
		//- so no need to multiply 2 to this

		for(int i=0; i<grid.length; i++){
			//System.out.println(Arrays.toString(grid[i]));
			for(int j=0; j<grid[i].length; j++){

				sum+=grid[i][j];

				//if current is land
				if (grid[i][j]==1){
					//find neighbor lands
					//* edge case - corners
					if(j>0 && grid[i][j-1]==1){
						num_touch_side++;
					}
					if(j<grid[i].length-1 && grid[i][j+1]==1){
						num_touch_side++;
					}
					if(i>0 && grid[i-1][j]==1){
						num_touch_side++;
					}
					//System.out.println(i+", "+j+": "+num_touch_side);

					//System.out.println(grid[i].length);
					if(i<grid.length-1 && grid[i+1][j]==1){
						num_touch_side++;
					}
				}
				//System.out.println(i+", "+j+": "+num_touch_side);
			}
		}
		//System.out.println("sum: "+sum);
		//System.out.println("num_touch_side: "+num_touch_side);
		return ( (4*sum) - (num_touch_side)  );

	}

	public static void main(String[] args){

		int[][] grid = {{1,0}}; //{{0,1,0,0}, {1,1,1,0}, {0,1,0,0},{1,1,0,0}};
		System.out.println(islandPerimeter(grid));


	}
}