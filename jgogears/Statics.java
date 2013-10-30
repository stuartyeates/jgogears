/**
 * 
 */
package jgogears;

/**
 * @author syeates@gmail.com
 *
 */
public final class Statics {

	/** The default board size. */
	public static final short DEFAULT_BOARD_SIZE = 19;
	
	/** The MAXIMUM value for a vertex colour. */
	public static final short VERTEX_MAX = 4;
	/** A vertex in ko. */
	public static final short VERTEX_OFF_BOARD = 4;
	/** A vertex in ko. */
	public static final short VERTEX_KO = 3;
	/** A vertex with a black stone. */
	public static final short VERTEX_BLACK = 2;
	/** A vertex with a white stone. */
	public static final short VERTEX_WHITE = 1;
	/** A vertex without a stone (and not in KO. */
	public static final short VERTEX_EMPTY = 0;
	/** The MINIMUM value for a vertex colour. */
	public static final short VERTEX_MIN = 0;
	
	/** The Constant DEFAULT_ZOBRIST. */
	public final static boolean DEFAULT_ZOBRIST = true;
	
	/** Are we sanity checking moves? */
	public final static boolean SANITY_CHECK_MOVES = true;

	/**
	 * Colour string.
	 * 
	 * @param colour
	 *            the colour
	 * @return the colour as a string
	 */
	public static String colourString(int colour) {
		// find the colour of the move
		String colourS = "";
		switch (colour) {
		case Statics.VERTEX_WHITE:
			colourS = "white";
			break;
		case Statics.VERTEX_BLACK:
			colourS = "black";
			break;
		case Statics.VERTEX_KO:
			colourS = "ko";
			break;
		case Statics.VERTEX_EMPTY:
			colourS = "empty";
			break;
		case Statics.VERTEX_OFF_BOARD:
			colourS = "off board";
			break;
		default:
			throw new java.lang.InternalError();
		}
		return colourS;
	}

	/**
	 * parse the colour of a move.
	 * 
	 * @param colourString
	 *            the colour string
	 * @return the colour as a short
	 */
	public static short parseColour(String colourString) {
	
		if (colourString.compareTo("w") == 0) {
			return Statics.VERTEX_WHITE;
		} else if (colourString.compareTo("white") == 0) {
			return Statics.VERTEX_WHITE;
		} else if (colourString.compareTo("b") == 0) {
			return Statics.VERTEX_BLACK;
		} else if (colourString.compareTo("black") == 0) {
			return Statics.VERTEX_BLACK;
		} else {
			throw new IllegalArgumentException("trying to parse (1) \""
					+ colourString + "\" as a colour");
		}
	}

	
}
