package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoMotnMagic extends Command {

    private double distance;
    private double error;

    public AutoMotnMagic(double _distance) {
	requires(Robot.drive);

	this.distance = _distance;

	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

	Robot.drive.resetEncoders();

	Robot.drive.setMotnCV(RobotMap.DriveMap.M_MAGIC_CV);
	Robot.drive.setMotnAccel(RobotMap.DriveMap.M_MAGIC_ACCL);

	// Robot.drive.setkPMM(RobotMap.DriveMap.M_MAGIC_K_P);
	// Robot.drive.setkIMM(RobotMap.DriveMap.M_MAGIC_K_I);
	// Robot.drive.setkDMM(RobotMap.DriveMap.M_MAGIC_K_D);
	// Robot.drive.setkFMM(RobotMap.DriveMap.M_MAGIC_K_F);

	Robot.drive.setRightDistMotion(distance / RobotMap.DriveMap.DISTANCE_PER_PULSE);
	Robot.drive.setLeftDistMotion(distance / RobotMap.DriveMap.DISTANCE_PER_PULSE);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	// double currentDistance = -Robot.drive.getLeftDistance() *
	// RobotMap.DriveMap.DISTANCE_PER_PULSE;
	double currentDistance = Robot.drive.getRightDistance() * RobotMap.DriveMap.DISTANCE_PER_PULSE;
	error = Math.abs(distance - currentDistance);
	SmartDashboard.putNumber("currentdistance ", currentDistance);
	// SmartDashboard.putNumber("distance ", distance);
	// SmartDashboard.putNumber("MM Error", error);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

	boolean inSpeedMargin = Robot.drive.getRightSpeed() < 1.0;
	boolean inDistMargin = error < RobotMap.AutoMap.MTN_MAG_END_MARGIN;

	// SmartDashboard.putNumber("Speed", Robot.drive.getRightSpeed());
	// SmartDashboard.putNumber("MM error = ", error);
	return (inSpeedMargin) && (inDistMargin);
    }

    // Called once after isFinished returns true
    protected void end() {
	Robot.drive.stop();
	System.out.println("Motn Magic Is Finished");
	System.out.println(
		"left encoder dist at end:  " + Robot.drive.getLeftEncoder() * RobotMap.DriveMap.DISTANCE_PER_PULSE);
	System.out.println(
		"right encoder dist at end:  " + Robot.drive.getRightEncoder() * RobotMap.DriveMap.DISTANCE_PER_PULSE);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	end();
    }
}
