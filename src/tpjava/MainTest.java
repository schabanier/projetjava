package tpjava;

import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeWindow;
import maze.Maze;
import maze.MazeController;

public class MainTest {
	
	public static void main(String[] args)
	{
		MazeViewController maze = new MazeController();
				
		MazeWindow mazeWindow = new MazeWindow("My awesome labyrinth", maze) ;
	}
	
}
