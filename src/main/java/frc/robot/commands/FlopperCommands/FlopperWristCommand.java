// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.FlopperCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class FlopperWristCommand extends Command {
  double speed;
  double setpoint;
  /** Creates a new FlopperWristCommand. */
  public FlopperWristCommand(double speed, double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.flopperWrist);
    this.speed = speed;
    this.setpoint = setpoint;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if (RobotContainer.flopperWrist.wristEncoderPosition() > setpoint) {
    //   speed = -speed;
    // }
    // SmartDashboard.putNumber("wrist position", RobotContainer.flopperWrist.wristEncoderPosition());
    // SmartDashboard.putNumber("wrist speed", speed);
    RobotContainer.flopperWrist.runFlopperWrist(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.flopperWrist.runFlopperWrist(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.flopperWrist.wristEncoderLimitReached(setpoint);
  }
}
