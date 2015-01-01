package tpjava;


import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeWindow;
import maze.MazeController;

public class MainTest {
	
	public static void main(String[] args)
	{
		MazeViewController mymaze = new MazeController();
		mymaze.newMaze();		
		MazeWindow mazeWindow = new MazeWindow("My awesome labyrinth", mymaze) ;
	}
	
}
