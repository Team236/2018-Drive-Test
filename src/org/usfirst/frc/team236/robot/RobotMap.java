/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static class DriveMap {
		public static final int ID_LEFT_FRONT = 1;
		public static final int ID_RIGHT_FRONT = 2;
		public static final int ID_LEFT_REAR = 3;
		public static final int ID_RIGHT_REAR = 4;
		
		
		public static final double DIAMETER = 3.92;
		public static final double CIRCUMFERENCE = DIAMETER * Math.PI;
		public static final double PULSE_PER_ROTATION = 512;
		public static final double DISTANCE_PER_PULSE = CIRCUMFERENCE / PULSE_PER_ROTATION;
		
	}
	
	public static class JoystickMap {
		public static final int LEFT_PORT = 0;
		public static final int RIGHT_PORT = 1;
	}
	
     public static class SetSolMap {
    	 public static final int SOL_FWD = 6;
         public static final int SOL_REV = 7;    			 
    	 
     }
	public static class AutoMap{
		public static final double STRAIGHT_DISTANCE = 24;
		
	}
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
