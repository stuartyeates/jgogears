/**
 * 
 */
package jgogears.engine;

import junit.framework.*;

/**
 * TODO
 * 
 * @author syeates
 * 
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for jgogears.engine");
		//$JUnit-BEGIN$
		suite.addTestSuite(ModelTest.class);
		suite.addTestSuite(NodeIteratorTest.class);
		suite.addTestSuite(NodeTest.class);
		suite.addTestSuite(StraightVertexLineariserTest.class);
		suite.addTestSuite(SufogoEngineTest.class);
		suite.addTestSuite(TrainerTest.class);
		suite.addTestSuite(TreeIteratorTest.class);
		suite.addTestSuite(VertexLineariserTest.class);
		//$JUnit-END$
		return suite;
	}

}
