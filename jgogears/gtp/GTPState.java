package jgogears.gtp;

import java.util.*;

<<<<<<< HEAD:jgogears/gtp/GTPState.java
import jgogears.*;
=======
import jgogears.BoardI;
>>>>>>> 1edbc895dc439fd9b3244e2e6f0eb32186127032:jgogears/gtp/GTPState.java
import jgogears.Move;
import jgogears.RuleSet;
import jgogears.Vertex;

// TODO: Auto-generated Javadoc
/**
 * Class representing the state of a GTP game.
 * 
 * @author syeates@gmail.com
 */
public class GTPState {

	/** The boardsize. */
	protected short boardsize = Statics.DEFAULT_BOARD_SIZE;

	/** The board. */
	protected Board board = null;

	/** The white captured count. */
	protected int whiteCapturedCount = Integer.MIN_VALUE;

	/** The black captured count. */
	protected int blackCapturedCount = Integer.MIN_VALUE;

	/** The komi. */
	protected double komi = Double.MIN_VALUE;

	/** The main time. */
	protected double mainTime = Double.MIN_VALUE;

	/** The byo yomi time. */
	protected double byoYomiTime = Double.MIN_VALUE;

	/** The byo yomi stones. */
	protected double byoYomiStones = Double.MIN_VALUE;

	/** The played moves. */
	protected java.util.Vector<Move> playedMoves = new java.util.Vector<Move>();

	/**
	 * Create a new GTPState
	 */
	public GTPState() {
		this.board = new Board(this.boardsize);
	}

	/**
	 * returns true if we're in a playable state or throws an error.
	 * 
	 * @return true if everything is hunky-dory
	 */
	public boolean check() {
		if (this.board == null)
			throw new Error("Illegal GTPState state");
		if (this.whiteCapturedCount < 0)
			throw new Error("Illegal GTPState state");
		if (this.blackCapturedCount < 0)
			throw new Error("Illegal GTPState state");
		if (this.komi < 10000 && this.komi > 10000)
			throw new Error("Illegal GTPState state");
		if (this.mainTime < 0)
			throw new Error("Illegal GTPState state");
		if (this.byoYomiTime < 0)
			throw new Error("Illegal GTPState state");
		if (this.byoYomiStones < 0)
			throw new Error("Illegal GTPState state");

		return true;
	}

	/**
	 * Clear board.
	 */
	public void clearBoard() {
		// TODO is this sufficient?
		this.whiteCapturedCount = 0;
		this.blackCapturedCount = 0;
		this.board = new Board((short) this.getBoardsize());
		this.playedMoves = new java.util.Vector<Move>();
	}

	/**
	 * Gets the black captured count.
	 * 
	 * @return the black captured count
	 */
	public int getBlackCapturedCount() {
		return this.blackCapturedCount;
	}

	/**
	 * Gets the board.
	 * 
	 * @return the board
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * Gets the boardsize.
	 * 
	 * @return the boardsize
	 */
	public int getBoardsize() {
		return this.boardsize;
	}

	/**
	 * Gets the byo yomi stones.
	 * 
	 * @return the byo yomi stones
	 */
	public double getByoYomiStones() {
		return this.byoYomiStones;
	}

	/**
	 * Gets the byo yomi time.
	 * 
	 * @return the byo yomi time
	 */
	public double getByoYomiTime() {
		return this.byoYomiTime;
	}

	/**
	 * Gets the komi.
	 * 
	 * @return the komi
	 */
	public double getKomi() {
		return this.komi;
	}

	/**
	 * Gets the main time.
	 * 
	 * @return the main time
	 */
	public double getMainTime() {
		return this.mainTime;
	}

	/**
	 * Gets the moves.
	 * 
	 * @return the moves
	 */
	public java.util.Vector<Move> getMoves() {
		return new java.util.Vector<Move>(this.playedMoves);
	}

	/**
	 * Gets the white captured count.
	 * 
	 * @return the white captured count
	 */
	public int getWhiteCapturedCount() {
		return this.whiteCapturedCount;
	}

	/**
	 * Play move.
	 * 
	 * @param move
	 *            the move
	 */
	public void playMove(Move move) {
		this.playedMoves.add(move);
		if (move.getPass())
			return;
		if (move.getResign())
			return;
		TreeSet<Vertex> captures = RuleSet.DEFAULT.captures(null, this.board,
				move);
		// TODO count the captures
		Iterator<Vertex> each = captures.iterator();
		while (each.hasNext()) {
			Vertex vert = each.next();
			switch (this.board.getColour(vert)) {
			case Statics.VERTEX_BLACK:
				this.whiteCapturedCount++;
				break;
			case Statics.VERTEX_WHITE:
				this.blackCapturedCount++;
				break;
			default:
				throw new Error("capture neither black or white");
			}

		}
		this.board = this.board.newBoard(move);
	}

	/**
	 * Sets the black captured count.
	 * 
	 * @param blackCapturedCount
	 *            the new black captured count
	 */
	public void setBlackCapturedCount(int blackCapturedCount) {
		this.blackCapturedCount = blackCapturedCount;
	}

	/**
	 * Sets the board.
	 * 
	 * @param board
	 *            the new board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Sets the boardsize.
	 * 
	 * @param boardsize
	 *            the new boardsize
	 */
	public void setBoardsize(short boardsize) {
		this.boardsize = boardsize;
		this.board = new Board(boardsize);
	}

	/**
	 * Sets the byo yomi stones.
	 * 
	 * @param byoTomiStones
	 *            the new byo yomi stones
	 */
	public void setByoYomiStones(double byoTomiStones) {
		this.byoYomiStones = byoTomiStones;
	}

	/**
	 * Sets the byo yomi time.
	 * 
	 * @param byoYomiTime
	 *            the new byo yomi time
	 */
	public void setByoYomiTime(double byoYomiTime) {
		this.byoYomiTime = byoYomiTime;
	}

	/**
	 * Sets the komi.
	 * 
	 * @param komi
	 *            the new komi
	 */
	public void setKomi(double komi) {
		this.komi = komi;
	}

	/**
	 * Sets the main time.
	 * 
	 * @param mainTime
	 *            the new main time
	 */
	public void setMainTime(double mainTime) {
		this.mainTime = mainTime;
	}

	/**
	 * Sets the white captured count.
	 * 
	 * @param whiteCapturedCount
	 *            the new white captured count
	 */
	public void setWhiteCapturedCount(int whiteCapturedCount) {
		this.whiteCapturedCount = whiteCapturedCount;
	}
}
