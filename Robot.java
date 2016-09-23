package org.usfirst.frc3482.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.*;

import org.usfirst.frc3482.robot.subsystems.*;
import org.usfirst.frc3482.robot.commands.*;

public class Robot extends IterativeRobot {
		
	Command teleopCommand;
	Command autonomousCommand;
	
	public static OI oi;
	public static Chassis chassis;
	
	public static SendableChooser autoChooser;
		
	public void robotInit() {
		RobotMap.init();
		chassis = new Chassis();
		
		oi = new OI();
	
		//autoChooser = new SendableChooser();
		//autonomousCommand = new AutonomousCommand;
		teleopCommand = new Drive();
	}
	
	public void disabledInit() {
		
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		System.out.println("Autonomous Initiated");
		//autonomousCommand = (Command) autoChooser.getSelected();
		if (autonomousCommand != null) autonomousCommand.start();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}
	
	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
	}
	
	public void operatorControl() {
		while(isOperatorControl() && isEnabled()) {
			//Robot.chassis.drive(Robot.oi.getxboxController());
			//Timer.delay(.05);
		}
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Robot.chassis.drive(Robot.oi.getxboxController());
	}
	
	public void testPeriodic() {
		
	}
}
