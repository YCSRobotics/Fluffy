/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Only variables that are "constant" should be placed here
 * They should be in hungarian notation (aka kConstant)
 */
public class Constants {
    // motor constants
    public static final int kFrontLeftMotorPort = 0;
    public static final int kBackLeftMotorPort = 1;
    public static final int kBackRightMotorPort = 2;

    // joystick constants
    public static final Joystick driverControl = new Joystick(0);
    public static final int kLeftJoyY = 1;
    public static final int kRightJoyX = 4;
    public static final int kBumperLeft = 5;
    public static final int kBumperRight = 6;
    public static final int kA = 1;
    public static final int kB = 2;
    public static final int kX = 3;
    public static final int kY = 4;
    public static final int kBack = 7;
    public static final int kStart = 8;
    public static final double kJoyDeadzone = 0.2;

    // scaling factors
    public static final double kTurnScalingFactor = 0.3;

    // camera constants
    public static final int kCameraWidth = 320;
    public static final int kCameraHeight = 240;

    public static final double kTurretError = 0.1;
}
