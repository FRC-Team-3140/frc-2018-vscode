package main.commands.altermativeAuto;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;
import main.commands.drivetrain.TurnToAngle;
import main.commands.elevator.MoveToBottom;
import main.commands.elevator.MoveToTop;
import main.commands.pneumatics.arm.ArmClose;
import main.commands.pneumatics.arm.ArmOpen;
import main.commands.pneumatics.tilt.TiltDown;
import main.commands.pneumatics.tilt.TiltUp;

public class AltRightToLeftSwitch extends ImprovedCommandGroup {
	public AltRightToLeftSwitch() {
		// distance from start to scale  minus robot length
//		addSequential(new DistanceDriveStraight(222));
		addSequential(new TurnToAngle(-83));
		addSequential(new WaitCommand(0.25));
//		addSequential(new DistanceDriveStraight(175));
		addSequential(new TurnToAngle(-85));
		addSequential(new MoveToTop(3));
//		addSequential(new DistanceDriveStraight(25));
		addSequential(new WaitCommand(0.3));
		addSequential(new TiltDown());
		addSequential(new ArmOpen());
		addSequential(new WaitCommand(0.5));
		addSequential(new TiltUp());
		addSequential(new ArmClose());
		addSequential(new WaitCommand(0.3));
//		addSequential(new DistanceDriveStraight(-25));
		addSequential(new MoveToBottom(3));
		//addSequential(new DropCube());
		//addSequential(new WaitCommand(1));
		//addSequential(new DropCubeOff());	
	}
}