package maze;

import java.io.PrintWriter;

	public class PathBox extends MBox{
		
		public PathBox(Maze maze,int line, int column){
			
			super(maze, line, column);
			;
		}

		public final void writeCharTo(PrintWriter pw)
		{
			pw.print('*');
		}
		
		public final String getType()
		{
			return "*";
		}
	}
