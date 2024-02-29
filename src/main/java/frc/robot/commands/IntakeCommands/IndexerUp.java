// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.LEDConstants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class IndexerUp extends Command {
  double speed;
  /** Creates a new IndexerCommand. */
  public IndexerUp(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.indexerSubsystem);
    addRequirements(RobotContainer.ledSubsystem);

    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.indexerSubsystem.runIndexer(speed);
    // RobotContainer.ledSubsystem.ledColour(LEDConstants.YELLOW);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.indexerSubsystem.runIndexer(0);
    // RobotContainer.ledSubsystem.ledColour(LEDConstants.WHITE);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
