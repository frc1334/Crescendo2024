// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ShooterSubsystem extends SubsystemBase {
  Spark shooterLeft;
  Spark shooterRight;

  /** Creates a new LauncherSubsystem. */
  public ShooterSubsystem() {
    shooterLeft = new Spark(ShooterConstants.SHOOTER_MOTOR_LEFT);
    shooterRight = new Spark(ShooterConstants.SHOOTER_MOTOR_RIGHT);
  }

  public void runShooter(double speed) {
    shooterLeft.set(-speed);
    shooterRight.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
