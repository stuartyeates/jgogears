package jgogears;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * GoBoard represents the state of a Go board at a particular point in time. It
 * does NOT represent the number of prisoners, the number (or order) of previous
 * moves or whose turn it is too play.
 * 
 * @author syeates@gmail.com
 */
public class Board {

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
		case Board.VERTEX_WHITE:
			colourS = "white";
			break;
		case Board.VERTEX_BLACK:
			colourS = "black";
			break;
		case Board.VERTEX_KO:
			colourS = "ko";
			break;
		case Board.VERTEX_EMPTY:
			colourS = "empty";
			break;
		case Board.VERTEX_OFF_BOARD:
			colourS = "off board";
			break;
		default:
			throw new java.lang.InternalError();
		}
		return colourS;
	}

	/**
	 * create an empty board of the default class
	 * 
	 * @return the new empty board
	 */
	public static Board newBoard() {
		return new Board(DEFAULT_BOARD_SIZE);
	}

	/**
	 * create an empty board of the default class
	 * 
	 * @param zobrist
	 *            are we using a zobrist hash?
	 * @return the new empty board
	 */
	public static Board newBoard(boolean zobrist) {
		return new Board(zobrist);
	}

	/**
	 * create an empty board of the default class
	 * 
	 * @param size
	 *            the size of the board
	 * @return the new empty board
	 */
	public static Board newBoard(int size) {
		return new Board((short) size);
	}

	/**
	 * create an empty board of the default class
	 * 
	 * @param size
	 *            the size of the board
	 * @param rule
	 *            the ruleset to use
	 * @return the new empty board
	 */
	public static Board newBoard(int size, RuleSet rule) {
		return new Board((short) size, rule);
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
			return Board.VERTEX_WHITE;
		} else if (colourString.compareTo("white") == 0) {
			return Board.VERTEX_WHITE;
		} else if (colourString.compareTo("b") == 0) {
			return Board.VERTEX_BLACK;
		} else if (colourString.compareTo("black") == 0) {
			return Board.VERTEX_BLACK;
		} else {
			throw new IllegalArgumentException("trying to parse (1) \""
					+ colourString + "\" as a colour");
		}
	}

	/** The actual board, of size size. */
	private short[][] board = null;

	/** the ruleset. */
	protected RuleSet ruleSet = new NoKoRuleSet();

	/** the size of the board. */
	protected short size = 19;

	/** The zobrist. */
	protected Zobrist zobrist = null;

	/**
	 * Default constructor.
	 */
	public Board() {
		this.zobrist = new Zobrist();

		this.init();
	}


	/**
	 * create a new board based on the current board plus a move.
	 * 
	 * @param board
	 *            the move
	 * @param move
	 *            the move
	 */
	public Board(Board board, Move move) {
		this.size = board.getSize();
		this.init();
		this.copydata(board, move);
	}

	/**
	 * Default constructor.
	 * 
	 * @param zobrist
	 *            the zobrist
	 */
	public Board(boolean zobrist) {
		if (zobrist)
			this.zobrist = new Zobrist();
		this.init();
	}


	/**
	 * constructor of specially sized boards.
	 * 
	 * @param size
	 *            the size
	 */
	public Board(int size) {
		this.size = (short) size;
		this.init();
	}


	/**
	 * constructor of specially sized boards.
	 * 
	 * @param size
	 *            the size
	 * @param rule
	 *            the rule
	 */
	public Board(int size, RuleSet rule) {
		this.size = (short) size;
		this.ruleSet = rule;
		this.init();
	}


	/**
	 * Default constructor.
	 * 
	 * @param rule
	 *            the rule
	 */
	public Board(RuleSet rule) {
		this.ruleSet = rule;
		this.init();
	}

	/**
	 * Instantiates a new board.
	 * 
	 * @param size
	 *            the size
	 */
	public Board(short size) {
		this.size = size;
		this.init();
	}

	/**
	 * constructor of specially sized boards.
	 * 
	 * @param size
	 *            the size
	 * @param rule
	 *            the rule
	 */
	public Board(short size, RuleSet rule) {
		this.size = size;
		this.ruleSet = rule;
		this.init();
	}

	/**
	 * create a new board based on the current board plus a move.
	 * 
	 * @param move
	 *            the move
	 * @param old
	 *            the old board we're coping data from
	 */
	protected void copydata(Board old, Move move) {
		this.size = old.getSize();
		if (this.size < 3 || this.size > 25)
			throw new Error();

		this.zobrist = old.getZobrist();
		this.ruleSet = old.getRuleSet();

		for (short i = 0; i < this.size; i++)
			for (short j = 0; j < this.size; j++) {
				short colour = old.getColour(i, j);
				if (colour == VERTEX_KO)
					this.setColour(i, j, VERTEX_EMPTY);
				else
					this.setColour(i, j, colour);
			}
		if (move == null)
			return;
		if (move.getResign()) {
			return;
		} else if (move.getPass()) {
			// do nothing, since GoBoard doesn't know whose turn it is
		} else {
			// check the sanity of moves
			if (SANITY_CHECK_MOVES) {
				short oldColour = old
						.getColour(move.getRow(), move.getColumn());
				switch (oldColour) {
				case VERTEX_KO:
				case VERTEX_EMPTY:
					break;
				case VERTEX_WHITE:
				case VERTEX_BLACK:
					if (move.getColour() == VERTEX_KO
							|| move.getColour() == VERTEX_EMPTY) {
						break;
					} else {
						throw new Error(move + "\n " + old);
					}
				case VERTEX_OFF_BOARD:
					if (move.getColour() != VERTEX_OFF_BOARD) {
						throw new Error(move + "");
					} else {
						break;
					}
				default:
				}
			}
			// place the stone
			if (move.getColumn() >= this.size || move.getRow() >= this.size)
				throw new Error(move + "");
			this.setColour(move.getRow(), move.getColumn(), move.getColour());
			if (this.zobrist != null)
				this.setZobrist(new Zobrist(this.zobrist, move.getRow(), move
						.getColumn(), Board.VERTEX_EMPTY));

			// take the captures
			TreeSet<Vertex> captures = old.getRuleSet().captures(null, old,
					move);
			if (captures.size() > 0) {
				// System.err.println("captured" + captures);
				Iterator<Vertex> i = captures.iterator();
				while (i.hasNext()) {
					Vertex v = i.next();
					// System.err.println("captured" + v);
					this.setColour(v.getRow(), v.getColumn(),
							Board.VERTEX_EMPTY);

					if (this.zobrist != null)
						this.setZobrist(new Zobrist(this.getZobrist(), v
								.getRow(), v.getColumn(), Board.VERTEX_EMPTY));
				}
			}
			// mark the kos
			TreeSet<Vertex> kos = old.getRuleSet().leavesKo(null, old, move);
			if (kos.size() > 0) {
				// System.err.println("captured" + captures);
				Iterator<Vertex> i = kos.iterator();
				while (i.hasNext()) {
					Vertex v = i.next();
					// System.err.println("captured" + v);
					this.setColour(v.getRow(), v.getColumn(), Board.VERTEX_KO);

				}
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		Board other = null;
		try {
			other = (Board) obj;
		} catch (Throwable t) {
			return super.equals(obj);
		}
		if (other == null)
			return false;
		if (this.size != other.size)
			return false;
		if (this.getZobrist() != null && other.getZobrist() != null)
			return this.getZobrist().equals(other.getZobrist());
		for (int i = 0; i < this.size; i++)
			for (int j = 0; j < this.size; j++)
				if (this.getColour(i, j) != other.getColour(i, j))
					return false;
		return true;
	}

	/**
	 * Get a collection of all the legal moves
	 * 
	 * @param rules
	 *            the ruleset in use
	 * @param colour
	 *            the colour of the move we want to play
	 * @return a collection of the moves
	 */
	public Collection<Move> getAllLegalMoves(RuleSet rules, short colour) {
		return rules.getAllLegalMoves(null, this, colour);
	}

	/**
	 * Get a collection of all the legal moves
	 * 
	 * @param rules
	 *            the ruleset in use
	 * @param colour
	 *            the colour of the move we want to play
	 * @return the moves
	 */

	public Collection<Vertex> getAllLegalVertexes(RuleSet rules, short colour) {
		return rules.getAllLegalVertexes(null, this, colour);
	}


	public short getColour(int row, int column) {
		// System.err.println("getColour() " + " " + row + " " + column + " " +
		// size);
		if (row < 0 || column < 0 || row >= this.size || column >= this.size)
			return VERTEX_OFF_BOARD;
		return this.board[row][column];
	}

	/**
	 * get the colour of a vertex.
	 * 
	 * @param vertex
	 *            the vertex we're getting the colour of
	 * @return the colour
	 */
	public short getColour(Vertex vertex) {
		return this.getColour(vertex.getRow(), vertex.getColumn());
	}

	/**
	 * get the ruleSet
	 * 
	 * @return the ruleSet
	 */
	public final RuleSet getRuleSet() {
		return this.ruleSet;
	}

	/**
	 * get the size of this board.
	 * 
	 * @return the size
	 */
	public short getSize() {
		return this.size;
	}

	/**
	 * Gets the zobrist.
	 * 
	 * @return the zobrist
	 */
	public Zobrist getZobrist() {
		return this.zobrist;
	}

	/**
	 * initialise the board, creating it and setting it empty.
	 */
	protected void init() {
		this.board = new short[this.size][this.size];
		for (int i = 0; i < this.size; i++)
			for (int j = 0; j < this.size; j++)
				this.board[i][j] = VERTEX_EMPTY;
	}

	public boolean isOffBoard(int row, int column) {
		if (row < 0)
			return true;
		if (column < 0)
			return true;
		if (row >= this.getSize())
			return true;
		if (column < this.getSize())
			return true;
		return false;
	}

	public boolean isWayOffBoard(int row, int column) {
		if (row < -1)
			return true;
		if (column < -1)
			return true;
		if (row >= this.getSize() + 1)
			return true;
		if (column >= this.getSize() + 1)
			return true;
		return false;
	}

	/**
	 * create a new board based on the current board plus a move.
	 * 
	 * @param move
	 *            the move
	 * @return the new board
	 */
	public final Board newBoard(Move move) {
		return new Board(this, move);
	}

	/**
	 * Sets the colour of a vertex
	 * 
	 * @param row
	 *            the row
	 * @param column
	 *            the column
	 * @param colour
	 *            the colour
	 */
	protected void setColour(int row, int column, int colour) {

		// if (CHECK)
		// if ((row >= this.getSize()) || (row < 0))
		// throw new Error("Bad board size " + row + "/" + this.getSize() +
		// " ");
		// if (CHECK)
		// if ((column >= this.getSize()) || (column < 0))
		// throw new
		// Error("Bad board size or play off the edge of the board (remember we're zero indexed) "
		// + column + "/" + this.getSize() + " ");

		this.board[row][column] = (short) colour;
	}

	/**
	 * Sets the zobrist.
	 * 
	 * @param zobrist
	 *            the zobrist
	 */
	protected void setZobrist(Zobrist zobrist) {
		this.zobrist = zobrist;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jgogears.Boardnterface#toString()
	 */
	@Override
	public String toString() {
		return BoardToASCII.Transform(this);
	}


}
