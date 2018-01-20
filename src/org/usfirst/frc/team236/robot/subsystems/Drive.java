package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {

	
	public TalonSRX leftFrontMaster, leftRearSlave;
	public TalonSRX rightFrontMaster, rightRearSlave;
	
	public AHRS navx;
	
	public Drive() {

		leftFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_LEFT_FRONT);
		rightFrontMaster = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_FRONT);
		leftRearSlave = new TalonSRX(RobotMap.DriveMap.ID_LEFT_REAR);
		rightRearSlave = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_REAR);
		
		navx = new AHRS(SPI.Port.kMXP);
		
		leftRearSlave.set(ControlMode.Follower, leftFrontMaster.getDeviceID());
		rightRearSlave.set(ControlMode.Follower,rightFrontMaster.getDeviceID());
		
    //Set "true" if needed to make the encoder reading positive when TalonSRX is blinking green	
		leftFrontMaster.setSensorPhase(true);
		rightFrontMaster.setSensorPhase(true);		
	}
	
	public void setLeftSpeed(double speed) {
	leftFrontMaster.set(ControlMode.PercentOutput, speed);
	}
	public void setRightSpeed(double speed) {
	rightFrontMaster.set(ControlMode.PercentOutput, -speed);
	}
	public void setLeftDistance(double distance) {
		leftFrontMaster.set(ControlMode.Position, distance);
	}
	public void setRightDistance(double distance) {
		rightFrontMaster.set(ControlMode.Position,-distance);
	}
	public void setRightDistMotion(double distance) {
		rightFrontMaster.set(ControlMode.MotionMagic,-distance);
	}
		public void setLeftDistMotion(double distance) {
			rightFrontMaster.set(ControlMode.MotionMagic,distance);
	}
		public void setMotnCV(int vcruise) {
			rightFrontMaster.configMotionCruiseVelocity(vcruise, 0);
			leftFrontMaster.configMotionCruiseVelocity(vcruise, 0);
	}
		public void  setMotnAccel(int accel) {
			rightFrontMaster.configMotionAcceleration(accel, 0);
			leftFrontMaster.configMotionAcceleration(accel, 0);
		}
	
	public void resetEncoders() {
		leftFrontMaster.setSelectedSensorPosition(0,0,0);
		rightFrontMaster.setSelectedSensorPosition(0,0,0);
	}
	public int getLeftDistance() {
	return leftFrontMaster.getSensorCollection().getQuadraturePosition();
	} 
	public int getRightDistance() {	
	  return rightFrontMaster.getSensorCollection().getQuadraturePosition();
	}
	
	public double getLeftSpeed() {
		return leftFrontMaster.getSelectedSensorVelocity(0);
	}
	//public double getRightSpeed() {	
	//	return rightFrontMaster.getSelectedSensorVelocity(0);
	//		}
	
	///public void setPID , Insert this method in hard code after getting it right in roborio-236-frc.local

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

