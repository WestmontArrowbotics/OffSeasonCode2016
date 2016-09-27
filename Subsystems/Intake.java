package org.usfirst.frc3482.robot.subsystems;

import org.usfirst.frc3482.robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

public class Intake extends Subsystem {

	private final Relay feed = RobotMap.feedShooter;
	
	public void startFeed() {
		feed.set(Relay.Value.kForward);
	}
	
	public void reverseFeed() {
		feed.set(Relay.Value.kReverse);
	}
	
	public void stopFeed() {
		feed.set(Relay.Value.kOff);
	}
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
