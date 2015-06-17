package org.usfirst.frc.team5190.robot.oi;

//import org.usfirst.frc.team5190.robot.commands.GoToLevelCommand;
//import org.usfirst.frc.team5190.robot.commands.KillCommand;
//import org.usfirst.frc.team5190.robot.commands.MoarPowahCommand;
//import org.usfirst.frc.team5190.robot.commands.ZeroPawlCommand;

import edu.wpi.first.wpilibj.buttons.Button;

public abstract class AbstractOI implements OI {

	public AbstractOI() {
	}

	protected void initializeButtons() {
//		getLevelUpButton().whenPressed(new GoToLevelCommand(true));
//		getLevelDownButton().whenPressed(new GoToLevelCommand(false));
//		getZeroPawlButton().whenPressed(new ZeroPawlCommand());
//		getKillButton().whenPressed(new KillCommand());

//		Button moarPowahButton = getMoarPowahButton();
//		moarPowahButton.whenPressed(new MoarPowahCommand(true));
//		moarPowahButton.whenReleased(new MoarPowahCommand(false));
	}

	protected abstract Button getLevelUpButton();

	protected abstract Button getLevelDownButton();

	protected abstract Button getZeroPawlButton();

	protected abstract Button getKillButton();

	protected abstract Button getMoarPowahButton();
}
