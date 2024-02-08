// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.KickerFwdCmd;
import frc.robot.commands.ShootCloseSpkrCmd;
import frc.robot.commands.ShootMaxRangeSpkrSCG;
import frc.robot.subsystems.KickerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final KickerSubsystem kickerSubsystem = new KickerSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }


  private void configureBindings() {

//    m_driverController.a().onTrue(new KickerFwdCmd(kickerSubsystem, 3.0).withTimeout(3));
      m_driverController.a().onTrue(new ShootCloseSpkrCmd(shooterSubsystem, 2.0, 1.0) //
                            .withTimeout(4)
                            .andThen(new KickerFwdCmd(kickerSubsystem, 2.0))
                            .withTimeout(2.0)
                            .andThen(new ShootCloseSpkrCmd(shooterSubsystem, 0, 0)
                            .andThen(new KickerFwdCmd(kickerSubsystem, 0))));
                            

      m_driverController.leftTrigger(0.5).onTrue(new ShootMaxRangeSpkrSCG(shooterSubsystem,kickerSubsystem));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
