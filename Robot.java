package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends SampleRobot {
	RobotDrive robotDrive;
	Joystick driveController;
	double deadZone = 0.1;
	double rotateSpeed = 0.75;
	double leftY = driveController.getRawAxis(2);
	double rightX = driveController.getRawAxis(4);
	
	public void robotInit() {
		robotDrive = new RobotDrive(0,8,2,3);
		driveController = new Joystick(0);
	}
	
	public void autonomousPeriodic() {
		
	}
	
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			if (leftY < deadZone && leftY > -deadZone) {
				leftY = 0;
			}
			if (rightX < deadZone && rightX > -deadZone) {
				rightX = 0;
			}
			if (leftY == 0 && rightX == 0) {
				return;
			}
			robotDrive.arcadeDrive(leftY, rightX*rotateSpeed);
			Timer.delay(0.01);
		}
	}
	
}
