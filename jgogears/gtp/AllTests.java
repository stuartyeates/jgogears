package jgogears.gtp;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(GnuGoEngineTest.class);
		suite.addTestSuite(GnuGoEngineTest2.class);
		suite.addTestSuite(GTPParserUtilsTest.class);
		suite.addTestSuite(GTPScoreTest.class);
		suite.addTestSuite(TwoGTPTest.class);
		//$JUnit-END$
		return suite;
	}

}
