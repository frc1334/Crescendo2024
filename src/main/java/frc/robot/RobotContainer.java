// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import com.fasterxml.jackson.databind.util.Named;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.FlopperArm;
import frc.robot.subsystems.FlopperWrist;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.AbsoluteDrive;
import frc.robot.commands.DriveToTag;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TimedClimb;
import frc.robot.commands.AutoCommands.DelayShoot;
import frc.robot.commands.AutoCommands.LeftAmpSide;
import frc.robot.commands.AutoCommands.LeftDelayShoot;
import frc.robot.commands.AutoCommands.LeftShootAndLeave;
import frc.robot.commands.AutoCommands.MiddleTwoPiece;
import frc.robot.commands.AutoCommands.RightAmpSide;
import frc.robot.commands.AutoCommands.RightShootAndLeave;
import frc.robot.commands.AutoCommands.TimedTeleopDrive;
import frc.robot.commands.FlopperCommands.FlopperArmCommand;
import frc.robot.commands.FlopperCommands.FlopperZero;
// import frc.robot.commands.FlopperCommands.FlopperShoot;
import frc.robot.commands.FlopperCommands.FlopperWristCommand;
import frc.robot.commands.IntakeCommands.IndexerCommand;
import frc.robot.commands.IntakeCommands.IndexerUp;
import frc.robot.commands.IntakeCommands.IntakeBasic;
import frc.robot.commands.IntakeCommands.IntakeFinal;
import frc.robot.commands.IntakeCommands.IntakeCommand;
import frc.robot.commands.IntakeCommands.TimedIndexer;
import frc.robot.commands.LEDCommands.ColourCommand;
import frc.robot.commands.LEDCommands.PartyTime;
import frc.robot.commands.LEDCommands.RainbowCommand;
import frc.robot.commands.ShootCommands.AmpComplete;
import frc.robot.commands.ShootCommands.AmpShootBasic;
import frc.robot.commands.ShootCommands.AmpShootFinal;
import frc.robot.commands.ShootCommands.AmpShootReady;
import frc.robot.commands.ShootCommands.FlipZeroSequence;
import frc.robot.commands.ShootCommands.FlopperReady;
import frc.robot.commands.ShootCommands.RampAndShoot;
import frc.robot.commands.ShootCommands.ShooterCommand;
import frc.robot.commands.ShootCommands.SpeakerShoot;
import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.LEDConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.AutoCommands.TimedTeleopDrive;


/** Add your docs here. */
public class RobotContainer {

    public static SwerveSubsystem swerveSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                            "swerve"));

    public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    public static IndexerSubsystem indexerSubsystem = new IndexerSubsystem();

    public static FlopperArm flopperArm = new FlopperArm();
    public static FlopperWrist flopperWrist = new FlopperWrist();

    public static ClimberSubsystem climberSubsystem = new ClimberSubsystem();

    public static LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
    public static CameraSubsystem cameraSubsystem = new CameraSubsystem();

    public static LEDSubsystem ledSubsystem = new LEDSubsystem();

    // auto
    private final SendableChooser<String> autoChooser = new SendableChooser<>();
    private static final String DO_NOTHING = "Do Nothing";
    private static final String MIDDLE_TWO = "MiddleTwoPiece";
    private static final String RIGHT_SHOOT_LEAVE = "RightShootLeave";
    private static final String LEFT_SHOOT_LEAVE = "LeftShootLeave";
    private static final String LEAVE_ZONE = "Leave Zone";
    private static final String SHOOT_ONLY = "Shoot Only";
    private static final String DELAY_SHOOT = "Delay Shoot";
    private static final String LEFT_DELAY_SHOOT = "LeftDelayShoot";

    private static final String LEFT_AMP = "Left Amp";
    private static final String RIGHT_AMP = "Right Amp";
    private static final String FOUR_PIECE = "Four Piece";
    private static final String INTAKE_1 = "Intake1";



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
    JoystickButton operatorLeftStick = new JoystickButton(operatorController, 9);


    public RobotContainer() {

        NamedCommands.registerCommand("RampAndShoot", new RampAndShoot());
        NamedCommands.registerCommand("IntakeFinal", new IntakeFinal());
        NamedCommands.registerCommand("SpeakerShoot", new SpeakerShoot());
        NamedCommands.registerCommand("ShooterCommand", new ShooterCommand(0.8));

        // Put the auto patterns on the SmartDashboard
        autoChooser.setDefaultOption(DO_NOTHING, DO_NOTHING);
        autoChooser.addOption(MIDDLE_TWO, MIDDLE_TWO);
        autoChooser.addOption(LEFT_SHOOT_LEAVE, LEFT_SHOOT_LEAVE);
        autoChooser.addOption(RIGHT_SHOOT_LEAVE, RIGHT_SHOOT_LEAVE);
        autoChooser.addOption(LEAVE_ZONE, LEAVE_ZONE);
        autoChooser.addOption(SHOOT_ONLY, SHOOT_ONLY);
        autoChooser.addOption(DELAY_SHOOT, DELAY_SHOOT);
        autoChooser.addOption(LEFT_DELAY_SHOOT, LEFT_DELAY_SHOOT);

        autoChooser.addOption(LEFT_AMP, LEFT_AMP);
        autoChooser.addOption(RIGHT_AMP, RIGHT_AMP);
        autoChooser.addOption(FOUR_PIECE, FOUR_PIECE);
        autoChooser.addOption(INTAKE_1, INTAKE_1);


        SmartDashboard.putData("AutoPattern", autoChooser);

        
        configureBindings();

        // Command absoluteDrive = swerveSubsystem.driveCommand(
        //     () -> MathUtil.applyDeadband(driverController.getLeftY() * 0.7, OperatorConstants.LEFT_Y_DEADBAND),
        //     () -> MathUtil.applyDeadband(driverController.getLeftX() * 0.7, OperatorConstants.LEFT_X_DEADBAND),
        //     () -> driverController.getRightX() * 0.5);

        // Command fieldOrientedDrive = swerveSubsystem.driveCommand(
        //     () -> MathUtil.applyDeadband(driverController.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
        //     () -> MathUtil.applyDeadband(driverController.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
        //     () -> driverController.getRightX() * 0.5);

        TeleopDrive teleopDrive = new TeleopDrive(
            swerveSubsystem,
            () -> MathUtil.applyDeadband(driverController.getLeftY() * 0.77, OperatorConstants.LEFT_Y_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getLeftX() * 0.77, OperatorConstants.LEFT_X_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getRightX() * 0.9, OperatorConstants.RIGHT_X_DEADBAND), 
            () -> true);

        swerveSubsystem.setDefaultCommand(teleopDrive);
        
        if (intakeSubsystem.sensorActivated()) {
            new ColourCommand(LEDConstants.YELLOW);
        }
    }


    private void configureBindings() {

        operatorA.whileTrue(new IntakeFinal());
        operatorB.whileTrue(new ShooterCommand(0.9));
        operatorB.onFalse(new SpeakerShoot());
        operatorLeftBumper.whileTrue(new AmpShootReady());
        operatorLeftBumper.onFalse(new AmpShootFinal());
        operatorRightBumper.onTrue(new FlopperZero());
        operatorX.onTrue(new TimedClimb(0.8, 0.8, 2700));
        operatorY.onTrue(new TimedClimb(-0.8, -0.8, 2700));


        driverX.onTrue(Commands.runOnce(swerveSubsystem::zeroGyro));

        operatorLeftStick.onTrue(new PartyTime());

        driverRightBumper.whileTrue(new TeleopDrive(
            swerveSubsystem,
            () -> MathUtil.applyDeadband(driverController.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getRightX(), OperatorConstants.RIGHT_X_DEADBAND), 
            () -> true));

        driverLeftBumper.whileTrue(new TeleopDrive(
            swerveSubsystem,
            () -> MathUtil.applyDeadband(driverController.getLeftY() * 0.7, OperatorConstants.LEFT_Y_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getLeftX() * 0.7, OperatorConstants.LEFT_X_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getRightX() * 0.7, OperatorConstants.RIGHT_X_DEADBAND),
            () -> true));

        // driverLeftBumper.whileTrue(new DriveToTag(
        //     swerveSubsystem,
        //     () -> MathUtil.applyDeadband(driverController.getLeftY() * 0.7, OperatorConstants.LEFT_Y_DEADBAND),
        //     () -> MathUtil.applyDeadband(driverController.getLeftX() * 0.7, OperatorConstants.LEFT_X_DEADBAND),
        //     () -> limelightSubsystem.getSteer(), () -> true));

        driverA.whileTrue(new TeleopDrive(
            swerveSubsystem,
            () -> MathUtil.applyDeadband(driverController.getLeftY() * 0.7, OperatorConstants.LEFT_Y_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getLeftX() * 0.7, OperatorConstants.LEFT_X_DEADBAND),
            () -> cameraSubsystem.getTurnSpeed(), () -> true));
    }

    public Command getAutoCommand() {

        // At the beginning of auto, get the selected pattern and schedule the auto
        String selectedAuto = autoChooser.getSelected();
        
        System.out.println("Auto Selected : " + selectedAuto);
        
        switch (selectedAuto) {
        
        case DO_NOTHING:
            return new InstantCommand();
            
        case MIDDLE_TWO:
            return new MiddleTwoPiece();

        case LEFT_SHOOT_LEAVE:
            return new LeftShootAndLeave();

        case RIGHT_SHOOT_LEAVE:
            return new RightShootAndLeave();

        case LEAVE_ZONE:
            return new TimedTeleopDrive(swerveSubsystem, () -> -0.7, () -> 0, () -> 0, 
                () -> true, 5000);

        case SHOOT_ONLY:
            return new RampAndShoot();

        case DELAY_SHOOT:
            return new DelayShoot();

        case LEFT_DELAY_SHOOT:
            return new LeftDelayShoot();

        // case LEFT_AMP:
        //     return new LeftAmpSide();
        
        // case RIGHT_AMP:
        //     return new RightAmpSide();

        // case FOUR_PIECE:
        //     return new PathPlannerAuto("FourNote");

        // case INTAKE_1:
        //     return new PathPlannerAuto("Intake1");
            
        default:
            return new InstantCommand();
        }
    }
    
}
