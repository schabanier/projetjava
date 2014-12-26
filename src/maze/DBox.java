package maze;


import java.io.PrintWriter;

public class DBox extends MBox {

	public DBox(Maze maze,int line, int column)
	{
		super(maze,line,column);
	}
	
	public final void writeCharTo(PrintWriter pw)
	{
		pw.print('D');
	}
}
