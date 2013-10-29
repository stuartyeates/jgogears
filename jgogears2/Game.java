package jgogears2;

import java.util.Properties;
import java.util.List;

public interface Game {

	public Properties getProperties();

	public List<Move> getMoves();

	public List<Board> getBoards();

	public boolean isFinished();

	public boolean isScored();

	public boolean GetRuleset();

}
