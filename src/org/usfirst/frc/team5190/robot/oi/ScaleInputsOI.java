package org.usfirst.frc.team5190.robot.oi;

import org.usfirst.frc.team5190.robot.config.Configurable;
import org.usfirst.frc.team5190.robot.config.ConfigurationManager;

import edu.wpi.first.wpilibj.Preferences;

public class ScaleInputsOI implements OI, Configurable {
	private static final double FORWARD_REVERSE_SCALING = 0.9;
	private static final double LEFT_RIGHT_SCALING = 1.0;
	private static final double ARM_SCALING = 0.5;
	private static final double CHERRY_PICKER_SCALING = 0.5;
	private static final double PAWL_SCALING = 1.0;

	private Preferences pref = Preferences.getInstance();
	private double forwardReverseScalingValue;
	private double leftRightScalingValue;
	private double armScalingValue;
	private double cherryPickerScalingValue;
	private double pawlScalingValue;
	private OI sourceOI;

	public ScaleInputsOI(OI sourceOI) {
		ConfigurationManager.getInstance().addConfigurable(this);

		updateConfiguration();

		this.sourceOI = sourceOI;
	}

	@Override
	public double getForwardReverseAxis() {
		return sourceOI.getForwardReverseAxis() * forwardReverseScalingValue;
	}

	@Override
	public double getLeftRightAxis() {
		return sourceOI.getLeftRightAxis() * leftRightScalingValue;
	}

	@Override
	public double getArmAxis() {
		return sourceOI.getArmAxis() * armScalingValue;
	}

	@Override
	public double getCherryPickerAxis() {
		return sourceOI.getCherryPickerAxis() * cherryPickerScalingValue;
	}

	@Override
	public double getPawlAxis() {
		return sourceOI.getPawlAxis() * pawlScalingValue;
	}

	@Override
	public void updateConfiguration() {
		forwardReverseScalingValue = pref.getDouble(
				"control.axis.scaling.forwardreverse", FORWARD_REVERSE_SCALING);
		leftRightScalingValue = pref.getDouble(
				"control.axis.scaling.leftright", LEFT_RIGHT_SCALING);
		armScalingValue = pref.getDouble("control.axis.scaling.arm",
				ARM_SCALING);
		cherryPickerScalingValue = pref.getDouble(
				"control.axis.scaling.cherrypicker", CHERRY_PICKER_SCALING);
		pawlScalingValue = pref.getDouble("control.axis.scaling.pawl",
				PAWL_SCALING);
	}

}
