// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlopperConstants;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class FlopperArm extends SubsystemBase {

  CANSparkMax arm;
  RelativeEncoder armEncoder;

  /** Creates a new IntakeSubsystem. */
  public FlopperArm() {
    arm = new CANSparkMax(FlopperConstants.FLOPPER_ARM, MotorType.kBrushless);
    armEncoder = arm.getEncoder();
    armEncoder.setPosition(0);
  }

  public void runFlopperArm(double speed) {
    arm.set(speed);
  }

  public double armEncoderPosition() {
    return armEncoder.getPosition();
  }

  public boolean armEncoderLimitReached(double setpoint) {
    double encoderPosition = armEncoder.getPosition();
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
