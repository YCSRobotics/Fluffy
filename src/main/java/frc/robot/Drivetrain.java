/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Handles control of the robot mobility (drivetrain)
 */
public class Drivetrain {
    private WPI_TalonSRX frontTurnMotor = new WPI_TalonSRX(Constants.kFrontLeftMotorPort);
    private WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(Constants.kBackLeftMotorPort);
    private WPI_TalonSRX backRightMotor = new WPI_TalonSRX(Constants.kBackRightMotorPort);
    
    private DifferentialDrive diffyDrive = new DifferentialDrive(backLeftMotor, backRightMotor);

    private double xSpeed;
    private double zRotation;

    public Drivetrain() {
        diffyDrive.setRightSideInverted(true);
    }

    /**
     * Handles periodic control of the drivetrain
     */
    public void drivetrainPeriodic() {
        xSpeed = Constants.driverControl.getRawAxis(Constants.kLeftJoyY);
        zRotation = Constants.driverControl.getRawAxis(Constants.kRightJoyX);

        // no need to apply deadzone, already applied
        diffyDrive.arcadeDrive(xSpeed, zRotation);

        // ignore low joystick turning values to avoid drift
        if (zRotation > Constants.kJoyDeadzone) {
            // enable super rotation
            frontTurnMotor.set(zRotation * Constants.kTurnScalingFactor);
        }

        // publish debug information
        SmartDashboard.putNumber("FrontMotor", frontTurnMotor.get());
        SmartDashboard.putNumber("BackLeftMotor", backLeftMotor.get());
        SmartDashboard.putNumber("BackRightMotor", backRightMotor.get());
    }
}
