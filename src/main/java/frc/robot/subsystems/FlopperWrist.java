// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlopperConstants;

public class FlopperWrist extends SubsystemBase {

    CANSparkMax wrist;
    RelativeEncoder wristEncoder;

  /** Creates a new FlopperWrist. */
  public FlopperWrist() {

    wrist = new CANSparkMax(FlopperConstants.FLOPPER_WRIST, MotorType.kBrushless);
    wristEncoder = wrist.getEncoder();
    wristEncoder.setPosition(0);
  }


  public void runFlopperWrist(double speed) {
    wrist.set(speed);
  }

  public double wristEncoderPosition() {
    return wristEncoder.getPosition();
  }

  public boolean wristEncoderLimitReached(double setpoint) {
    double encoderPosition = wristEncoder.getPosition();
    double error = Math.abs(encoderPosition - setpoint);

    if (error <= 0.5) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
