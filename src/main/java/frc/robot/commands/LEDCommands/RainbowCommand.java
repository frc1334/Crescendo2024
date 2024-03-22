// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.LEDCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.LEDConstants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class RainbowCommand extends Command {
  long start;
  long duration;
  long currentTime;

  /** Creates a new RainbowCommand. */
  public RainbowCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.ledSubsystem);
    duration = 10000;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    start = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.ledSubsystem.rainbowWave();
    currentTime = System.currentTimeMillis();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.ledSubsystem.ledColour(LEDConstants.RED);
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
