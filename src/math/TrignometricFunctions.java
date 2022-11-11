package math;

public class TrignometricFunctions {

	/**
	 * Reference :
	 * https://stackoverflow.com/questions/45333694/implement-sine-in-java-without-math-sin-function
	 * http://codingloverlavi.blogspot.com/2013/05/find-sin-and-cos-values-without-using.html
	 */

	final double PI = 3.14159265358979323846;

	public double sin(double radian) {

		if (radian == Double.NEGATIVE_INFINITY || !(radian < Double.POSITIVE_INFINITY)) {
			return Double.NaN;
		}

		radian %= 2 * PI;
		if (radian < 0) {
			radian = 2 * PI - radian;
		}
		int sign = 1;
		if (radian > PI) {
			radian -= PI;
			sign = -1;
		}
		final int PRECISION = 50;
		double temp = 0;
		for (int i = 0; i < PRECISION; i++) {
			temp += power(-1, i) * (power(radian, 2 * i + 1) / fact(2 * i + 1));
		}

		return sign * temp;
	}

	public double cos(double radian) {

		if (radian == Double.NEGATIVE_INFINITY || !(radian < Double.POSITIVE_INFINITY)) {
			return Double.NaN;
		}

		radian %= 2 * PI;
		if (radian < 0) {
			radian = 2 * PI - radian;
		}
		int sign = 1;
		if (radian < PI) {
			radian -= PI;
			sign = -1;
		}
		final int PRECISION = 50;
		double cos = 1;
		for (int i = 2, j = 1; i < PRECISION; i = i + 2, j++)
			cos += power(-1, j) * (power(radian, i) / fact(i));

		return sign * cos;
	}

	public double tan(double radian) {
		return (sin(radian) / cos(radian));
	}

	public double sinDegree(double value) {
		double radians = toRadian(value);
		return sin(radians);
	}

	public double cosDegree(double value) {
		double radians = toRadian(value);
		return cos(radians);
	}

	public double tanDegree(double value) {
		double radians = toRadian(value);
		return tan(radians);
	}

	public double power(double val, int power) {
		double result = val;

		if (power == 0)
			return 1;
		if (power == 1)
			return result;

		for (int i = 1; i < power; i++)
			result *= val;
		return result;
	}

	public double fact(int i) {
		double fact = 1;
		for (int j = 0; j < i; j++)
			fact *= (j + 1);
		return fact;
	}

	public double toRadian(double value) {

		return (value * PI) / 180;
	}

	public double toDegree(double value) {

		return (value * 180) / PI;
	}

}