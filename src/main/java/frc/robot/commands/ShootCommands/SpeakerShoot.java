// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShootCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants.LEDConstants;
import frc.robot.commands.IntakeCommands.TimedIndexer;
import frc.robot.commands.LEDCommands.ColourCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SpeakerShoot extends ParallelCommandGroup {
  /** Creates a new SpeakerShoot. */
  public SpeakerShoot() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new TimedShooter(0.8, 700), new TimedIndexer(0.8, 700),
    new ColourCommand(LEDConstants.RED));
  }
}
