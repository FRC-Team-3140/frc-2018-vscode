package main.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import interfacesAndAbstracts.ImprovedSubsystem;

public class Pneumatics extends ImprovedSubsystem {

	public Pneumatics() {
		shifter.set(EXT);
		shifter.set(OFF);
		tilter.set(EXT);
		tilter.set(OFF);
		intakeArm.set(EXT);
		intakeArm.set(OFF);
	}
	
	public static enum ArmStates {
		Opened, Closed, Off
	}
	
	public static enum LiftStates {
		Up, Down, Off
	}
	
	public static ArmStates armStates = ArmStates.Off;
	public static LiftStates liftStates = LiftStates.Off;
	
	//Default Robot State at start of match.
	public static boolean armClose = true;
	public static boolean tiltUp = true;
	public static boolean lowGear = true;

	/*******************
	 * COMMAND METHODS *
	 *******************/

	/**
	 * Shifts the gearbox from the different gears
	 * 
	 * @param v - Desired shifting value (Uses default shifting values)
	 */
	public void shift(DoubleSolenoid.Value v) {
		if (v == EXT) lowGear = true;
		else if (v == RET) lowGear = false;
		shifter.set(v);
	}

	// Toggles Arm to open or closed
	public void toggleArm(DoubleSolenoid.Value v) {
		if (v == EXT) armClose = true;
		else if (v == RET) armClose = false;
		intakeArm.set(v);
	}
		
	// Changes the tilter to up or down
	public void tilt(DoubleSolenoid.Value v) {
		if (v == EXT) tiltUp = true;
		else if (v == RET) tiltUp = false;
		tilter.set(v);
	}
	
	public boolean isArmClose() {
		return armClose;
	}
	
	public boolean isTiltUp() {
		return tiltUp;
	}
	
	public boolean isLowGear() {
		return lowGear;
	}
	
	/**
	 * Toggles the compressor (ON/OFF)
	 */
//	public void toggleComp() {
//		if (comp.enabled())
//			comp.stop();
//		else
//			comp.start();
//	}
//	
//	public void turnCompOff() {
//		if (comp.enabled())
//			comp.stop();
//	}

	/*******************
	 * DEFAULT METHODS *
	 *******************/
	public void initDefaultCommand() {
		setDefaultCommand(null);
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeroSensors() {
		// TODO Auto-generated method stub
		
	}
}