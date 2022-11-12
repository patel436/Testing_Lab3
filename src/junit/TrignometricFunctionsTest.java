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
public class TrignometricFunctionsTest {
	double decimalpoints = 0.0001;
	TrignometricFunctions functions;
	int radian;
	int degree;

	public TrignometricFunctionsTest(int radian, int degree) {
		this.radian = radian;
		this.degree = degree;
	}

	@Parameterized.Parameters(name = "{index}: Radian = {0}, Degree = {1}")
	public static Collection functionValues() {
		return Arrays.asList(new Object[][] { { 45, 170 }, { 90, 190 }, { 100, 280 }, { 180, 290 }, { 270, 350 }, {-6 ,90} });
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

	@Test
	public void testToDegree() {
		assertEquals(Math.toDegrees(radian), functions.toDegree(radian), decimalpoints);
	}
}
