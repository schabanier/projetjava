package maze;

public class PathException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PathException(String errorMsg)
	{
		super("Can't calculate shortest path:" + errorMsg) ;
	}

}
