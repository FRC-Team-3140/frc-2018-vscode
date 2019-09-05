package main.commands.pneumatics.arm;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;

public class ArmOpen extends ImprovedCommandGroup {
    // Called just before this Command runs the first time
    public ArmOpen() {
    	addSequential(new Arm(RET));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new Arm(OFF));
    }
}