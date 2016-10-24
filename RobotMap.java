package org.usfirst.frc3482.robot;

import org.usfirst.frc3482.robot.subsystems.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;

public class RobotMap {
	public static CANTalon frontLeft;
	public static CANTalon backLeft;
	public static CANTalon frontRight;
	public static CANTalon backRight;
	public static RobotDrive driveRobot;
	public static Relay feedShooter;
	public static CANTalon intakeBall;
	public static DigitalInput limitSwitch;
	public static CANTalon shootBall;
	public static CANTalon raiseIntake;
	public static CANTalon intake;
	
	public static void init() {
		
		frontLeft = new CANTalon(0);
		backLeft = new CANTalon(8);
		frontRight = new CANTalon(2);
		backRight = new CANTalon(3);
		driveRobot = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
		feedShooter = new Relay(0);
		
		intakeBall = new CANTalon(7);
		raiseIntake = new CANTalon(5);
		
		limitSwitch = new DigitalInput(2);
		
		shootBall = new CANTalon(4);
		
	}
}
