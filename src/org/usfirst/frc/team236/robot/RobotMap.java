/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.pid.PIDParameters;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static class DriveMap {
	public static final int ID_LEFT_FRONT = 8;
	public static final int ID_RIGHT_FRONT = 7;
	public static final int ID_LEFT_REAR = 5;
	public static final int ID_RIGHT_REAR = 6;

	// public static final int ID_LEFT_FRONT = 1;
	// public static final int ID_RIGHT_FRONT = 2;
	// public static final int ID_LEFT_REAR = 3;
	// public static final int ID_RIGHT_REAR = 4;

	public static final double DIAMETER = 3.92;
	public static final double CIRCUMFERENCE = DIAMETER * Math.PI;
	public static final double PULSE_PER_ROTATION = 512;
	public static final double DISTANCE_PER_PULSE = CIRCUMFERENCE / PULSE_PER_ROTATION;

	public static final double POS_K_P = 3;
	public static final double POS_K_I = .001;
	public static final double POS_K_D = 0;

	// public static final double M_MAGIC_K_P = .1;
	// public static final double M_MAGIC_K_I = 0;
	// public static final double M_MAGIC_K_D = 0;
	// public static final double M_MAGIC_K_F = 4.65;

	public static final int M_MAGIC_CV = 1280;
	public static final int M_MAGIC_ACCL = 2560;
    }

    public static class JoystickMap {
	public static final int LEFT_PORT = 0;
	public static final int RIGHT_PORT = 1;
    }

    public static class SetSolMap {
	public static final int SOL_FWD = 6;
	public static final int SOL_REV = 7;

    }

    public static class AutoMap {
	public static final double STRAIGHT_DISTANCE1 = 60;
	public static final double STRAIGHT_DISTANCE2 = 60;

	public static final double TURN_DEGREES = 90;
	public static final double TURN_DEGREES2 = -90;
	public static final double TURN_MARGIN = 5.0;
	public static final double MTN_MAG_END_MARGIN = 6;

	// public static final PIDParameters TURN_PARAMS = new
	// PIDParameters(0.010, 0.005, -0.004, 1 / 100.0);
	// For 90 degree turn P = 0.0147, D = -0.001
	// For Motion Magic F = 0.8, P = 0.09
	public static final double P_TURN = SmartDashboard.getNumber("P for turn is: ", 0);
	public static final double I_TURN = SmartDashboard.getNumber("I for turn is: ", 0);
	public static final double D_TURN = SmartDashboard.getNumber("D for turn is: ", 0);
	public static final PIDParameters TURN_PARAMS = new PIDParameters(P_TURN, I_TURN, D_TURN, 1 / 100.0);
	// public static final PIDParameters TURN_PARAMS = new
	// PIDParameters(0.0147, 0.00, -0.001, 1 / 100.0);

    }
}
