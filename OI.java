package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc3482.robot.commands.*;
import org.usfirst.frc3482.robot.subsystems.*;
public class OI {

	public Joystick xboxController;
	public JoystickButton startFeedButton;
	public JoystickButton reverseFeedButton;
	public Joystick joystick;
	public OI() {
		xboxController = new Joystick(0);
		joystick = new Joystick(1);
		
		startFeedButton = new JoystickButton(joystick, 1);
		startFeedButton.whileHeld(new FeedShooter(true));
		
		reverseFeedButton = new JoystickButton(joystick, 2);
		reverseFeedButton.whileHeld(new FeedShooter(false));
	}
	public Joystick getxboxController() {
		return xboxController;
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
}
