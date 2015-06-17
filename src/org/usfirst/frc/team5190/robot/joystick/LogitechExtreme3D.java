package org.usfirst.frc.team5190.robot.joystick;

/**
 * 
 * button map for Logitech Joystick
 *
 */
public class LogitechExtreme3D {
	private static LogitechExtreme3D instance;
	// Upper buttons on Logitech Flight Stick
	public static final int TRIGGER = 1;
	public static final int THUMB_BUTTON = 2;
	public static final int UPPER_BUTTON_BOTTOM_LEFT = 3;
	public static final int UPPER_BUTTON_BOTTOM_RIGHT = 4;
	public static final int UPPER_BUTTON_TOP_LEFT = 5;
	public static final int UPPER_BUTTON_TOP_RIGHT = 6;
	// Lower buttons on Logitech Flight stick
	public static final int BOTTOM_BUTTON_TOP_LEFT = 7;
	public static final int BOTTOM_BUTTON_TOP_RIGHT = 8;
	public static final int BOTTOM_BUTTON_CENTER_LEFT = 9;
	public static final int BOTTOM_BUTTON_CENTER_RIGHT = 10;
	public static final int BOTTOM_BUTTON_BOTTOM_LEFT = 11;
	public static final int BOTTOM_BUTTON_BOTTOM_RIGHT = 12;
	// Axis
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;
	public static final int Z_ROTATE = 2;
	public static final int SLIDER = 3;

	/**
	 * 
	 * @return instance of LogitechExtreme3D for use by other classes without
	 *         making duplicates
	 */
	public static LogitechExtreme3D getInstance() {
		if (instance == null) {
			try {
				instance = new LogitechExtreme3D();
			} catch (Throwable t) {
				t.printStackTrace();
				throw t;
			}
		}
		return instance;
	}

}
