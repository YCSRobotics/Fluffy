/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;

/**
 * Handles motion of the "camera" turret
 */
public class CameraTurret {
    private Servo horizontalServo = new Servo(0);
    private Servo verticalServo = new Servo(1);

    public void turretPeriodic() {
        double targetCenterX = NetworkTableInstance.getDefault().getTable("TurretVision").getEntry("targetCenterX").getDouble(0);
        double targetCenterY = NetworkTableInstance.getDefault().getTable("TurretVision").getEntry("targetCenterY").getDouble(0);

        // map from our camera width value to -1 to 1
        double mappedCenterX = targetCenterX / Constants.kCameraWidth;
        double mappedCenterY = targetCenterY / Constants.kCameraHeight;

        double errPosX = mappedCenterX + Constants.kTurretError;
        double errMinX = mappedCenterX - Constants.kTurretError;

        double errPosY = mappedCenterY + Constants.kTurretError;
        double errMinY = mappedCenterY - Constants.kTurretError;

        // bang bang position control is more than enough since we're using servo's to control
        // rotation and position, they have integrated PID
        // PID control will be probably needed if using encoders and a motor
        if (horizontalServo.get() > errPosX || horizontalServo.get() < errMinX) {
            horizontalServo.set(mappedCenterX);
        }

        if (verticalServo.get() > errPosY || verticalServo.get() < errMinY) {
            verticalServo.set(mappedCenterY);
        }
    }
}
