package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SolenoidTest extends Subsystem {
	private DoubleSolenoid testSolenoid;
	
	public SolenoidTest() {
	testSolenoid = new DoubleSolenoid(RobotMap.SetSolMap.SOL_FWD, RobotMap.SetSolMap.SOL_REV);
	}
	
	public void setFwd() {
		testSolenoid.set(Value.kForward);
	}
	
	public void setRev() {
		testSolenoid.set(Value.kReverse);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

