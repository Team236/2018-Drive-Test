package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveTurnDrive extends CommandGroup {

    public AutoDriveTurnDrive() {

	addSequential(new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE1));

	addSequential(new Turn(RobotMap.AutoMap.TURN_DEGREES, RobotMap.AutoMap.TURN_MARGIN));

	addSequential(new AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE2));

	addSequential(new Turn(RobotMap.AutoMap.TURN_DEGREES, RobotMap.AutoMap.TURN_MARGIN));

	// Add Commands here:
	// e.g. addSequential(new Command1());
	// addSequential(new Command2());
	// these will run in order.

	// To run multiple commands at the same time,
	// use addParallel()
	// e.g. addParallel(new Command1());
	// addSequential(new Command2());
	// Command1 and Command2 will run in parallel.

	// A command group will require all of the subsystems that each member
	// would require.
	// e.g. if Command1 requires chassis, and Command2 requires arm,
	// a CommandGroup containing them would require both the chassis and the
	// arm.
    }
}
