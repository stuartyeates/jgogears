package jgogears2;

import java.util.Properties;

public interface RuleSet {
	
	public Properties getHandicaps();
	
	public void placeHandicaps(Board b, short count);
	
	public String getName();
	
	public boolean isLegalMove(Board board, Move move);

	
}
