// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.FlopperCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Constants.LEDConstants;

public class FlopperArmCommand extends Command {
  double speed;
  double setpoint;

  /** Creates a new IntakeOutCommand. */
  public FlopperArmCommand(double speed, double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.flopperArm);
    this.speed = speed;
    this.setpoint = setpoint;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.flopperArm.runFlopperArm(speed);
    RobotContainer.ledSubsystem.ledColour(LEDConstants.BLUE);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.flopperArm.runFlopperArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.flopperArm.encoderLimitReached(setpoint);
  }
}
