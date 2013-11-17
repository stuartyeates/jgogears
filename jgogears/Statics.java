package jgogears;

public class Statics {

	/** bounds checking */
	static boolean BOUNDS_CHECK = true;

	/** verbose debugging */
	static boolean GLOBAL_DEBUG = false;

	/** The default board size. */
	public static final short DEFAULT_BOARD_SIZE = 19;
	
	/** The min board size. */
	public static final short MIN_BOARD_SIZE = 3;
	
	/** The max board size. */
	public static final short MAX_BOARD_SIZE = 27;

	/** Are we sanity checking moves? */
	public final static boolean SANITY_CHECK_MOVES = true;

	/** A vertex with a black stone. */
	public static final short VERTEX_BLACK = 2;
	/** A vertex with a black stone. */
	public static final short COLOUR_BLACK = 2;

	/** A vertex without a stone (and not in KO. */
	public static final short VERTEX_EMPTY = 0;
	/** A vertex without a stone (and not in KO. */
	public static final short COLOUR_EMPTY = 0;

	/** A vertex in ko. */
	public static final short VERTEX_KO = 3;
	/** A vertex in ko. */
	public static final short COLOUR_KO = 3;

	/** The MAXIMUM value for a vertex colour. */
	public static final short VERTEX_MAX = 4;
	/** The MAXIMUM value for a vertex colour. */
	public static final short COLOUR_MAX = 4;

	/** The MINIMUM value for a vertex colour. */
	public static final short VERTEX_MIN = 0;
	/** The MINIMUM value for a vertex colour. */
	public static final short COLOUR_MIN = 0;

	/** A vertex in ko. */
	public static final short VERTEX_OFF_BOARD = 4;

	/** A vertex with a white stone. */
	public static final short VERTEX_WHITE = 1;
	/** A vertex with a white stone. */
	public static final short COLOUR_WHITE = 1;

}
