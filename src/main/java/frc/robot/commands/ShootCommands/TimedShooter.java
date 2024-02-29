// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShootCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class TimedShooter extends Command {
  long start;
  long duration;
  double speed;
  long currentTime;
  
  /** Creates a new TimedIndexer. */
  public TimedShooter(double speed, long duration) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooterSubsystem);
    this.duration = duration;
    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    start = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.shooterSubsystem.runShooter(speed);
    currentTime = System.currentTimeMillis();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.shooterSubsystem.runShooter(0);

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
