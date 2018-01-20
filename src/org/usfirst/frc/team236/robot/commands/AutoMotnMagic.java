package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoMotnMagic extends Command {

    public AutoMotnMagic() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.setMotnCV(200);
    	Robot.drive.setMotnAccel(200);
    	Robot.drive.setRightDistMotion(RobotMap.AutoMap.STRAIGHT_DISTANCE / RobotMap.DriveMap.DISTANCE_PER_PULSE);
		Robot.drive.setLeftDistMotion(RobotMap.AutoMap.STRAIGHT_DISTANCE / RobotMap.DriveMap.DISTANCE_PER_PULSE);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
