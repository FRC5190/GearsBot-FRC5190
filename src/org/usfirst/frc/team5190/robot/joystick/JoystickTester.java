package org.usfirst.frc.team5190.robot.joystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class JoystickTester extends Command {

	private Joystick joystick;

	public JoystickTester(Joystick joystick) {
		this.joystick = joystick;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		StringBuilder axisValues = new StringBuilder();
		for (int i = 0; i < joystick.getAxisCount(); i++) {
			axisValues.append("Axis ");
			axisValues.append(i);
			axisValues.append(": ");
			axisValues.append(joystick.getRawAxis(i));
			axisValues.append('\n');
		}
		SmartDashboard.putString("Axis Values", axisValues.toString());
		SmartDashboard.putNumber("Axis Count", joystick.getAxisCount());

		StringBuilder buttonValues = new StringBuilder();
		buttonValues.append("Pressed Buttons\n");
		for (int i = 1; i <= joystick.getButtonCount(); i++) {
			if (joystick.getRawButton(i)) {
				buttonValues.append("Button ");
				buttonValues.append(i);
				buttonValues.append('\n');
			}
		}
		SmartDashboard.putString("Button Values", buttonValues.toString());
		SmartDashboard.putNumber("Button Count", joystick.getButtonCount());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
