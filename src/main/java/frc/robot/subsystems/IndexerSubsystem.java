// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IndexerConstants;;

public class IndexerSubsystem extends SubsystemBase {

  TalonFX indexerLeft;
  TalonFX indexerRight;
  /** Creates a new IndexerSubsystem. */
  public IndexerSubsystem() {
    indexerLeft = new TalonFX(IndexerConstants.INDEXER_MOTOR_LEFT);
    indexerRight = new TalonFX(IndexerConstants.INDEXER_MOTOR_RIGHT);

  }

  public void runIndexer(double speed) {
    indexerLeft.set(speed);
    indexerRight.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
