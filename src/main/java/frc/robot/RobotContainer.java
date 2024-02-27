// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.FlopperArm;
import frc.robot.subsystems.FlopperWrist;
import frc.robot.commands.FlopperArmCommand;
import frc.robot.commands.FlopperWristCommand;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.IndexerUp;
import frc.robot.commands.IntakeAll;
import frc.robot.commands.LauncherCommand;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.IntakeCommands.IntakeInCommand;
import frc.robot.commands.LEDCommands.RainbowCommand;
import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.LauncherConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.IntakeSubsystem;



/** Add your docs here. */
public class RobotContainer {

    public static SwerveSubsystem swerveSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                            "swerve"));

    public static LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
    public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    public static FlopperArm flopperArm = new FlopperArm();
    public static FlopperWrist flopperWrist = new FlopperWrist();

    public static IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
    public static LEDSubsystem ledSubsystem = new LEDSubsystem();

    // driver xbox
    XboxController driverController = new XboxController(0);

    JoystickButton driverA = new JoystickButton(driverController, 1);
    JoystickButton driverB = new JoystickButton(driverController, 2);
    JoystickButton driverX = new JoystickButton(driverController, 3);
    JoystickButton driverY = new JoystickButton(driverController, 4);
    JoystickButton driverLeftBumper = new JoystickButton(driverController, 5);
    JoystickButton driverRightBumper = new JoystickButton(driverController, 6);

    // operator xbox
    XboxController operatorController = new XboxController(1);

    JoystickButton operatorA = new JoystickButton(operatorController, 1);
    JoystickButton operatorB = new JoystickButton(operatorController, 2);
    JoystickButton operatorX = new JoystickButton(operatorController, 3);
    JoystickButton operatorY = new JoystickButton(operatorController, 4);
    JoystickButton operatorLeftBumper = new JoystickButton(operatorController, 5);
    JoystickButton operatorRightBumper = new JoystickButton(operatorController, 6);


    public RobotContainer() {
        configureBindings();

        TeleopDrive xBoxTeleopDrive = new TeleopDrive(
            swerveSubsystem,
            () -> MathUtil.applyDeadband(-driverController.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
            () -> MathUtil.applyDeadband(-driverController.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
            () -> -driverController.getRightX(), () -> true);

        swerveSubsystem.setDefaultCommand(xBoxTeleopDrive);

        
    }

    private void configureBindings() {

        operatorA.whileTrue(new FlopperArmCommand(0.1));
        operatorB.whileTrue(new FlopperArmCommand(-0.1));

        operatorLeftBumper.whileTrue(new FlopperWristCommand(0.1));
        operatorRightBumper.whileTrue(new FlopperWristCommand(-0.1));


        // // intake
        // operatorB.whileTrue(
        //     new IntakeInCommand(0.6));


        // // indexer
        operatorX.whileTrue(
            new IndexerUp(0.3));
        
        operatorY.whileTrue(
            new LauncherCommand(0.1));

        // operatorY.whileTrue(
        //     new IntakeAll());


        // operatorLeftBumper.whileTrue(
        //     new FlopperArmCommand(0.9));

        

        // // launcher
        // operatorA.whileTrue(
        //     new LauncherCommand(0.1));
        

        // // indexer
        // operatorX.whileTrue(
        //     new IndexerCommand(IndexerConstants.INDEXER_FORWARD_SPEED));

        // operatorY.whileTrue(
        //     new IndexerCommand(IndexerConstants.INDEXER_REVERSE_SPEED));

    }
    
}
