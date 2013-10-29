package jgogears2;

import java.util.Properties;
import java.util.List;

public interface Game {

	public List<Board> getBoards();

	public List<Move> getMoves();

	public Properties getProperties();

	public boolean GetRuleset();

	public boolean isFinished();

	public boolean isScored();

}
