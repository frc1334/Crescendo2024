// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TimedClimb extends Command {
  long start;
  long duration;
  double leftSpeed;
  double rightSpeed;
  long currentTime;

  /** Creates a new TimedClimb. */
  public TimedClimb(double leftSpeed, double rightSpeed, long duration) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.climberSubsystem);
    this.duration = duration;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    start = System.currentTimeMillis();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.climberSubsystem.runClimberLeft(leftSpeed);
    RobotContainer.climberSubsystem.runClimberRight(rightSpeed);
    currentTime = System.currentTimeMillis();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.climberSubsystem.runClimberLeft(0);
    RobotContainer.climberSubsystem.runClimberRight(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (start + duration <= currentTime) {
      return true;
    }
    return false;
  }
}
