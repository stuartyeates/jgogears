package jgogears2;

import java.util.Properties;
import java.util.List;

/**
 * The Game defines everything about a particular occurrence of a game.
 * 
 * @author syeates@gmail.com
 *
 */
public interface Game {
	/**
	 * Get a list of boards associated with the game. If the game has not yet had any moves, there will be no items on the list.
	 * 
	 */

	public List<Board> getBoards();
	/**
	 * Get a list of moves associated with the game. If the game has not yet had any moves, there will be no items on the list.
	 *
	 */

	public List<Move> getMoves();
	/**
	 * Get the properties associated with this game
	 *
	 */

	public Properties getProperties();
	/**
	 * Get the RuleSet in Use
	 *
	 */

	public boolean GetRuleset();
	/**
	 * Is the game finished?
	 *
	 */

	public boolean isFinished();
	/**
	 * Is the game scored?
	 *
	 */

	public boolean isScored();

	/**
	 * Get the final score
	 * */
	 public Score getScore();
	
}
