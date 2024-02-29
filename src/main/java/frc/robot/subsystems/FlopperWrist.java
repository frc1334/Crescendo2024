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
    RelativeEncoder encoder;

  /** Creates a new FlopperWrist. */
  public FlopperWrist() {

    wrist = new CANSparkMax(FlopperConstants.FLOPPER_WRIST, MotorType.kBrushless);
    encoder = wrist.getEncoder();
    encoder.setPosition(0);
  }


  public void runFlopperWrist(double speed) {
    wrist.set(speed);
  }

  public boolean encoderLimitReached(double setpoint) {
    double encoderPosition = encoder.getPosition();
    double error = Math.abs(encoderPosition - setpoint);

    if (error <= 0.1) {
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
