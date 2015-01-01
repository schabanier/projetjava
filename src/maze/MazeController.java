package maze;

import maze.MBox;
import dijkstra.VertexInterface;

import java.util.ArrayList;
import java.util.Iterator;

import dijkstra.Dijkstra;
import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;

public class MazeController 
	implements MazeViewController
{
	
	Maze maze = new Maze();
	
	public void calculateShortestPath()
	{
		/** Calcule le plus court chemin entre le depart et l'arrivee */
		
		MBox begin = maze.getdeparture();
		MBox end = maze.getarrival();
	    ArrayList<VertexInterface> solvedList = Dijkstra.dijkstra(maze, begin).getShortestPathTo(end);
	    Iterator<VertexInterface> solvedListIterator = solvedList.iterator();
	    
	    // Retablis en type " E " les cases d'un ancien chemin lors de la demande de trace d'un nouveau chemin 
	    
	    for (int i=0; i<10;i++){
	    	for (int j=0; j<10; j++){
	    		if (maze.getBox(i, j).getType() == "*"){
	    			maze.setSymbolForBox(i, j, "E");
	    		}
	    	}
	    }
	    
	    
	    // Affiche en jaune les cases du plus court chemin 
	    
		while (solvedListIterator.hasNext()){
			VertexInterface vertex = solvedListIterator.next();
			MBox m = (MBox) vertex;
			maze.setSymbolForBox(m.getLine(), m.getColumn(), "*");	
				
			
			}
		 maze.setSymbolForBox(begin.getLine(),begin.getColumn(),"D");
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
