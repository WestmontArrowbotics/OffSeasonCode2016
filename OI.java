package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

	public Joystick xboxController;
	public OI() {
		xboxController = new Joystick(0);
	}
	public Joystick getxboxController() {
		return xboxController;
	}
}
