package interfacesAndAbstracts;

import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;

public abstract class ImprovedSubsystem extends Subsystem implements Constants, HardwareAdapter {
	public abstract void check();
	public abstract void zeroSensors();
}
