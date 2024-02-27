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

  Spark indexerMotor;

  DigitalInput proximitySwitch;


  /** Creates a new IndexerSubsystem. */
  public IndexerSubsystem() {
    indexerMotor = new Spark(IndexerConstants.INDEXER_MOTOR);

    proximitySwitch = new DigitalInput(Constants.OtherConstants.PROXIMITY_PORT);


  }

  public void runIndexer(double speed) {
    indexerMotor.set(-speed);
  }

  public boolean switchActivated() {
    return !proximitySwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
