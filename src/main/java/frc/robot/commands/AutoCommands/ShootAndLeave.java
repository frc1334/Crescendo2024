// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands.AutoCommands;

// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// // NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// // information, see:
// // https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
// public class ShootAndLeave extends SequentialCommandGroup {
//   /** Creates a new ShootAndLeave. */
//   public ShootAndLeave() {
//     // Add your commands in the addCommands() call, e.g.
//     // addCommands(new FooCommand(), new BarCommand());
//     addCommands(new TimedShooter(0.8, 700), new SpeakerShoot(), 
//       new DriveIntakeParallel(-0.7, RobotContainer.cameraSubsystem.getTurnSpeed(), 3000),
//       new TimedTeleopDrive(
//         RobotContainer.swerveSubsystem, () -> 0.7, () -> 0, () -> RobotContainer.limelightSubsystem.getSteer(), 
//         () -> true, 3200),
//   }
// }