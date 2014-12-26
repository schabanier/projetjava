package dijkstra;


import java.util.ArrayList;

public interface PreviousInterface {

/** setting the result for a vertex */
	
	public void setValue(VertexInterface vertex, VertexInterface value);
	
	/** returns the value for a vertex or null if this value has not been set */
	
	public VertexInterface getValue(VertexInterface vertex) ;
	
	/** returns the shortest path form the root to a vertex */
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) ;
}

