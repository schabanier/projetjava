package dijkstra;

import java.util.Hashtable;
import java.util.ArrayList;


public class Previous 
	implements PreviousInterface
{
	
	private final Hashtable<VertexInterface , VertexInterface> table ;
	
	public Previous()
	{
		table = new Hashtable<VertexInterface,VertexInterface>();
	}
	
	public void setValue(VertexInterface vertex, VertexInterface value) 
	{
		table.put(vertex,value);
	}
	
	public VertexInterface getValue(VertexInterface vertex)
	{
		return table.get(vertex);
	}
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) 
	{
		ArrayList<VertexInterface> result = new ArrayList<VertexInterface>();
		
		while (vertex != null)
		{
			result.add(vertex);
			vertex = getValue(vertex);
		}
		
		return result ;
	}

}
