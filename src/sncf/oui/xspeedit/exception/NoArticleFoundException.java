package sncf.oui.xspeedit.exception;

public class NoArticleFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3156746905105885640L;

	public NoArticleFoundException() {
		super("Aucun article n'a été trouvé");
	}

	
}
