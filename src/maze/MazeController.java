package maze;

import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeView;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.enst.inf103.ui.MazeViewSource;

public class MazeController 
	implements MazeViewController
{
	
	
	public void calculateShortestPath()
	{
		/** Calcule le plus court chemin entre le d�part et l'arrivee */
		//utiliser dijkstra
		
	}
	
	public MazeViewSource getMazeViewSource()
	{
		/** Obtient le MazeViewSource du labyrinthe */
		MazeViewSource maze = new Maze (); // appeler le laby actuel 
		MazeView mazeView = new MazeView(maze) ;
		
		return mazeView.getMazeViewSource() ;
		
	}
	
	public MazeViewSource newMaze()
	{
		/** cree un nouveau labyrinthe */
		MazeViewSource maze = new Maze();
		MazeView mazeView = new MazeView(maze);
		
		//BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
		//Graphics g = image.getGraphics();
		
		maze.drawMaze(null, mazeView);
		
		return mazeView.getMazeViewSource();
	}
	
	public MazeViewSource openMaze(String fileName)
	{
		/** ouvre un labyrinthe a partir de fileName */
		
		Maze maze = new Maze();
		maze.initFromTextFile(fileName); 
		//definir g
		MazeView mazeView = new MazeView(maze);
		maze.drawMaze(null, mazeView);
		return maze;
		
		
		
	}
	
	public void saveMazeAs(String fileName)
	{
		/** sauvegarde le labyrinthe sous fileName */
		
		//maze.saveToTextFile(fileName); // X -> le labyrinthe actuel
	
	}
}
