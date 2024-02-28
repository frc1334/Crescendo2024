// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.subsystems.IndexerSubsystem;
// import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LEDSubsystem;
// import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.RobotContainer;
import frc.robot.Constants.LEDConstants;
import frc.robot.commands.LEDCommands.RainbowCommand;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Command;




/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private RobotContainer robotContainer;
  
  
  CommandScheduler commandScheduler = CommandScheduler.getInstance();

  
  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();

  }

  @Override
  public void robotPeriodic() {
    commandScheduler.run();
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {
    commandScheduler.run();
    
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    commandScheduler.run();
    RobotContainer.ledSubsystem.ledColour(LEDConstants.RED);
    
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    RobotContainer.ledSubsystem.ledColour(LEDConstants.WHITE);
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
