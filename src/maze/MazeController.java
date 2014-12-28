package maze;

import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;

public class MazeController 
	implements MazeViewController
{
	public void calculateShortestPath()
	{
		/** Calcule le plus court chemin entre le dŽpart et l'arrivee */
		//utiliser dijkstra
		
	}
	
	public MazeViewSource getMazeViewSource()
	{
		/** Obtient le MazeViewSource du labyrinthe */
	}
	
	public MazeViewSource newMaze()
	{
		/** cree un nouveau labyrinthe */
		Maze maze = new Maze();
	}
	
	public MazeViewSource openMaze(String fileName)
	{
		/** ouvre un labyrinthe a partir de fileName */
		Maze maze = new Maze();
		maze.initFromTextFile(fileName); 
		
	}
	
	public void saveMazeAs(String fileName)
	{
		/** sauvegarde le labyrinthe sous fileName */
		X.saveToTextFile(fileName); // X -> le labyrinthe actuel
	}
}
