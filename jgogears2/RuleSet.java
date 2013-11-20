package jgogears2;

import java.util.Properties;

public interface RuleSet {
	/**
	 * 
	 * @return
	 */
	
	public Properties getHandicaps();
	/**
	 * 
	 * @param b
	 * @param count
	 */
	public void placeHandicaps(Board b, short count);
	/**
	 * 
	 * @return
	 */
	public String getName();
	/**
	 * 
	 * @param board
	 * @param move
	 * @return
	 */
	public boolean isLegalMove(Board board, Move move);

	
}
