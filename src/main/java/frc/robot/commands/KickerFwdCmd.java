// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.KickerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class KickerFwdCmd extends Command {

    private final KickerSubsystem kickerSubsystem;
    private double voltage;

  public KickerFwdCmd(KickerSubsystem kickerSubsystem, double voltage) {
    this.kickerSubsystem = kickerSubsystem;
    this.voltage = voltage;
    addRequirements (kickerSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    kickerSubsystem.setKickerSpeed(voltage);
  }

  @Override
  public void end(boolean interrupted) {
    kickerSubsystem.setKickerSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
