import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
//http://www.dreamincode.net/forums/topic/377473-graph-data-structure-tutorial/

public class GraphAll {

  public static class Graph {

    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;

    public Graph() {
      this.vertices = new HashMap<String, Vertex>();
      this.edges = new HashMap<Integer, Edge>();
    }

    public Graph(ArrayList<Vertex> vertices) {
      this.vertices = new HashMap<String, Vertex>();
      this.edges = new HashMap<Integer, Edge>();

      for (Vertex v : vertices) {
        this.vertices.put(v.getLabel(), v);
      }
    }

    public void print() {
      System.out.println(vertices);
      System.out.println(edges);
    }

    public boolean addEdge(Vertex v1, Vertex v2) {
      return addEdge(v1, v2, 1);
    }

    public boolean addEdge(Vertex v1, Vertex v2, int w) {

      // v1 can't equal to v2
      if (v1.equals(v2)) {
        return false;
      }

      Edge e = new Edge(v1, v2, w);

      // e already contains in Edges map
      if (edges.containsKey(e.hashCode())) {
        return false;
      } else if (v1.containsNeighbor(e) || v2.containsNeighbor(e)) {
        return false;
      }

      this.edges.put(e.hashCode(), e);
      v1.addNeighbor(e);
      v2.addNeighbor(e);
      return true;
    }

    public boolean containsEdge(Edge e) {
      // null handling
      if (e.getVertex1() == null || e.getVertex2() == null) {
        return false;
      }
      return (edges.containsKey(e.hashCode()));
    }

    public Edge removeEdge(Edge e) {

      e.getVertex1().removeNeighbor(e);
      e.getVertex2().removeNeighbor(e);
      return this.edges.remove(e.hashCode());
    }

    public boolean containsVertex(Vertex v) {
      return this.vertices.containsKey(v.getLabel());
    }

    public Vertex getVertex(String label) {
      return vertices.get(label);
    }

    public boolean addVertex(Vertex v, boolean overWrite) {
      Vertex curr = vertices.get(v.getLabel());

      //check if already exists
      if (curr != null) {
        //if so, overwrite. delete all neighbors

        if (!overWrite) {
          return false;
        }

        while (curr.getNeighborCount() > 0) {
          curr.removeNeighbor(0);
        }

      }
      vertices.put(v.getLabel(), v);
      return true;

    }

    public Vertex removeVertex(String label) {
      Vertex v = vertices.remove(label);

      while (v.getNeighborCount() > 0) {
        v.removeNeighbor(0);
      }

      return v;
    }

    public Set<String> getVertexKeys() {
      return this.vertices.keySet();
    }

    public Set<Edge> getEdges() {
      return new HashSet<Edge>(this.edges.values());
    }


  }

  public static class Vertex {

    private String label;
    private ArrayList<Edge> neighborhood;

    public Vertex(String label) {
      this.label = label;
      this.neighborhood = new ArrayList<Edge>();
    }

    // add an edge
    public void addNeighbor(Edge edge) {
      if (!neighborhood.contains(edge)) {
        this.neighborhood.add(edge);
      }
    }

    public boolean containsNeighbor(Edge other) {
      return this.neighborhood.contains(other);
    }

    public Edge getNeighbor(int index) {
      return this.neighborhood.get(index);
    }

    public ArrayList<Edge> getNeighbors() {
      return new ArrayList<Edge>(this.neighborhood); //return a new list- immutable
    }

    public int getNeighborCount() {
      return neighborhood.size();
    }

    public void removeNeighbor(Edge e) {
      this.neighborhood.remove(e);
    }

    public void removeNeighbor(int i) {
      this.neighborhood.remove(i);
    }

    public String getLabel() {
      return label;
    }

    public boolean equals(Vertex other) {
      if ( !(other instanceof Vertex) ) {
        return false;
      }

      return this.label.equals(other.label);
    }

    public String toString() {
      return "Vertex " + label;
    }


  }

  public static class Edge implements Comparable<Edge> {

    private Vertex v1, v2;
    private int w; //weight


    public Edge(Vertex v1, Vertex v2) {
      this(v1, v2, 1);
    }

    public Edge(Vertex v1, Vertex v2, int w) {
      this.v1 = v1;
      this.v2 = v2;
      this.w = w;
    }

    public Vertex getNeighbor(Vertex curr) {
      if (!curr.equals(v1) && !curr.equals(v2)) {
        return null;
      }
      return (curr.equals(v1)) ? v2 : v1;
    }

    public int getWeight() {
      return this.w;
    }

    public void setWeight(int wNew) {
      this.w = wNew;
    }

    public int compareTo(Edge other) {
      return (this.w - other.w);
    }

    public String toString() {
      return "{(" + v1 + "," + v2 + ")," + w + "}";
    }

    public boolean equals(Object other) {
      if ( !(other instanceof Edge) ) {
        return false;
      }

      Edge e = (Edge)other;
      return  (e.v1.equals(this.v1) && e.v2.equals(this.v2)) || (e.v1.equals(this.v2) && e.v2.equals(this.v1));
    }

    public Vertex getVertex1() {
      return v1;
    }

    public Vertex getVertex2() {
      return v2;
    }

  }

  public static void main(String[] args) {
    Graph g = new Graph();

    int nVertices = 5;

    Vertex[] vertices = new Vertex[nVertices];

    Vertex v;

    for (int i = 0; i < nVertices; i++) {
      v = new Vertex(String.valueOf(i));
      g.addVertex(v, true);
      vertices[i] = v;
    }

    for (int i = 0; i < nVertices - 1; i++) {
      g.addEdge(vertices[i], vertices[i + 1]);
    }

    g.print();

  }







}