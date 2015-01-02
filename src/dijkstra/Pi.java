package dijkstra;

import java.util.Hashtable;

public class Pi 
	implements PiInterface
{
	private final Hashtable<VertexInterface,Integer> table ;
	
	public Pi()
	{
		table = new Hashtable<VertexInterface,Integer>();
	}
	
	public void setValue(VertexInterface vertex, int value)
	{	
		table.put(vertex, new Integer(value));
	}
	
	/** Returns the value for a vortex. */
	
	public int getValue(VertexInterface vertex)
	{
		return table.get(vertex).intValue();
	}

}
