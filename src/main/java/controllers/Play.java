
package controllers;

import interfacesAndAbstracts.ImprovedCommand;
import main.Robot;


public class Play extends ImprovedCommand {
	private static boolean finished = false;

	protected void initialize() {
		String line = Robot.lg.readLine();
		if((line) != null) { 
			String[] robotState = line.split(",");
			
			if(robotState.length == 30 && robotState != null) {
				System.out.println("Playing");
				
				double leftDriveVoltage = Double.parseDouble(robotState[0]);
				double rightDriveVoltage = Double.parseDouble(robotState[1]);
				double leftIntakeWheelValue = Double.parseDouble(robotState[2]);
				double rightIntakeWheelValue = Double.parseDouble(robotState[3]);
				
				boolean a = Boolean.parseBoolean(robotState[4]);
				boolean b = Boolean.parseBoolean(robotState[5]);
				boolean x = Boolean.parseBoolean(robotState[6]);
				boolean y = Boolean.parseBoolean(robotState[7]);
				boolean leftBumper = Boolean.parseBoolean(robotState[8]);
				boolean rightBumper = Boolean.parseBoolean(robotState[9]);
				boolean select = Boolean.parseBoolean(robotState[10]);
				boolean start = Boolean.parseBoolean(robotState[11]);
				boolean leftJoystickPress = Boolean.parseBoolean(robotState[12]);
				boolean rightJoystickPress = Boolean.parseBoolean(robotState[13]);
				boolean leftTrigger = Boolean.parseBoolean(robotState[14]);
				boolean rightTrigger = Boolean.parseBoolean(robotState[15]);
				
				boolean a2 = Boolean.parseBoolean(robotState[16]);
				boolean b2 = Boolean.parseBoolean(robotState[17]);
				boolean x2 = Boolean.parseBoolean(robotState[18]);
				boolean y2 = Boolean.parseBoolean(robotState[19]);
				boolean leftBumper2 = Boolean.parseBoolean(robotState[20]);
				boolean rightBumper2 = Boolean.parseBoolean(robotState[21]);
				boolean select2 = Boolean.parseBoolean(robotState[22]);
				boolean start2 = Boolean.parseBoolean(robotState[23]);
				boolean leftJoystickPress2 = Boolean.parseBoolean(robotState[24]);
				boolean rightJoystickPress2 = Boolean.parseBoolean(robotState[25]);
				boolean leftTrigger2 = Boolean.parseBoolean(robotState[26]);
				boolean rightTrigger2 = Boolean.parseBoolean(robotState[27]);
				
				double elevatorDistance = Double.parseDouble(robotState[28]);
				double elevatorVelocity = Double.parseDouble(robotState[29]);
			
//				Command drive = new DriveFromPlayer(leftDriveVoltage, rightDriveVoltage);
//				Command intake = new IntakeFromPlayer(leftIntakeWheelValue, rightIntakeWheelValue);
//				drive.start();
//				intake.start();
				Robot.el.playbackPID(elevatorVelocity, elevatorDistance);
				
				Robot.oi.setButtonValues(a, b, x, y, leftBumper, rightBumper, select, start, leftJoystickPress, rightJoystickPress, leftTrigger, rightTrigger);
				Robot.oi.setButtonValues2(a2, b2, x2, y2, leftBumper2, rightBumper2, select2, start2, leftJoystickPress2, rightJoystickPress2, leftTrigger2, rightTrigger2);
			}
		}
		else {
			finished = true;
			System.out.println("Finished Playing");
		}
	}
	
	protected boolean isFinished() {
		return true;
	}
	
	public static boolean finished() {
		return finished;
	}
	
	public static void reset() {
		finished = false;
	}
	
}

