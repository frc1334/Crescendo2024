// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LauncherConstants;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class LauncherSubsystem extends SubsystemBase {
  Spark launcherLeft;
  Spark launcherRight;

  /** Creates a new LauncherSubsystem. */
  public LauncherSubsystem() {
    launcherLeft = new Spark(LauncherConstants.LAUNCHER_MOTOR_LEFT);
    launcherRight = new Spark(LauncherConstants.LAUNCHER_MOTOR_RIGHT);
  }

  public void runLauncher(double speed) {
    launcherLeft.set(-speed);
    launcherRight.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
