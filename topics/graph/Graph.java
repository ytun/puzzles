import java.util.Set;
import java.util.Iterator;

public interface Graph<T> {

  public boolean addNode(T node);

  public boolean addEdge(T start, T end);

  public boolean removeEdge(T start, T end);

  public boolean edgeExists(T start, T end);

  public Set<T> edgesFrom(T node);

  public Iterator<T> iterator();

  public T getUnvisitedNeighbor(T node, Set<T> visited);

}