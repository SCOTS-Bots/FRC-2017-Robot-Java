package org.scotsbots.robotbase;

import org.scotsbots.robotbase.utils.Gamepad;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;

/**
 * Static class for basic robot operation calls.
 * @author Domenic
 *
 */
public class RobotOperation 
{	
	public static PIDController encoderControl = new PIDController(.1, .003,0, new PIDSource() 
	{
		

		@Override
		public void setPIDSourceType(PIDSourceType pidSource)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public PIDSourceType getPIDSourceType()
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public double pidGet()
		{
			// TODO Auto-generated method stub
			return 0;
		}
	}, new PIDOutput() 
	{
		public void pidWrite(double d) 
		{
			Robot.bot.drivetrain.tankDrive(-d * 0.66, -d * 0.66);
		}
	});
	
	
	/**
	 * Drives tank drive.
	 * @param joystickSet 0 - Only gamepads, 1 - attacks and gamepad
	 */
	public static void driveTank(int joystickSet)
	{
		driveTank(joystickSet, 1);
	}
	
	/**
	 * Drives in tank, multiplies speed by speed ratio.
	 * @param joystickSet 0 - Only gamepads, 1 - attacks and gamepad
	 * @param speedRatio range of motor power
	 */
	public static void driveTank(int joystickSet, double speedRatio)
	{
		if(joystickSet == 0)
		{
			Robot.bot.drivetrain.tankDrive(Gamepad.primaryGamepad.getLeftY() * speedRatio, Gamepad.primaryGamepad.getRightY() * speedRatio, true);
		}
		if(joystickSet == 1)
		{
			//double leftThrottle = ((1-Gamepad.primaryLeftAttackJoystick.getZ()) * .35) + .65;
			//double rightThrottle = ((1-Gamepad.primaryRightAttackJoystick.getZ()) * .35) + .65;
			Robot.bot.drivetrain.tankDrive(Gamepad.primaryLeftAttackJoystick.getY() * speedRatio, Gamepad.primaryRightAttackJoystick.getY() * speedRatio, true);
		}

       // Timer.delay(0.005);	// wait 5ms to avoid hogging CPU cycles
	}

	public static void reset()
	{
		// TODO Auto-generated method stub
		
	}

	public static void initialize()
	{
		// TODO Auto-generated method stub
		
	}};	

