package junit;

import org.junit.runner.JUnitCore;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	/**
	 * Reference : https://www.tutorialspoint.com/junit/junit_parameterized_test.htm
	 * 
	 */

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TrignometricFunctionsTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Total no of test case run: " + result.getRunCount());
		System.out.println("Total no of failures: " + result.getFailureCount());
		System.out.println("All tests were successfull: " + result.wasSuccessful());
	}
}
