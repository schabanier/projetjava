package maze;

import fr.enst.inf103.ui.MazeViewController;


import fr.enst.inf103.ui.MazeViewSource;

public class MazeController 
	implements MazeViewController
{
	
	Maze maze = new Maze();
	
	public void calculateShortestPath()
	{
		/** Calcule le plus court chemin entre le départ et l'arrivee */
	}
	
	public MazeViewSource getMazeViewSource()
	{
		/** Obtient le MazeViewSource du labyrinthe */
		return (MazeViewSource)maze;
	}
	
	public MazeViewSource newMaze()
	{
		/** cree un nouveau labyrinthe */

		maze.initMaze();
		return (MazeViewSource)maze;
	}
	
	public MazeViewSource openMaze(String fileName)
	{
		/** ouvre un labyrinthe a partir de fileName */
		
		maze.initFromTextFile(fileName); 
		return (MazeViewSource)maze;	
	}
	
	public void saveMazeAs(String fileName)
	{
		/** sauvegarde le labyrinthe sous fileName */
		
		maze.saveToTextFile(fileName); 
	
	}
}
