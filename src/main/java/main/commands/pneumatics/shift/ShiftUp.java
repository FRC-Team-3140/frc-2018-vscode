package main.commands.pneumatics.shift;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;

public class ShiftUp extends ImprovedCommandGroup {
    public ShiftUp() {
    	addSequential(new Shift(RET));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new Shift(OFF));
    }
}
