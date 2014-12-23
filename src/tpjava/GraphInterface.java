package tpjava;

import java.util.ArrayList;

public interface GraphInterface {

	/** returns the array list of all vertices */
	
	public ArrayList<VertexInterface> getAllVertices();
	
	/** returns the array list of the successor of a vertex */
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) ;
	
	/** return the weight of an arc */
	
	public int getWeight(VertexInterface src, VertexInterface dst);
}
