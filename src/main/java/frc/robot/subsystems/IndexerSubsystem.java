// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IndexerConstants;;

public class IndexerSubsystem extends SubsystemBase {

  Spark indexerLeft;
  Spark indexerRight;

  DigitalInput upperSensor;


  /** Creates a new IndexerSubsystem. */
  public IndexerSubsystem() {
    indexerLeft = new Spark(IndexerConstants.INDEXER_MOTOR_LEFT);
    indexerRight = new Spark(IndexerConstants.INDEXER_MOTOR_RIGHT);

    upperSensor = new DigitalInput(IndexerConstants.UPPER_SENSOR);


  }

  public void runIndexer(double speed) {
    indexerLeft.set(speed);
    indexerRight.set(-speed);
  }

  public boolean switchActivated() {
    return !upperSensor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
