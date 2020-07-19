/**
 * 
 */
package com.anupam.dbscodingtest;

import org.junit.runner.*;
import org.junit.runner.notification.Failure;

import com.anupam.dbscodingtest.utils.DBSFileUtilTest;


/**
 * Test Runner for unit test classes
 * @author Anupam
 *
 */
public class DBSCodingTestRunner {

	/**
	 * @param args - defaulf arguments parameter for the main method
	 */
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(DBSFileUtilTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}

}
