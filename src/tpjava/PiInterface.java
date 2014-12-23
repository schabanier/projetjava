package tpjava;

public interface PiInterface
{

	/** Setting the result for a vertex */
	
	public void setValue(VertexInterface vertex, int value);
	
	/** returns the value for a vertex */
	
	public int getValue(VertexInterface vertex) ;
}

