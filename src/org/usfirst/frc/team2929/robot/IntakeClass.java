package org.usfirst.frc.team2929.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IntakeClass {
	
	WPI_TalonSRX	intakeMotorLeft,
					intakeMotorRight;
	
	boolean			intake,
					outtake;
					
	
	public void intakeCreation(WPI_TalonSRX motor1, WPI_TalonSRX motor2 )
	{
		intakeMotorLeft 	= motor1;
		intakeMotorRight 	= motor2;
	}
	
	public void intakeCode(JoystickButton intakeButton, JoystickButton outtakeButton)
	{
		intake 	= intakeButton.get();
		outtake = outtakeButton.get();
		
		if(intake && !outtake)
		{
			intakeMotorLeft.set(-0.5);
			intakeMotorRight.set(0.5);
		}
		else if(!intake && outtake)
		{
			intakeMotorLeft.set(0.5);
			intakeMotorRight.set(-0.5);
		}
		else if( (intake && outtake) || (!intake && !outtake) )
		{
			intakeMotorLeft.set(0);
			intakeMotorRight.set(0);
		}
		else
		{
			intakeMotorLeft.set(0);
			intakeMotorRight.set(0);
		}
	}
}
