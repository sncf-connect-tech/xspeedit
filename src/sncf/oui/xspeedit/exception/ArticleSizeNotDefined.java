package sncf.oui.xspeedit.exception;

public class ArticleSizeNotDefined extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5672218623498992574L;

	public ArticleSizeNotDefined() {
		super("Un article de taille 0 a été trouvé");
	}

	
}
