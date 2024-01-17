// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LauncherConstants;

import com.ctre.phoenix6.hardware.TalonFX;

public class LauncherSubsystem extends SubsystemBase {
  TalonFX launcherLeft;
  TalonFX launcherRight;
  /** Creates a new LauncherSubsystem. */
  public LauncherSubsystem() {
    launcherLeft = new TalonFX(LauncherConstants.LAUNCHER_MOTOR_LEFT);
    launcherRight = new TalonFX(LauncherConstants.LAUNCHER_MOTOR_RIGHT);
  }

  public void runLauncher(double speed) {
    launcherLeft.set(speed);
    launcherRight.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
