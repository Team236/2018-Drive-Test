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
	rightRearSlave.set(ControlMode.Follower, rightFrontMaster.getDeviceID());

	// Set "true" if needed to make the encoder reading positive when
	// TalonSRX is blinking green
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
	rightFrontMaster.set(ControlMode.Position, -distance);
    }

    public void setRightDistMotion(double distance) {
	rightFrontMaster.set(ControlMode.MotionMagic, -distance);
    }

    public void setLeftDistMotion(double distance) {
	leftFrontMaster.set(ControlMode.MotionMagic, distance);
    }

    // PID for Position Control (AutoDriveStraight):
    public void setkP(double kP) {
	rightFrontMaster.config_kP(0, kP, 0);
	leftFrontMaster.config_kP(0, kP, 0);
    }

    public void setkI(double kI) {
	rightFrontMaster.config_kI(0, kI, 0);
	leftFrontMaster.config_kI(0, kI, 0);
    }

    public void setkD(double kD) {
	rightFrontMaster.config_kD(0, kD, 0);
	leftFrontMaster.config_kD(0, kD, 0);
    }

    // PID, F, Cruise Vel and Accel
    // for Motion Magic Position Control (AutoMotionMagic):

    public void setkPMM(double MMkP) {
	rightFrontMaster.config_kP(0, MMkP, 0);
	leftFrontMaster.config_kP(0, MMkP, 0);
    }

    public void setkIMM(double MMkI) {
	rightFrontMaster.config_kI(0, MMkI, 0);
	leftFrontMaster.config_kI(0, MMkI, 0);
    }

    public void setkDMM(double MMkD) {
	rightFrontMaster.config_kD(0, MMkD, 0);
	leftFrontMaster.config_kD(0, MMkD, 0);
    }

    public void setkFMM(double MMkF) {
	rightFrontMaster.config_kD(0, MMkF, 0);
	leftFrontMaster.config_kD(0, MMkF, 0);
    }

    public void setMotnCV(int vcruise) {
	rightFrontMaster.configMotionCruiseVelocity(vcruise, 0);
	leftFrontMaster.configMotionCruiseVelocity(vcruise, 0);
    }

    public void setMotnAccel(int accel) {
	rightFrontMaster.configMotionAcceleration(accel, 0);
	leftFrontMaster.configMotionAcceleration(accel, 0);
    }

    public void resetEncoders() {
	leftFrontMaster.setSelectedSensorPosition(0, 0, 0);
	rightFrontMaster.setSelectedSensorPosition(0, 0, 0);
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
    // public double getRightSpeed() {
    // return rightFrontMaster.getSelectedSensorVelocity(0);
    // }

    /// public void setPID , Insert this method in hard code after getting it
    /// right in roborio-236-frc.local

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
	setDefaultCommand(new DriveWithJoysticks());

	// Set the default command for a subsystem here.
	// setDefaultCommand(new MySpecialCommand());
    }
}
