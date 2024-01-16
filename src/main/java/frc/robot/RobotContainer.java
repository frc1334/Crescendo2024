// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.LauncherCommand;
// import frc.robot.commands.IntakeCommands.IntakeInCommand;
import frc.robot.commands.LEDCommands.RainbowCommand;
import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.LauncherConstants;;



/** Add your docs here. */
public class RobotContainer {

    XboxController driverController = new XboxController(0);

    public static LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
    // public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    public static IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
    public static LEDSubsystem ledSubsystem = new LEDSubsystem();
    

    public RobotContainer() {
        configureBindings();

        
    }

    private void configureBindings() {
        // intake
        // new JoystickButton(driverController, 2).whileTrue(
        //     new IntakeInCommand(IntakeConstants.INTAKE_SPEED));

        

        // launcher
        new JoystickButton(driverController, 1).whileTrue(
            new LauncherCommand(LauncherConstants.LAUNCHER_SPEED_HIGH));
        

        // indexer
        new JoystickButton(driverController, 3).whileTrue(
            new IndexerCommand(IndexerConstants.INDEXER_SPEED));

    }
    
}
