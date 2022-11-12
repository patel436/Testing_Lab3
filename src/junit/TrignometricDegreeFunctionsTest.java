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
public class TrignometricDegreeFunctionsTest {

	double decimalpoints = 0.0001;
	TrignometricFunctions functions;
	int degree;

	public TrignometricDegreeFunctionsTest(int degree) {
		this.degree = degree;
	}

	@Parameterized.Parameters(name = "{index}: Degree = {0}")
	public static Collection<Object> functionValues() {
		return Arrays.asList(new Object[] { -6, 47, 170, 190, 280, 290, 350 });
	}

	@Before
	public void initialize() {
		functions = new TrignometricFunctions();
	}

	@Test
	public void testSinDegree() {
		assertEquals(Math.sin(Math.toRadians(degree)), functions.sinDegree(degree), decimalpoints);
	}

	@Test
	public void testCosDegree() {
		assertEquals(Math.cos(Math.toRadians(degree)), functions.cosDegree(degree), decimalpoints);
	}

	@Test
	public void testTanDegree() {
		assertEquals(Math.tan(Math.toRadians(degree)), functions.tanDegree(degree), decimalpoints);
	}

	@Test
	public void testToRadian() {
		assertEquals(Math.toRadians(degree), functions.toRadian(degree), decimalpoints);
	}

}
