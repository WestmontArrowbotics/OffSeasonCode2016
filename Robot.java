package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc3482.robot.subsystems.*;
import org.usfirst.frc3482.robot.commands.*;

public class Robot extends IterativeRobot {
		
	Command teleopCommand;
	
	public static OI oi;
	public static Chassis chassis;
		
	public void robotInit() {
		RobotMap.init();
		chassis = new Chassis();
		
		teleopCommand = new Drive();
		
		oi = new OI();
	}
	
	public void disabledInit() {
		
	}
	
	public void disabledPeriodic() {
		//Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		
	}
	
	public void autonomousPeriodic() {
		//Scheduler.getInstance().run();
		
	}
	
	public void teleopInit() {
		Scheduler.getInstance().run();
		Robot.chassis.drive(Robot.oi.getxboxController());
	}
	
	public void operatorControl() {
		while(isOperatorControl() && isEnabled()) {
			//Robot.chassis.drive(Robot.oi.getxboxController());
			//Timer.delay(.05);
		}
	}
	
	public void teleopPeriodic() {
		Robot.chassis.drive(Robot.oi.getxboxController());
	}
	
	public void testPeriodic() {
		
	}
}
