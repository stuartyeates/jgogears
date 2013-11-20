/**
 * 
 */
package jgogears.gtp;

import jgogears.gtp.GTPScore;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * test TwoGTP with a pair of GnuGo Players.
 * 
 * @author syeates
 */
public class TwoGTPTest extends TestCase {

	/**
	 * 
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void raw(short i) throws Exception {
		TwoGTPRaw two = new TwoGTPRaw();
		assertNotNull(two);
		two.setBlack(new GnuGoEngine(i));
		two.setWhite(new GnuGoEngine(i));
		two.playOutGame();
		GTPScore scoreb = two.getBlack().getFinalScore();
		GTPScore scorew = two.getWhite().getFinalScore();
		assertTrue(scoreb + " " + scorew, scoreb.equals(scorew));
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testRaw() throws Exception {
		for (short x=0; x< 100;x++)
			for (short i=7; 14 >= i;i++)
				raw(i);
	}


}
