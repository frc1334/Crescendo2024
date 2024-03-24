// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.ShootCommands.SideSpeakerShoot;
import frc.robot.commands.ShootCommands.SpeakerShoot;
import frc.robot.commands.ShootCommands.TimedShooter;
import frc.robot.commands.ShootCommands.TimedSideShooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LeftAutoFinal extends SequentialCommandGroup {
  /** Creates a new LeftAutoFinal. */
  public LeftAutoFinal() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new TimedSideShooter(0.9, 0.7, 1000), 
      new SideSpeakerShoot(0.9, 0.7), 
      new DriveIntakeParallel(-0.7, RobotContainer.cameraSubsystem.getTurnSpeed(), 3200),
      new TimedTeleopDrive(
        RobotContainer.swerveSubsystem, () -> 0.7, () -> 0, () -> RobotContainer.limelightSubsystem.getSteer(), 
        () -> true, 3300),
      new TimedSideShooter(0.9, 0.7, 1000), new SideSpeakerShoot(0.9, 0.7)
      );
  }
}
