
public class GraphMain(){


	public class Graph{

		private HashMap<String, Vertex> vertices;
		private HashMap<Integer, Edge> edges;

		public Graph(){
			this.vertices = new HashMap<String, Vertex>();
			this.edges = new HashMap<Integer, Edge>();
		}

		public Graph(ArrayList<Vertex> vertices){
			this.vertices = new HashMap<String, Vertex>();
			this.edges = new HashMap<Integer, Edge>();

			for(Vertex v: vertices){
				this.vertices.put(v.getLabel(), v);
			}
		}

		public boolean addEdge(Vertex v1, Vertex v2){
			return addEdge(v1, v2, 1);
		}

		public boolean addEdge(Vertex v1, Vertex v2, int w){

			// v1 can't equal to v2
			if(v1.equals(v2)){
				return false;
			}	

			Edge e = new Edge(v1, v2, w);

			// e already contains in Edges map
			if(e.containsKey(e.hashCode())){
				return false;
			}
			else if(v1.containsNeighbor(e) || v2.containsNeighbor(e)){
				return false;
			}

			this.edges.put(e.hashCode(), e);
			v1.addNeighbor(e);
			v2.addNeighbor(e);
			return true;
		}

		public boolean containsEdge(Edge e){
			if(e.get){

			}
		}

		public Vertex getVertex(String label){
			return vertices.get(label);
		}

		public boolean addVertex(Vertex v, boolean overWrite){
			Vertex curr = vertices.get(v.getLabel());

		}

	}

	public class Vertex{

		private String label;
		private ArrayList<Edge> neighborhood;

		public Vertex(String label){
			this.label = label;
			this.neighborhood = new ArrayList<Edge>();
		}

		// add an edge
		public void addNeighbor(Edge edge){
			if(!neighborhood.contains(edge)){
				this.neighborhood.add(edge);
			}
		}

		public void removeNeighbor(Edge e){
			this.neighborhood.remove(e);
		}

		public String getLabel(){
			return label;
		}

		public boolean equals(Vertex other){
			if( !(other instanceof Vertex) ){
				return false;
			}

			return this.label.equals((Vertex)other.label);
		}

		public String toString(){
			return label;
		}
	}

	public class Edge implements Comparable<Edge>{

		private Vertex one, two;
		private int w; //weight


		public Edge(Vertex v1, Vertex v2){
			this(v1, v2, 1);
		}

		public Edge(Vertex v1, Vertex v2, int w){
			this.one = one;
			this.two = two;
			this.w = w;
		}

		public Vertex getNeighbor(Vertex curr){
			if(!curr.equals(v1) && !curr.equals(v2)){
				return null;
			}
			return (curr.equals(v1))? v2: v1;
		}

		public int getWeight(){
			return this.w;
		}

		public int setWeight(int wNew){
			this.w = wNew;
		}

		public int compareTo(Edge other){
			return (this.w - other.w);
		}

		public String toString(){
			return "{(" + v1 + "," + v2 + ")," + w + "}";
		}

		public boolean equals(Object other){
			if( !(other instanceof Edge) ){
				return false;
			}

			Edge e = (Edge)other;
			return  (e.v1.equals(this.v1) && e.v2.equals(this.v2)) || (e.v1.equals(this.v2) && e.v2.equals(this.v1));
		}

	}

	public static void main(String[] args){
		Graph g = new Graph();
	}

}