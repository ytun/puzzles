import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution{

	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest){
		return (minutesToDie * (buckets-1))/minutesToTest;
	}

	public static void main(String[] args){
		
		System.out.println(poorPigs(1000, 15, 60));
	}

}