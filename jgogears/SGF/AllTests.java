package jgogears.SGF;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(SGFGameTest.class);
		suite.addTestSuite(SGFNodeTest.class);
		suite.addTestSuite(SGFParserTest.class);
		suite.addTestSuite(SGFPropertyTest.class);
		//$JUnit-END$
		return suite;
	}

}
