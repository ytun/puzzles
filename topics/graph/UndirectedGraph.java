import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Iterator;

//http://www.keithschwarz.com/interesting/code/edmonds-matching/UndirectedGraph.java.html

public class UndirectedGraph<T> {

  private Map<T, Set<T>> graphMap = new HashMap<T, Set<T>>();

  public boolean addNode(T node) {
    if (graphMap.containsKey(node)) {
      return false;
    }
    graphMap.put(node, new HashSet<T>());
    return true;
  }

  public boolean nodeExists(T node) {
    return graphMap.containsKey(node);
  }

  public boolean addEdge(T start, T end) {
    if (!graphMap.containsKey(start) || !graphMap.containsKey(end)) {
      return false;
    }

    graphMap.get(start).add(end);
    graphMap.get(end).add(start);

    return true;
  }

  public boolean removeEdge(T start, T end) {
    if (!graphMap.containsKey(start) || !graphMap.containsKey(end)) {
      return false;
    }

    graphMap.get(start).remove(end); //remove only value, since it is only edge
    graphMap.get(end).remove(start); //remove only value, since it is only edge
    return true;
  }

  public boolean edgeExists(T start, T end) {
    if (!graphMap.containsKey(start) || !graphMap.containsKey(end)) {
      return false;
    }

    return graphMap.get(start).contains(end); // symmetric so no need, && graphMap.get(end).contains(start);//!neighbors.isEmpty();
  }

  public Set<T> edgesFrom(T node) {
    return Collections.unmodifiableSet(graphMap.get(node));
  }

  // public Object getOneNeighbor(T node){
  // 	Iterator it = edgesFrom(node).iterator();
  // 	return it.next(); //null if nothing in there
  // }

  public T getUnvisitedNeighbor(T node, Set<T> visited) {
    Iterator it = edgesFrom(node).iterator();
    T neighbor = null;

    while (it.hasNext()) {
      neighbor = (T)it.next();

      if (!visited.contains(neighbor)) {
        return neighbor;
      }
    }
    return null;
  }

  public Iterator<T> iterator() {
    return graphMap.keySet().iterator();
  }

  public int size() {
    return graphMap.size();
  }

  public boolean isEmpty() {
    return graphMap.isEmpty();
  }

  public String toString() {
    String g = "";

    for (Map.Entry<T, Set<T>> entry : graphMap.entrySet()) {
      g = g + entry.getKey().toString() + ": " + entry.getValue().toString() + "\n";
    }
    return g;
  }



}