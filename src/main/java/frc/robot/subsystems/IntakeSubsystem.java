// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkLowLevel.MotorType;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.IntakeConstants;

// public class IntakeSubsystem extends SubsystemBase {

//   CANSparkMax intakeMotor;

//   /** Creates a new IntakeSubsystem. */
//   public IntakeSubsystem() {
//     intakeMotor = new CANSparkMax(IntakeConstants.INTAKE_MOTOR, MotorType.kBrushless);
//   }

//   public void intakeIn(double speed) {
//     intakeMotor.set(speed);
//   }

//   public void intakeOut(double speed) {
//     intakeMotor.set(speed);
//   }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//   }
// }
