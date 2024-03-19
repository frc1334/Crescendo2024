// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveIntakeParallel extends ParallelCommandGroup {
  /** Creates a new DriveIntakeParallel. */
  public DriveIntakeParallel() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new TimedTeleopDrive(
      RobotContainer.swerveSubsystem, () -> -0.7, () -> 0, () -> 0, () -> true, 3000),
      new IntakeWait());
  }
}
