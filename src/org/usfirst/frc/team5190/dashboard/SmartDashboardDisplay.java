package org.usfirst.frc.team5190.dashboard;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardDisplay implements Display {

	@Override
	public void putNumber(String key, double value) {
		SmartDashboard.putNumber(key, value);
	}

	@Override
	public void putString(String key, String value) {
		SmartDashboard.putString(key, value);
	}

	@Override
	public void putBoolean(String key, boolean value) {
		SmartDashboard.putBoolean(key, value);
	}

}
