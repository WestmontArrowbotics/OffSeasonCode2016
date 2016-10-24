package org.usfirst.frc3482.robot.subsystems;

import org.usfirst.frc3482.robot.*;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class Intake extends Subsystem {

	private final Relay feed = RobotMap.feedShooter;
	private final CANTalon intakeBall = RobotMap.intakeBall;
	private final DigitalInput limitSwitch = RobotMap.limitSwitch;
	private final CANTalon moveIntake = RobotMap.raiseIntake;
	
	double startPosition; //.703
	private double lowerPosition; //-34.196
	private double restPosition; //-2.283
	private double portPosition;
	
	Counter counter = new Counter(limitSwitch);
	
	double targetPositionRotations;
	boolean isPID = false;
	
	public Intake() {
		int absolutePosition = moveIntake.getPulseWidthPosition() & 0xFFF;
        moveIntake.setEncPosition(absolutePosition);
        moveIntake.reverseSensor(false);
        moveIntake.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        //motor.configEncoderCodesPerRev(codesPerRev); //only for quad
        moveIntake.configNominalOutputVoltage(+0f, -0f);
        moveIntake.configPeakOutputVoltage(+12f, -12f);
        
        moveIntake.setAllowableClosedLoopErr(0);
		
		moveIntake.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		
        moveIntake.setProfile(0);
        moveIntake.setF(0.0);
        moveIntake.setP(0.02);
        moveIntake.setI(0.0);
        moveIntake.setD(0.0);
        
        startPosition = moveIntake.getPosition();
        restPosition = startPosition;
        lowerPosition = startPosition-32.92;
        targetPositionRotations = restPosition;
	}
	
	public void maintainPosition() {
		if (isPID) {
	        moveIntake.changeControlMode(TalonControlMode.Position);
	    	moveIntake.set(restPosition);
		}
	}
	
    public void stopPID() {
    	isPID = false;
    }
    
    public void startPID() {
    	isPID = true;
    }
    
    public boolean isPIDOn() {
    	return isPID;
    }
    
	public boolean isSwitchSet() {
		return counter.get() > 0;
    }

	public void initializeCounter() {
		counter.reset();
	}
	
	public void startIntake() {
		intakeBall.set(1.0);
	}
	
	public void outtakeBall() {
		intakeBall.set(-1.0);
	}
	
	public void startFeed() {
		feed.set(Relay.Value.kForward);
	}
	
	public void reverseFeed() {
		feed.set(Relay.Value.kReverse);
	}
	
	public void stopFeed() {
		feed.set(Relay.Value.kOff);
	}
	
	public void stopIntaking() {
		intakeBall.set(0.0);
	}
	
	public void raiseIntake() {
		this.stopPID();
		restPosition = startPosition;
		this.startPID();
	}
	
	public void lowerIntake() {
		this.stopPID();
		moveIntake.changeControlMode(TalonControlMode.Position);
		restPosition = lowerPosition;
		this.startPID();
	}
	
	public void stopMovingIntake() {
		moveIntake.changeControlMode(TalonControlMode.PercentVbus);
		moveIntake.set(0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

	public CANTalon getMoveIntake() {
		return moveIntake;
	}
}
