package main.commands.pneumatics.shift;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;

public class ShiftDown extends ImprovedCommandGroup {
    public ShiftDown() {
    	addSequential(new Shift(EXT));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new Shift(OFF));
    }
}
