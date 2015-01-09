package maze;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import fr.enst.inf103.ui.MazeView;
import fr.enst.inf103.ui.MazeViewSource;

public class Maze 
	implements GraphInterface, MazeViewSource
{

	public static final int WIDTH = 10 ;
	public static final int HEIGHT = 10 ;
	
	private final MBox[][] boxes ;
	
	public Maze()
	{ 
		boxes = new MBox[HEIGHT][WIDTH] ;
	
	/** creation d'une structure matricielle pour le labyrtinthe */
	}
	
	public void initMaze(){
		for (int i=0; i<10 ; i++){
			for (int j=0; j<10 ; j++){
				if (i==0 || i==9 || j==0 || j==9)
					boxes[i][j] = new WBox(this,i,j);
				else 
					boxes[i][j] = new EBox(this,i,j);
			}
		}
	}
	
	public final MBox getBox(int line, int column)
	{
		/** retourne une case a partir de ses coordonnees */ 
		
		return boxes[line][column] ;
	}
	
	public final ArrayList<VertexInterface> getAllVertices()
	{
		ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		
		for (int line = 0 ; line < HEIGHT ; line++) {
			MBox[] theLine = boxes[line] ;
			for (int column = 0; column < WIDTH ; column ++)
				allVertices.add(theLine[column]);
		}
		
		return allVertices ;
		
	}

	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex)
	{
		/** retourne les voisins du sommet */
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>() ;
		
		MBox box = (MBox)vertex ; //cast
		
		int line = box.getLine();
		int column = box.getColumn();
		
		if(line>0) { //top neighbor
			MBox neighbor = boxes[line-1][column] ;
			if(neighbor.isAccessible())
				successors.add(neighbor) ;
		}
		
		if (line < HEIGHT-1) { //bottom neighbor
			MBox neighbor = boxes[line+1][column];
			if(neighbor.isAccessible())
				successors.add(neighbor) ; 
		}
		
		if (column>0) { // left neighbor
			MBox neighbor = boxes[line][column-1] ;
			if (neighbor.isAccessible())
				successors.add(neighbor) ;
		}
		
		if (column < WIDTH-1) { // left neighbor
			MBox neighbor = boxes[line][column+1] ;
			if (neighbor.isAccessible())
				successors.add(neighbor) ;
		}
		
		return successors ;
	}
	
	public final int getWeight(VertexInterface src, VertexInterface dst)
	{
		return 1;
	}
	
	public final void initFromTextFile(String fileName)
	{
	    FileReader fr = null ;
	    BufferedReader br = null ;
	    
		try {
			fr = new FileReader(fileName) ;
			br = new BufferedReader (fr);
			
		for (int lineNo = 0; lineNo < HEIGHT ; lineNo++) {
			
			String line = br.readLine();
			
			if (line == null)
				throw new MazeReadingException(fileName, lineNo, "not enough lines");
			if (line.length() < WIDTH)
				throw new MazeReadingException(fileName,lineNo, "line too shrort");
			if(line.length() > WIDTH)
				throw new MazeReadingException(fileName,lineNo,"line too long") ;
			
			for(int colNo = 0 ; colNo < WIDTH; colNo++) {
				switch (line.charAt(colNo)) {
				case 'D' :
					boxes[lineNo][colNo] = new DBox(this, lineNo, colNo); break ;
				case 'A' :
					boxes[lineNo][colNo]= new ABox(this, lineNo, colNo); break ;
				case 'W' :
					boxes[lineNo][colNo] = new WBox(this,lineNo, colNo); break ;
				case 'E' :
					boxes[lineNo][colNo] = new EBox(this, lineNo, colNo); break ;
				case '*' :
					boxes[lineNo][colNo] = new PathBox(this, lineNo, colNo); break;
				default :
					throw new MazeReadingException(fileName, lineNo, "unknown char'" + boxes[lineNo][colNo] + "'") ;
				}
			}
		}
			
		}catch(MazeReadingException e) {
			System.err.println(e.getMessage()) ;
		} catch(FileNotFoundException e) {
			System.err.println("Error class Maze, initFromTextFile: file not found" + fileName) ;
		} catch (IOException e) {
			System.err.println("Error classe Maze, initFromTextFile: read error on file  " + fileName) ;
		} catch(Exception e) {
			System.err.println("Error: unknown error.");
			e.printStackTrace(System.err);
		} finally {
			if (fr != null)
				try { fr.close() ; } catch (Exception e) {} ;
			if(br != null)
				try { br.close() ; } catch (Exception e) {} ;
		}
	}
	
		public final void saveToTextFile(String fileName)
		{
			PrintWriter pw = null ;
			
			try {
				pw = new PrintWriter(fileName) ;
				
				for (int lineNo = 0; lineNo< HEIGHT ; lineNo++) {
					MBox[] line = boxes[lineNo] ;
					for (int colNo = 0 ; colNo <WIDTH ; colNo++)
						line[colNo].writeCharTo(pw);
					pw.println();
				}
				
			}catch(FileNotFoundException e) {
				System.err.println("Error class Maze, saveToTextFile: file not found " + fileName ) ;
			}catch(SecurityException e) {
				System.err.println("Error class Maze, saveToTextFile: security exception " + fileName);
			} catch(Exception e) {
				System.err.println("Error: unknown error");
				e.printStackTrace(System.err);
			} finally {
				if (pw != null)
					try { pw.close(); } catch (Exception e) {} ;
			}
		}
		
	public final int getWidth()
	{
		return WIDTH;
	}
	
	public final int getHeight()
	{
		return HEIGHT;
	}
	
	public final String getSymbolForBox( int row, int column)
	{
		/** retourne le symbole de la case: * E W A ou D */
	
		MBox box = getBox(row,column);
		return box.getType();
	}
	
	public final void setSymbolForBox( int row, int column, String symbol)
	{
		/** change le symbole de la case */
		
			if (symbol.equals("A")) 
				boxes[row][column] = new ABox(this, row , column); 
			if (symbol.equals("D")) 
				boxes[row][column] = new DBox(this, row , column); 
			if (symbol.equals("E")) 
				boxes[row][column] = new EBox(this, row , column); 
			if (symbol.equals("W")) 
				boxes[row][column] = new WBox(this, row , column);
			if (symbol.equals("*")) 
				boxes[row][column] = new PathBox(this, row , column); 	
	}
	
	
	public boolean drawMaze(Graphics g, MazeView mazeView)
	{
		/** dessine le labyrinthe, retourne false pour utiliser l'implementation par defaut */
		return false;
	}
	
	public boolean handleClick(MouseEvent e, MazeView mazeView)
	{
		/** gere les clicks sur la souris, retourne false pour utiliser l'implementation par defaut */
		return false;
	}
	
	public boolean handleKey(KeyEvent e, MazeView mazeView)
	{
		/** gere le relachement de la souris, retourne false pour utiliser l'implementation par defaut */
		return false;
	}
	
	public final MBox getDeparture() 
		throws PathException
	{
	
		/** trouve et renvoit la case de depart */
		
		MBox departure = null;
		int compteur = 0;
		for (int i = 0; i<10;i++){
			for (int j=0 ; j<10 ; j++){
			
				if (boxes[i][j].getType() == "D"){
					departure = boxes[i][j];
					compteur = compteur +1;
				}
			}
		}
		
		if (compteur==0)
			throw new PathException("you forgot the departure box!");
		if (compteur>1)
			throw new PathException("there are " + compteur + " departure boxes");
	
		return departure;
	}



	public final MBox getArrival() 
		throws PathException
	{
		
		/** trouve et renvoit la case d'arrivee */
		
		MBox arrival = null;
		int compteur = 0;
		for (int i = 0; i<10;i++){
			for (int j=0 ; j<10 ; j++){
				
				if (boxes[i][j].getType() == "A"){
					arrival = boxes[i][j];
					compteur = compteur + 1;
				}
			}
		}
		
		if (compteur==0)
			throw new PathException("you forgot the arrival box!");
		if (compteur>1) 
			throw new PathException("there are " + compteur + " arrival boxes");
		
		return arrival;
	}
	
}

