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
  RelativeEncoder encoder;

  /** Creates a new IntakeSubsystem. */
  public FlopperArm() {
    arm = new CANSparkMax(FlopperConstants.FLOPPER_ARM, MotorType.kBrushless);
    encoder = arm.getEncoder();
    encoder.setPosition(0);
  }

  public void runFlopperArm(double speed) {
    arm.set(speed);
  }

  public boolean encoderLimitReached(double setpoint) {
    double encoderPosition = encoder.getPosition();
    double error = Math.abs(encoderPosition - setpoint);

    if (error <= 0.05) {
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
