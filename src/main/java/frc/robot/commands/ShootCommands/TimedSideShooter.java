// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShootCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Constants.RobotConstants;

public class TimedSideShooter extends Command {
  long start;
  long duration;
  long currentTime;

  double leftSpeed;
  double rightSpeed;
  /** Creates a new SideShoot. */
  public TimedSideShooter(double leftSpeed, double rightSpeed, long duration) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooterSubsystem);
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
    this.duration = duration;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    start = System.currentTimeMillis();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.shooterSubsystem.runLeft(leftSpeed);
    RobotContainer.shooterSubsystem.runRight(rightSpeed);

    currentTime = System.currentTimeMillis();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.shooterSubsystem.runLeft(0);
    RobotContainer.shooterSubsystem.runRight(0);
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
