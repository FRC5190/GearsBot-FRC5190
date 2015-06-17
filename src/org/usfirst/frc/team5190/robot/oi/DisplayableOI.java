package org.usfirst.frc.team5190.robot.oi;

import org.usfirst.frc.team5190.dashboard.Display;
import org.usfirst.frc.team5190.dashboard.Displayable;
import org.usfirst.frc.team5190.dashboard.SmartDashBoardDisplayer;

public class DisplayableOI implements OI, Displayable {
	private OI sourceOI;

	public DisplayableOI(OI sourceOI) {
		this.sourceOI = sourceOI;
		SmartDashBoardDisplayer.getInstance().addDisplayable(this);
	}

	@Override
	public void displayValues(Display display) {
		display.putNumber("Forward Reverse Axis",
				sourceOI.getForwardReverseAxis());
		display.putNumber("Left Right Axis", sourceOI.getLeftRightAxis());
		display.putNumber("Arm Axis", sourceOI.getArmAxis());
		display.putNumber("Cherry Picker Axis", sourceOI.getCherryPickerAxis());
		display.putNumber("Pawl Axis", sourceOI.getPawlAxis());
	}

	@Override
	public double getForwardReverseAxis() {
		return sourceOI.getForwardReverseAxis();
	}

	@Override
	public double getLeftRightAxis() {
		return sourceOI.getLeftRightAxis();
	}

	@Override
	public double getArmAxis() {
		return sourceOI.getArmAxis();
	}

	@Override
	public double getCherryPickerAxis() {
		return sourceOI.getCherryPickerAxis();
	}

	@Override
	public double getPawlAxis() {
		return sourceOI.getPawlAxis();
	}

}
