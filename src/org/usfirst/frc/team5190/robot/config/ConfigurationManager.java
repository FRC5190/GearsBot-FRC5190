package org.usfirst.frc.team5190.robot.config;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences.IncompatibleTypeException;

public class ConfigurationManager {

	private static ConfigurationManager instance = new ConfigurationManager();

	private ArrayList<Configurable> configurables = new ArrayList<>();
	private int configUpdatePeriod = 100;
	private int t = 0;

	private ConfigurationManager() {

	}

	public static ConfigurationManager getInstance() {
		return instance;
	}

	/**
	 * How often the {@link Configurable#updateConfiguration()} method should be
	 * called on the {@link Configurable}s. Value is in seconds. Defaults to 2.
	 * 
	 * @return
	 */
	public int getConfigUpdatePeriod() {
		return configUpdatePeriod;
	}

	/**
	 * @see #getConfigUpdatePeriod()
	 */
	public void setConfigUpdatePeriod(int configUpdatePeriod) {
		// shift to units of 20ms
		this.configUpdatePeriod = configUpdatePeriod * 50;
	}

	public void addConfigurable(Configurable configurable) {
		configurables.add(configurable);
	}

	/**
	 * This method should be called in all of the Periodic methods of
	 * {@link IterativeRobot}. Makes the assumption that each call will be 20ms
	 * apart to do its timing. On each call to this method it checks to see if
	 * {@link #getConfigUpdatePeriod()} has passed and if so call the
	 * {@link Configurable#updateConfiguration()} method of all of its
	 * {@link Configurable}s.
	 */
	public void configure() {
		if (t % configUpdatePeriod == 0) {
			for (Configurable configurable : configurables) {
				try {
					configurable.updateConfiguration();
				} catch (IncompatibleTypeException e) {
					System.out.println("Failed to set configuration for "
							+ configurable.getClass().getTypeName() + ". "
							+ e.getMessage());
				}
			}
		}
		t++;
	}
}
