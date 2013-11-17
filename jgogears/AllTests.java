package jgogears;

import jgogears.SGF.SGFGameTest;
import jgogears.SGF.SGFNodeTest;
import jgogears.SGF.SGFParserTest;
import jgogears.SGF.SGFPropertyTest;
import jgogears.engine.NodeIteratorTest;
import jgogears.engine.NodeTest;
import jgogears.engine.StraightVertexLineariserTest;
import jgogears.engine.SufogoEngineTest;
import jgogears.engine.TrainerTest;
import jgogears.engine.TreeIteratorTest;
import jgogears.engine.VertexLineariserTest;
import jgogears.gtp.GTPParserUtilsTest;
import jgogears.gtp.GTPScoreTest;
import jgogears.gtp.GnuGoEngineTest;
import jgogears.gtp.GnuGoEngineTest2;
import jgogears.gtp.TwoGTPTest;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Package-wide test collection.
 * 
 * @author syeates@gmail.com
 */
public class AllTests {

	/**
	 * Package-wide test collection.
	 * 
	 * @return the test
	 * @author syeates@gmail.com
	 */

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for jgogears");
		//$JUnit-BEGIN$
		suite.addTestSuite(BoardTest.class);
		suite.addTestSuite(BoardTest2.class);
		suite.addTestSuite(BoardToASCIITest.class);
		suite.addTestSuite(CheckAllSGFFilesTest.class);
		suite.addTestSuite(GameTest.class);
		suite.addTest(GlobalTests.suite());
		suite.addTestSuite(MoveTest.class);
		suite.addTestSuite(NoKoRuleSetTest.class);
		suite.addTestSuite(RandomTest.class);
		suite.addTestSuite(RankTest.class);
		suite.addTestSuite(ZobristTest.class);
		//$JUnit-END$
		
		//suite.addTestSuite(ModelTest.class);
		suite.addTestSuite(NodeIteratorTest.class);
		suite.addTestSuite(NodeTest.class);
		suite.addTestSuite(StraightVertexLineariserTest.class);
		suite.addTestSuite(SufogoEngineTest.class);
		suite.addTestSuite(TrainerTest.class);
		suite.addTestSuite(TreeIteratorTest.class);
		suite.addTestSuite(VertexLineariserTest.class);
		
		suite.addTestSuite(GnuGoEngineTest.class);
		suite.addTestSuite(GnuGoEngineTest2.class);
		suite.addTestSuite(GTPParserUtilsTest.class);
		suite.addTestSuite(GTPScoreTest.class);
		suite.addTestSuite(TwoGTPTest.class);
		
		suite.addTestSuite(SGFGameTest.class);
		suite.addTestSuite(SGFNodeTest.class);
		suite.addTestSuite(SGFParserTest.class);
		suite.addTestSuite(SGFPropertyTest.class);

		return suite;
	}

}
