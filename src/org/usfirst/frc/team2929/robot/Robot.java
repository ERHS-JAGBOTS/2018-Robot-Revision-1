

package org.usfirst.frc.team2929.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Robot extends IterativeRobot {

	WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(0),
			  leftMotor2 = new WPI_TalonSRX(1),
			  leftMotor3 = new WPI_TalonSRX(2),
			  rightMotor1 = new WPI_TalonSRX(3),
			  rightMotor2 = new WPI_TalonSRX(4),
			  rightMotor3 = new WPI_TalonSRX(5);
	
	Compressor  comp = new Compressor(0);
	
    Joystick  controller = new Joystick(0);
    
    Solenoid 	shifter0 = new Solenoid(0),
    			shifter1 = new Solenoid(1);
    
    JoystickButton clutch = new JoystickButton(controller, 5),
    				throttleButton = new JoystickButton(controller, 6);
    
    float deadband = (float) 0.2,
    		leftStickY,
    		rightStickY,
    		throttle = (float) 0.3;
    
    JoystickReading controllerRead;
    DriveClass robotDrive;
    
	@Override
	public void robotInit() {
		comp.start();
		controllerRead = new JoystickReading();
		robotDrive = new DriveClass();
		robotDrive.driveCreation(leftMotor1, leftMotor2, leftMotor3, rightMotor1, rightMotor2, rightMotor3);
	}

	
	@Override
	public void autonomousInit() {
	
	}

	
	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopPeriodic() {

	robotDrive.driveCode(throttleButton, clutch, shifter0, shifter1, controllerRead.getLeftY(controller, deadband),
			controllerRead.getRightY(controller,  deadband), throttle);	
		
	}

	
	@Override
	public void testPeriodic() {
	}
}
