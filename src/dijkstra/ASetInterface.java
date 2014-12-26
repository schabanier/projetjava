package dijkstra;



public interface ASetInterface {

	/** to add a vertex to the set A */
	
	public void add(VertexInterface vertex);
	
	/** testing membership of a vertex */
	
	public boolean contains(VertexInterface vertex);
}
