package tpjava;

public class MazeReadingException extends Exception {

	public static final long serialVersionUID = 1L ;
	
	public MazeReadingException(String fileName, int lineNo, String errorMsg)
	{
		super("Error while reading Maze in" + fileName + "(" + lineNo + "(" + errorMsg) ;
	}
}
