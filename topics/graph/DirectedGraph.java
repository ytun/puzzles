import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Iterator;

//http://www.keithschwarz.com/interesting/code/kosaraju/DirectedGraph.java.html

public class DirectedGraph<T> implements Iterable<T>{

	private Map<T, Set<T>> graphMap = new HashMap<T, Set<T>>();

	public boolean addNode(T node){
		if(graphMap.containsKey(node)){
			return false;
		}
		graphMap.put(node, new HashSet<T>());
		return true;
	}

	public boolean addEdge(T start, T end){

		if(!graphMap.containsKey(start) || !graphMap.containsKey(end)){
			return false;
		}

		graphMap.get(start).add(end);
		return true;
	}

	public boolean removeEdge(T start, T end){

		if(!graphMap.containsKey(start) || !graphMap.containsKey(end)){
			return false;
		}

		graphMap.get(start).remove(end); //remove only value, since it is only edge
		return true;
	}

	public boolean edgeExists(T start, T end){

		if(!graphMap.containsKey(start) || !graphMap.containsKey(end)){
			return false;
		}
		
		return graphMap.get(start).contains(end);//!neighbors.isEmpty();	
	}

	// if no node exist, return null.
	public Set<T> edgesFrom(T node){
		// return graphMap.get(node); //this is not immutable. create new set
		return Collections.unmodifiableSet(graphMap.get(node));
	}

	public T getUnvisitedRandomNode(Set<T> visited){
		Iterator it = iterator();

		T node= null;

		while(it.hasNext()){
			if(!visited.contains(node)){
				return node;
			}
		}
		return null;
	}

	// same as undirected
	public T getUnvisitedNeighbor(T node, Set<T> visited){
		Iterator it = edgesFrom(node).iterator();
		T neighbor= null;

		while(it.hasNext()){
			neighbor= (T)it.next();

			if(!visited.contains(neighbor)){
				return neighbor;
			}
		}
		return null;
	}

	public Iterator<T> iterator(){
		return graphMap.keySet().iterator();
	}

	public String toString(){
		String g = "";

		for(Map.Entry<T, Set<T>> entry: graphMap.entrySet()){
			g=g + entry.getKey().toString() + ": " + entry.getValue().toString() +"\n";
		}
		return g;
		// return graphMap.toString();

		// for(T key: map.keySet()){
		// }

		// Iterator it = graphMap.entrySet().iterator();
		// while(it.hasNext()){
		// 	Map.Entry pair = (Map.Entry)it.next();
		//  pair.getKey(), pair.getValue();
		// }
	}
}