// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.FlopperCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class TimedFlopperWrist extends Command {
  long start;
  long duration;
  double speed;

  /** Creates a new TimedFlopperWrist. */
  public TimedFlopperWrist(double speed, long duration) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.flopperWrist);
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
    return (System.currentTimeMillis() >= (start + duration));
  }
}
