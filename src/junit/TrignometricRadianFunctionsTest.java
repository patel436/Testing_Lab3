package junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import math.TrignometricFunctions;

@RunWith(Parameterized.class)
public class TrignometricRadianFunctionsTest {
	double decimalpoints = 0.0001;
	TrignometricFunctions functions;
	int radian;

	public TrignometricRadianFunctionsTest(int radian) {
		this.radian = radian;
	}

	@Parameterized.Parameters(name = "{index}: Radian = {0}")
	public static Collection<Object> functionValues() {
		return Arrays.asList(new Object[] { -6, 32, 90, 100, 180, 270, 330 });
	}

	@Before
	public void initialize() {
		functions = new TrignometricFunctions();
	}

	@Test
	public void testSin() {
		assertEquals(Math.sin(radian), functions.sin(radian), decimalpoints);
	}

	@Test
	public void testCos() {
		assertEquals(Math.cos(radian), functions.cos(radian), decimalpoints);
	}

	@Test
	public void testTan() {
		assertEquals(Math.tan(radian), functions.tan(radian), decimalpoints);
	}

	@Test
	public void testToDegree() {
		assertEquals(Math.toDegrees(radian), functions.toDegree(radian), decimalpoints);
	}
}
