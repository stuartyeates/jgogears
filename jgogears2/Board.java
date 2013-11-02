package jgogears2;

import java.util.List;

import jgogears.gtp.Statics;

/**
 * A Board represents a particular state of the board at a particular point in
 * time.
 * 
 * It doesn't store complete game state, since some Ko rules traverse all
 * previous board states.
 * 
 * @author syeates@gmail.com
 * 
 */

public class Board {
	/**
 * 
 */
	private short[][] board;
	/**
	 * 
	 */
	private short size = 19;
	/**
	 * 
	 */
	private Game game;
	/**
	 * 
	 */
	private short colour;

	/**
	 * 
	 */

	public Board() {
		init();
	}

	/**
	 * 
	 * @param size
	 */
	public Board(short size) {
		this.size = size;
		init();
	}

	/**
	 * 
	 * @param size
	 */
	public Board(int size) {
		this.size = (short) size;
		init();
	}

	/**
	 * 
	 * @param board
	 */
	public Board(Board board) {
		game = board.game;
		size = board.size;
		init(board);
	}

	/**
	 * 
	 * @param board
	 */
	protected void init(Board old) {
		board = new short[size][size];
		for (short i=0;i<size;i++)
			for (short j=0;j<size;j++)
				board[i][j] = old.board[i][j];

	}
	/**
	 * 
	 */
	protected void init() {
		board = new short[size][size];
		for (short i=0;i<size;i++)
			for (short j=0;j<size;j++)
				board[i][j] = Statics.VERTEX_EMPTY;
	}

	/**
	 * What colour is this vertex?
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public short getColour(short row, short column) {
		return board[row][column];
	}

	/**
	 * Return a new Board based on the current board and the given move
	 * 
	 * @param move
	 * @return
	 */
	public Board playMove(Move move) {
		Board board = new Board(this);
		board.init();
		throw new Error();
		// return board;
	}

	/**
	 * Is the given move legal?
	 * 
	 * @param move
	 * @return
	 */
	public boolean isLegal(Move move) {
		throw new Error();
	}

	/**
	 * What are all the legal moves?
	 * 
	 * @return
	 */
	public List<Move> getLegalMoves() {
		throw new Error();
	}

	/**
	 * Is black to play next?
	 * 
	 * @return
	 */
	public boolean blackToPlay() {
		if (Statics.VERTEX_BLACK == this.colour)
			return true;
		else
			return false;
	}
	/**
	 * Is black to play next?
	 * 
	 * @return
	 */
	public boolean whiteToPlay() {
		if (Statics.VERTEX_WHITE == this.colour)
			return true;
		else
			return false;
	}

	/**
	 * What game is this board a part of?
	 * 
	 * @return
	 */
	public Game getGame() {
		if (null == this.game)
			throw new Error("No game in Board.");
		return game;
	}

	/**
	 * 
	 * @return
	 */
	public short getSize() {
		return this.size;
	}
}
