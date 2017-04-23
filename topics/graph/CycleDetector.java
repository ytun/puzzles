

public class CycleDetector{


	public static boolean detectCycle(Graph g){


	}

	public static String dft(Graph g){
		Set<Vertex> visited = new HashSet<Vertex>();
		Stack<Vertex> stack= new Stack<Vertex>();

		String dft = "";

		while(!stack.isEmpty()){

			if(visited.contains(v)){

			}
		}
	}


	public static void main(String[] args){

		Graph g = new Graph();

		Vertex[] vertices = new Vertex[nVertices];
		int nVertices = 5;

		for(int i=0; i<nVertices; i++){
			v = new Vertex(String.valueOf(i));
			g.addVertex(v, true);
			vertices[i] = v;
		}

		g.addEdge(vertices[0], vertices[1]);
		g.addEdge(vertices[1], vertices[2]);
		g.addEdge(vertices[2], vertices[3]);
		g.addEdge(vertices[3], vertices[4]);
		g.addEdge(vertices[4], vertices[2]);
		g.addEdge(vertices[3], vertices[5]);

		System.out.println(detectCycle(g));

	}
}






