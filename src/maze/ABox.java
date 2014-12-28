package maze;
import java.io.PrintWriter;

public class ABox extends MBox {

	public ABox(Maze maze,int line, int column)
	{
		super(maze,line,column);
	}
	
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('A');
	}
	
	public final String getType()
	{
		return "A";
	}
}
