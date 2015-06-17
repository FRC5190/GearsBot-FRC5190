package org.usfirst.frc.team5190.robot.oi;

import org.usfirst.frc.team5190.robot.oi.OIUtils.RampRate;

public class SetPowerCurvesOI implements OI {

	private OI sourceOI;
	private RampRate forwardReverseRampRate;
	private RampRate leftRightRampRate;

	public SetPowerCurvesOI(OI sourceOI) {
		this.sourceOI = sourceOI;
		forwardReverseRampRate = OIUtils.createRampRate(0.04);
		leftRightRampRate = OIUtils.createRampRate(0.04);
	}

	@Override
	public double getForwardReverseAxis() {
		double power = OIUtils.scaledCubic(1.0,
				sourceOI.getForwardReverseAxis());
		return forwardReverseRampRate.limitToRampRate(power);
	}

	@Override
	public double getLeftRightAxis() {
		double power = OIUtils.scaledCubic(0.8, sourceOI.getLeftRightAxis());
		power *= (sourceOI.getForwardReverseAxis() * 0.2 + 1);
		if (power > 1.0) {
			power = 1.0;
		}
		return leftRightRampRate.limitToRampRate(power);
	}

	@Override
	public double getArmAxis() {
		return OIUtils.scaledCubic(0.8, sourceOI.getArmAxis());
	}

	@Override
	public double getCherryPickerAxis() {
		return OIUtils.scaledCubic(0.8, sourceOI.getCherryPickerAxis());
	}

	@Override
	public double getPawlAxis() {
		return OIUtils.scaledCubic(0.8, sourceOI.getPawlAxis());
	}

}
