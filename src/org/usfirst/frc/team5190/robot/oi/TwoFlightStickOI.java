package org.usfirst.frc.team5190.robot.oi;

import org.usfirst.frc.team5190.robot.joystick.LogitechExtreme3D;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class TwoFlightStickOI extends AbstractOI {
	private Joystick flightStickDrive;
	private Joystick flightStickShoot;
	private double cherryPickerButtonSpeed = 1.0;

	public TwoFlightStickOI() {
		this(0, 1);
	}

	public TwoFlightStickOI(int portDrive, int portShoot) {
		flightStickDrive = new Joystick(portDrive);
		flightStickShoot = new Joystick(portShoot);

		initializeButtons();

		// JoystickButton slightlyLeft = new JoystickButton(flightStickDrive,
		// LogitechExtreme3D.UPPER_BUTTON_TOP_LEFT);
		// slightlyLeft.whenPressed(new TurnCommand(-4));
		// JoystickButton slightlyRight = new JoystickButton(flightStickDrive,
		// LogitechExtreme3D.UPPER_BUTTON_TOP_RIGHT);
		// slightlyRight.whenPressed(new TurnCommand(4));
		// JoystickButton left90 = new JoystickButton(flightStickDrive,
		// LogitechExtreme3D.UPPER_BUTTON_BOTTOM_LEFT);
		// left90.whenPressed(new TurnCommand(-90));
		// JoystickButton right90 = new JoystickButton(flightStickDrive,
		// LogitechExtreme3D.UPPER_BUTTON_BOTTOM_RIGHT);
		// right90.whenPressed(new TurnCommand(90));
	}

	/**
	 * 
	 * @return gives caller the driveStick Joystick for their use.
	 */
//for the simulator
	public Joystick getJoystick() {
		return flightStickDrive;
	}
	
	public Joystick getDriveStick() {
		return flightStickDrive;
	}

	/**
	 * 
	 * @return gives caller shootStick for their use.
	 */
	public Joystick getShootStick() {
		return flightStickShoot;
	}

	/**
	 * @return gives the user the Y axis value of the joystick
	 */
	@Override
	public double getForwardReverseAxis() {
		double speed = -flightStickDrive.getRawAxis(LogitechExtreme3D.Y_AXIS);
		return speed;
	}

	/**
	 * @return gives the user the X axis value of the joystick
	 */
	@Override
	public double getLeftRightAxis() {
		double speed = -flightStickDrive.getRawAxis(LogitechExtreme3D.Z_ROTATE);
		return speed;
	}

	/**
	 * @return speed from throttle on joystick (slider)
	 */
	public double getFlightStickSpeed() {
		return (flightStickDrive.getThrottle() + 1.0) / 2.0;
	}

	/**
	 * @return Axis for arm (y axis on joystick)
	 */
	@Override
	public double getArmAxis() {
		return -flightStickShoot.getRawAxis(LogitechExtreme3D.Y_AXIS);
	}

	/**
	 * @return get cherry picker speed (y axis on joystick) Recommended that in
	 *         your command, have a button pressed to activate the cherry
	 *         picker.
	 */
	@Override
	public double getCherryPickerAxis() {
		boolean extendButton = flightStickShoot
				.getRawButton(LogitechExtreme3D.TRIGGER);
		boolean retractButton = flightStickShoot
				.getRawButton(LogitechExtreme3D.THUMB_BUTTON);
		if (retractButton) {
			return -cherryPickerButtonSpeed;
		} else if (extendButton) {
			return cherryPickerButtonSpeed;
		}
		return 0.0;
	}

	/**
	 * @return pawl speed via twist from FlightstickShoot
	 */
	@Override
	public double getPawlAxis() {
		return flightStickShoot.getRawAxis(LogitechExtreme3D.Z_ROTATE);
	}

	@Override
	protected Button getLevelUpButton() {
		return new JoystickButton(flightStickShoot,
				LogitechExtreme3D.UPPER_BUTTON_TOP_LEFT);
	}

	@Override
	protected Button getLevelDownButton() {
		return new JoystickButton(flightStickShoot,
				LogitechExtreme3D.UPPER_BUTTON_BOTTOM_LEFT);
	}

	@Override
	protected Button getZeroPawlButton() {
		return new JoystickButton(flightStickShoot,
				LogitechExtreme3D.BOTTOM_BUTTON_TOP_RIGHT);
	}

	@Override
	protected Button getKillButton() {
		return new JoystickButton(flightStickDrive,
				LogitechExtreme3D.BOTTOM_BUTTON_BOTTOM_RIGHT);
	}

	@Override
	protected Button getMoarPowahButton() {
		return new JoystickButton(flightStickDrive, LogitechExtreme3D.TRIGGER);
	}

}
// hail hydra