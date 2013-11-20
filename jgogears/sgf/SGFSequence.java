package jgogears.sgf;

import java.util.*;

/**
 * The Class SGFSequence.
 */
public class SGFSequence extends Vector<SGFNode> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5676939490740223788L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Vector#toString()
	 */
	@Override
	public String toString() {
		Iterator<SGFNode> i = this.iterator();
		String result = "";
		while (i.hasNext()) {
			result = result + i.next().toString();
		}
		return result;
	}

}
