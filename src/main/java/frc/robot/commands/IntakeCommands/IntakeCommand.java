// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.LEDConstants;
import frc.robot.commands.LEDCommands.ColourCommand;
import frc.robot.RobotContainer;

public class IntakeCommand extends Command {
  double speed;
  /** Creates a new IntakeInCommand. */
  public IntakeCommand(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.intakeSubsystem);

    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.intakeSubsystem.intakeIn(speed);
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.intakeSubsystem.intakeIn(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
