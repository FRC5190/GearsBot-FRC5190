package org.usfirst.frc.team5190.dashboard;

public interface Display {

	void putNumber(String key, double value);

	void putString(String key, String value);

	void putBoolean(String key, boolean value);

}
