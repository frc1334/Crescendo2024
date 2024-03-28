// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class IntakeSubsystem extends SubsystemBase {

  Spark intakeMotor;
  DigitalInput bottomSensor;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new Spark(IntakeConstants.INTAKE_MOTOR);
    bottomSensor = new DigitalInput(IntakeConstants.BOTTOM_SENSOR);
  }

  public void intakeIn(double speed) {
    intakeMotor.set(speed);
  }

  public boolean sensorActivated() {
    return !bottomSensor.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
