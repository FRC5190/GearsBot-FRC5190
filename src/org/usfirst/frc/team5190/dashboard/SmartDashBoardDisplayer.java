package org.usfirst.frc.team5190.dashboard;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class SmartDashBoardDisplayer {
	/**
	 * The delay in time between successive display calls
	 */
	public static final long DISPLAY_EXECUTION_RATE = 20;
	private LinkedList<Displayable> queue;
	private static SmartDashBoardDisplayer instance;
	private Display display = new SmartDashboardDisplay();
	private Timer displayTimer;

	static {
		instance = new SmartDashBoardDisplayer();
	}

	private SmartDashBoardDisplayer() {
		queue = new LinkedList<Displayable>();
		displayTimer = new Timer("DashboardDisplayer", true);
	}

	private class DashboardTimerTask extends TimerTask {

		@Override
		public void run() {
			for (Displayable iter : queue) {
				iter.displayValues(display);
			}
		}

	}

	/**
	 * singlinton design pattern, get one instance of this class
	 * 
	 * @return the instance
	 */
	public static SmartDashBoardDisplayer getInstance() {
		return instance;
	}

	/**
	 * adds a Displayable to be scheduled to be displayed
	 * 
	 * @param toAdd
	 *            the Displayable to be added
	 */
	public void addDisplayable(Displayable toAdd) {
		queue.add(toAdd);
	}

	public void start() {
		displayTimer.scheduleAtFixedRate(new DashboardTimerTask(), 0, 20);
	}

	public void stop() {
		displayTimer.cancel();
	}
}
