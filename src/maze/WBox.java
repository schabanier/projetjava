package maze;
import java.io.PrintWriter ;

public class WBox extends MBox {

	public WBox(Maze maze,int line, int column)
	{
		super(maze,line,column);
	}
	
	@Override
	
	public final boolean isAccessible()
	{ 
		return false ;
	}
	
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('W');
	}
	
	public final String getType()
	{
		return "W";
	}
}

