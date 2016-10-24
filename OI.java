package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc3482.robot.commands.*;
import org.usfirst.frc3482.robot.subsystems.*;
import edu.wpi.first.wpilibj.DigitalInput;
public class OI {

	public Joystick xboxController;
	public JoystickButton startFeedButton;
	public JoystickButton reverseFeedButton;
	public Joystick joystick;
	public JoystickButton spinIntakeButton;
	public JoystickButton spinOuttakeButton;
	public JoystickButton startShooterButton;
	public JoystickButton raiseIntakeButton;
	public JoystickButton lowerIntakeButton;
	public JoystickButton getPositionButton;
	
	public OI() {
		xboxController = new Joystick(0);
		joystick = new Joystick(1);
		
		startFeedButton = new JoystickButton(joystick, 1);
		startFeedButton.whileHeld(new FeedShooter(true));
		
		reverseFeedButton = new JoystickButton(joystick, 2);
		reverseFeedButton.whileHeld(new FeedShooter(false));
		
		spinOuttakeButton = new JoystickButton(joystick, 3);
		spinOuttakeButton.whenPressed(new SpinIntake(true));
		
		spinIntakeButton = new JoystickButton(joystick, 4);
		spinIntakeButton.whenPressed(new SpinIntake(false));
		
		startShooterButton = new JoystickButton(joystick, 5);
		startShooterButton.whileHeld(new Shoot());
		
		raiseIntakeButton = new JoystickButton(joystick, 6);
		raiseIntakeButton.whileHeld(new MoveIntake(true));
		
		lowerIntakeButton = new JoystickButton(joystick, 7);
		lowerIntakeButton.whileHeld(new MoveIntake(false));
		
	}
	public Joystick getxboxController() {
		return xboxController;
	}
	
	public Joystick getJoystick() {
		return joystick;
	}
}
