package main.subsystems;

import interfacesAndAbstracts.ImprovedSubsystem;
import util.DriveHelper;
import main.commands.intake.ShootWithJoystick;

public class Intake extends ImprovedSubsystem {
	private static double intakeDeadband = 0.01;
	
	public static enum WheelStates {
		In, Out, Off
	}
	
	private DriveHelper driveHelper = new DriveHelper(7.5);
	public static WheelStates wheelStates = WheelStates.Off;
	
	public void spinIn() {
		leftIntakeMotor.set(1.0);
    	rightIntakeMotor.set(-1.0);
    	wheelStates = WheelStates.In;
	}
	
	public void spinOut() {
		leftIntakeMotor.set(-1.0);
    	rightIntakeMotor.set(1.0);
    	wheelStates = WheelStates.Out;
	}
	
	public void spinOff() {
    	leftIntakeMotor.set(0.0);
    	rightIntakeMotor.set(0.0);
    	wheelStates = WheelStates.Off;
	}
	
	public double getLeftIntakeWheelValue() {
		return leftIntakeMotor.get();
	}
	
	public double getRightIntakeWheelValue() {
		return leftIntakeMotor.get();
	}
	
	public void setIntakeValues(double leftIntakeWheelValue, double rightIntakeWheelValue) {
		leftIntakeMotor.set(leftIntakeWheelValue);
		rightIntakeMotor.set(rightIntakeWheelValue);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShootWithJoystick());
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeroSensors() {
		// TODO Auto-generated method stub
		
	}
	public void moveWithJoystick(double throttle) {
		leftIntakeMotor.set(driveHelper.handleOverPower(driveHelper.handleDeadband(throttle, intakeDeadband)));
		rightIntakeMotor.set(-driveHelper.handleOverPower(driveHelper.handleDeadband(throttle, intakeDeadband)));
	}
}
