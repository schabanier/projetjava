package tpjava;

import java.io.PrintWriter;

public abstract class MBox implements VertexInterface {

	private final int line ;
	private final int column ;
	private final Maze maze;
	
	/** necessité d'un attribut qui sera une ref sur le lab pour demander à une case quels sont ses voisins */
	
	public abstract void writeCharTo(PrintWriter pw) ;
	public MBox(Maze maze,int line, int column)
	{
		this.line = line ;
		this.column = column ;
		this.maze = maze ;
	}
	
	public final String getLabel()
	{
	    return "(" + line + "," + column +")" ;
	}
	
	public final int getLine()
	{
		return line ;
		
	}
	
	public final int getColumn()
	{
		return column ;
	}
	
	public boolean isAccessible()
	{
		return true ;
	}
	
}
