package org.usfirst.frc.team2929.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.*;

public class DriveClass {
	
	WPI_TalonSRX	leftMotor1,
					leftMotor2,
					leftMotor3,
					rightMotor1,
					rightMotor2,
					rightMotor3;
	
	public void driveCreation(WPI_TalonSRX leftDrive1, WPI_TalonSRX leftDrive2, WPI_TalonSRX leftDrive3,
			WPI_TalonSRX rightDrive1, WPI_TalonSRX rightDrive2, WPI_TalonSRX rightDrive3)
	{
		leftMotor1 = leftDrive1;
		leftMotor2 = leftDrive2;
		leftMotor3 = leftDrive3;
		rightMotor1 = rightDrive1;
		rightMotor2 = rightDrive2;
		rightMotor3 = rightDrive3;
	}
	
	public void driveCode(JoystickButton throttleButton, JoystickButton clutch, Solenoid shifter0, Solenoid shifter1, float leftStickY, float rightStickY, float throttle)
	{
		if(throttleButton.get())
		{
			leftMotor1.set(leftStickY * throttle);
			leftMotor2.set(leftStickY * throttle);
			leftMotor3.set(leftStickY * throttle);
			rightMotor1.set(-rightStickY * throttle);
			rightMotor2.set(-rightStickY * throttle);
			rightMotor3.set(-rightStickY * throttle);
		}
		else
		{
			leftMotor1.set(leftStickY);
			leftMotor2.set(leftStickY);                                                                                                                                                                                                                                                                                                                                                                                                                                               
			leftMotor3.set(leftStickY);
			rightMotor1.set(-rightStickY);
			rightMotor2.set(-rightStickY);
			rightMotor3.set(-rightStickY);
		}
		
		if(clutch.get())
		{
			shifter0.set(false);
			shifter1.set(true);
		}
		else
		{
			shifter0.set(true);
			shifter1.set(false);
		}
	}

}
