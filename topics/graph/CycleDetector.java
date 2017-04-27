import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Iterator;

public class CycleDetector{

	public static boolean detectCycle(UnDirectedGraph<String> g){

		Set<String> visited = new HashSet<String>();
		Stack<String> stack= new Stack<String>();

		String start= (String)g.iterator().next(); //start's neighbors will be explored
		String curr= "";

		if(start==null){
			return false;
		}

		stack.push(start); 
		visited.add(start);

		while(!stack.isEmpty()){
			
			//Difference from DFT is below
			Iterator<String> it=g.edgesFrom(start).iterator();
			curr=(it.hasNext())? it.next() : null;
		
			//unvisited node
			if(curr!=null && !visited.contains(curr)){
				visited.add(curr);
				stack.push(curr);
				start= curr;
			}//visited already
			else if(curr!=null && visited.contains(curr)){
				return true;
			}
			else{
				start = stack.pop();
			}
			// System.out.println("start: "+start + ", curr: "+ curr);
			// System.out.println("stack: "+stack);
			// System.out.println("visited: "+visited);
		}

		return false;
	}

	public static boolean detectCycle(DirectedGraph<String> g){

		Set<String> visited = new HashSet<String>();
		Stack<String> stack= new Stack<String>();

		String start= (String)g.iterator().next(); //start's neighbors will be explored
		String curr= "";

		if(start==null){
			return false;
		}

		stack.push(start); 
		visited.add(start);

		while(!stack.isEmpty()){
			
			//Difference from DFT is below
			Iterator<String> it=g.edgesFrom(start).iterator();
			curr=(it.hasNext())? it.next() : null;
		
			//unvisited node
			if(curr!=null && !visited.contains(curr)){
				visited.add(curr);
				stack.push(curr);
				start= curr;
			}//visited already
			else if(curr!=null && visited.contains(curr)){
				return true;
			}
			else{
				start = stack.pop();
			}

			// System.out.println("start: "+start + ", curr: "+ curr);
			// System.out.println("stack: "+stack);
			// System.out.println("visited: "+visited);
		}

		return false;
	}

	

	public static String dft(DirectedGraph<String> g){
		Set<String> visited = new HashSet<String>();
		Stack<String> stack= new Stack<String>();

		String dft = "";
		String start= (String)g.iterator().next(); //start's neighbors will be explored
		String curr= "";

		// Iterator it= g.iterator();
		if(start==null){
			return "";
		}

		// dft = dft + start;
		stack.push(start); 
		visited.add(start);
		dft = dft + start;

		while(!stack.isEmpty()){
			
			curr= (String)g.getUnvisitedNeighbor(start, visited);//g.edgesFrom(curr); //String)it.next(); 

			//unvisited node
			if(curr!=null && !visited.contains(curr)){
				visited.add(curr);
				stack.push(curr);
				dft = dft + curr;
				start= curr;
			}
			else{
				start = stack.pop();
			}

			// System.out.println("start: "+start + ", curr: "+ curr);
			// System.out.println("stack: "+stack);
			// System.out.println("visited: "+visited);
		}

		return dft;
	}

	// public static void mainDFT(){
	// 	UndirectedGraph<String> g = new UndirectedGraph<String>();

	// 	String[] vValues = {"A","B","C","D","E","F","G","H"};

	// 	for(int i=0; i<vValues.length; i++){
	// 		g.addNode(new String(vValues[i]));
	// 	}

	// 	g.addEdge("A", "B");
	// 	g.addEdge("B", "E");
	// 	g.addEdge("E", "G");
	// 	g.addEdge("G", "A");
	// 	g.addEdge("A", "D");
	// 	g.addEdge("B", "F");
	// 	g.addEdge("D", "F");
	// 	g.addEdge("F", "C");
	// 	g.addEdge("C", "H");


	// 	System.out.println(g.toString());
	// 	System.out.println(dft(g));
	// 	// System.out.println(detectCycle(g));

	// }

	public static void mainCycleDirected(){
		DirectedGraph<String> g = new DirectedGraph<String>();

		String[] vValues = {"A","B","C","D","E","F","G","H"};

		for(int i=0; i<vValues.length; i++){
			g.addNode(new String(vValues[i]));
		}

		g.addEdge("A", "B");
		g.addEdge("B", "E");
		g.addEdge("E", "G");
		g.addEdge("G", "A");
		g.addEdge("A", "D");
		g.addEdge("B", "F");
		g.addEdge("D", "F");
		g.addEdge("F", "C");
		g.addEdge("C", "H");

		System.out.println(g.toString());
		// System.out.println(dft(g));
		System.out.println(detectCycle(g));
	}

	public static void main(String[] args){

		
		mainCycleDirected();



	}
}






