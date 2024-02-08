// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    private CANSparkMax leftShooterNeo;
    private CANSparkMax rightShooterNeo;

  public ShooterSubsystem() {
    leftShooterNeo = new CANSparkMax(16,MotorType.kBrushless);
    rightShooterNeo = new CANSparkMax(17, MotorType.kBrushless);

    leftShooterNeo.restoreFactoryDefaults();
    rightShooterNeo.restoreFactoryDefaults();

    leftShooterNeo.setSmartCurrentLimit(80);
    rightShooterNeo.setSmartCurrentLimit(80);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setShooterSpeeds(double leftShooterVoltage, double rightShooterVoltage) {
    leftShooterNeo.set(leftShooterVoltage);
    rightShooterNeo.set(rightShooterVoltage);
  }


}
