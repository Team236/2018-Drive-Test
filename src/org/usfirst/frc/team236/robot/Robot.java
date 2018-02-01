/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.AutoDriveTurnDrive;
import org.usfirst.frc.team236.robot.commands.AutoMotnMagic;
import org.usfirst.frc.team236.robot.subsystems.Drive;
import org.usfirst.frc.team236.robot.subsystems.SolenoidTest;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
    // public static final ExampleSubsystem kExampleSubsystem
    // = new ExampleSubsystem();

    Command autonomousCommand;
    SendableChooser<Command> chooser;
    // SendableChooser<Command> chooser = new SendableChooser<>();
    public static OI oi;

    public static Drive drive = new Drive();
    public static SolenoidTest solenoidTest = new SolenoidTest();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

	oi = new OI();
	chooser = new SendableChooser<>();
	chooser.addDefault("Auto Motn Magic Drive Strait ", new AutoMotnMagic(12));
	chooser.addObject("Auto Drive Turn Drive ", new AutoDriveTurnDrive());
	// SmartDashboard.putData("Auto mode chooser:", chooser);
	// chooser.addDefault("Default Auto", new AutoMotnMagic());
	// chooser.addObject("Auto Selection", new AutoDriveStraight());

	SmartDashboard.putNumber("P for turn: ", 0);
	SmartDashboard.putNumber("I for turn: ", 0);
	SmartDashboard.putNumber("D for turn: ", 0);
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
	drive.resetEncoders();
	// SmartDashboard.putData("Auto mode: ", chooser);

    }

    @Override
    public void disabledPeriodic() {
	Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
	drive.resetEncoders();
	drive.navx.reset();

	autonomousCommand = chooser.getSelected();
	// autonomousCommand = new AutoDriveStraight(12);
	// autonomousCommand = new
	// AutoMotnMagic(RobotMap.AutoMap.STRAIGHT_DISTANCE1);
	// autonomousCommand = new Turn(RobotMap.AutoMap.TURN_DEGREES,
	// RobotMap.AutoMap.TURN_MARGIN);
	// autonomousCommand = new AutoDriveTurn();
	// autonomousCommand = new AutoDriveTurnDrive();

	// schedule the autonomous command (example)
	// if (autonomousCommand != null) {
	autonomousCommand.start();
	// }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
	Scheduler.getInstance().run();

	SmartDashboard.putNumber("left Encoder value: ",
		drive.leftFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
	SmartDashboard.putNumber("Right Encoder value: ",
		drive.rightFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
	SmartDashboard.putNumber("Left speed: ", drive.leftFrontMaster.getSelectedSensorVelocity(0));
	SmartDashboard.putNumber("Right speed: ", drive.rightFrontMaster.getSelectedSensorVelocity(0));
	SmartDashboard.putNumber("gyroangle", drive.navx.getAngle());
    }

    @Override
    public void teleopInit() {
	drive.resetEncoders();
	drive.navx.reset();
	// This makes sure that the autonomous stops running when
	// teleop starts running. If you want the autonomous to
	// continue until interrupted by another command, remove
	// this line or comment it out.
	// if (m_autonomousCommand != null) {
	// m_autonomousCommand.cancel();
	// }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
	Scheduler.getInstance().run();

	SmartDashboard.putNumber("left Encoder value: ",
		drive.leftFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
	SmartDashboard.putNumber("Right Encoder value: ",
		drive.rightFrontMaster.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE);
	SmartDashboard.putNumber("Left speed: ", drive.leftFrontMaster.getSelectedSensorVelocity(0));
	SmartDashboard.putNumber("Right speed: ", drive.rightFrontMaster.getSelectedSensorVelocity(0));
	SmartDashboard.putNumber("gyroangle", drive.navx.getAngle());
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
