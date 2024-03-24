// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.LEDCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ColourCommand extends InstantCommand {
  int colour;

  /** Creates a new ColourCommand. */
  public ColourCommand(int colour) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.ledSubsystem);

    this.colour = colour;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.ledSubsystem.ledColour(colour);
  }
}
