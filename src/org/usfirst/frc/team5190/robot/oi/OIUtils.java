package org.usfirst.frc.team5190.robot.oi;

public class OIUtils {

	/**
	 * Squares the power while preserving sign. Gives finer control while at low
	 * power while still giving the full power range.
	 * 
	 * @param power
	 *            The power to square. Should be in the range from -1 to 1.
	 */
	public static double squared(double power) {
		if (power >= 0.0) {
			power = (power * power);
		} else {
			power = -(power * power);
		}
		return power;
	}

	/**
	 * Applies the following formula to the power x: x' = ax^3 + (1-a)x where a
	 * is a <i>scalingValue</i> from 0 to 1 which determines how close the power
	 * curve should be to x cubed. When a is 1 the power value is cubed. When a
	 * is 0 then the value is unchanged.
	 * 
	 * @param scalingValue
	 *            Must be in the range from 0 to 1. Sets how close to cubic the
	 *            power should be scaled.
	 * @param power
	 *            The power value
	 * @return The scaled power value
	 */
	public static double scaledCubic(double scalingValue, double power) {
		return scalingValue * power * power * power + (1 - scalingValue)
				* power;
	}

	public static double scaledSquare(double scalingValue, double power) {
		return scalingValue * power * power + (1 - scalingValue) * power;
	}

	public static double scaledSquareRoot(double scalingValue, double power) {
		return scalingValue * Math.sqrt(power);
	}

	public static double scaledCubeRoot(double scalingValue, double power) {
		final double pow = (1 / 3);
		return scalingValue * Math.pow(power, pow);
	}

	/**
	 * Intended to be used when a joystick doesn't return exactly zero when the
	 * stick in not being used.
	 * 
	 * @param zeroThreshold
	 *            Any value less then the threshold and greater than the
	 *            negative will be zero'd out. Should be between 0 and 1.
	 */
	public static double zeroSmallValues(double zeroThreshold, double power) {
		if (power < zeroThreshold && power > -zeroThreshold) {
			return 0;
		}
		return power;
	}

	public static class RampRate {
		private double rampRate;
		private double lastPowerValue = 0.0;

		public RampRate(double rampRate) {
			this.rampRate = rampRate;
		}

		public double limitToRampRate(double power) {
			// if the power value changes sign from the last one then reset the
			// last
			// value to 0.
			if (power > 0 && lastPowerValue < 0 || power < 0
					&& lastPowerValue > 0) {
				lastPowerValue = 0.0;
			}
			if (power > 0 && (power - lastPowerValue) > rampRate) {
				power = lastPowerValue + rampRate;
			} else if (power < 0 && (lastPowerValue - power) > rampRate) {
				power = lastPowerValue - rampRate;
			}
			lastPowerValue = power;
			return power;
		}
	}

	public static RampRate createRampRate(double rampRate) {
		return new RampRate(rampRate);
	}
}
