package org.usfirst.frc3482.robot;

import org.usfirst.frc3482.robot.subsystems.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

public class RobotMap {
	public static CANTalon frontLeft;
	public static CANTalon backLeft;
	public static CANTalon frontRight;
	public static CANTalon backRight;
	public static RobotDrive driveRobot;
	
	public static void init() {
		
		frontLeft = new CANTalon(0);
		backLeft = new CANTalon(8);
		frontRight = new CANTalon(2);
		backRight = new CANTalon(3);
		driveRobot = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
	}
}
