package org.usfirst.frc.team236.robot.subsystems;

import java.util.ResourceBundle.Control;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

	
	TalonSRX leftFrontMaster, leftRearSlave;
	TalonSRX rightFrontMaster, rightRearSlave;
	
	public Drive() {

		leftFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_LEFT_FRONT);
		rightFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_FRONT);
		leftRearSlave = new TalonSRX(RobotMap.DriveMap.ID_LEFT_REAR);
		rightRearSlave = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_REAR);
		
		leftRearSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
		rightRearSlave.set(ControlMode.Follower,rightFrontMaster.getDeviceID());
	}
	
	public void setLeftSpeed(double speed) {
	leftFrontMaster.set(ControlMode.PercentOutput, speed);
	}
	public void setRightSpeed(double speed) {
	rightFrontMaster.set(ControlMode.PercentOutput, -speed);
	}
	
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

