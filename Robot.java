package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.SampleRobot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;

public class Robot extends SampleRobot {
	CANTalon frontLeft, frontRight, rearLeft, rearRight;
	RobotDrive robotDrive;
	Joystick driveController;
	double deadZone = 0.1;
	double rotateSpeed = 0.75;
	double leftY = driveController.getRawAxis(2);
	double rightX = driveController.getRawAxis(4);
	
	public void robotInit() {
		frontLeft = new CANTalon(0);
		rearLeft = new CANTalon(8);
		frontRight = new CANTalon(2);
		rearRight = new CANTalon(3);
		robotDrive = new RobotDrive(frontLeft,rearLeft,frontRight,rearRight);
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
