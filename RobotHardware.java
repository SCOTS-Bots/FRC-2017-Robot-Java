package org.scotsbots.robotbase;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Base class for creating a robot.
 * @author Domenic
 *
 */
public abstract class RobotHardware
{	
	public RobotHardware bot;
	
	//universal hardware
	public RobotDrive drivetrain;
	public BuiltInAccelerometer accelerometer;
	public Encoder leftDriveEncoder;
	public Encoder rightDriveEncoder;
	
	/**
	 * Single encoder for measuring driving.
	 */
	public Encoder forwardDriveEncoder;
	public Encoder sideDriveEncoder;
	
	//public static DigitalInput switch1;
	//public static DigitalInput switch2;
	//public static DigitalInput switch3;
	public RobotVision vision;
	public RobotVisionDualUSB dualUSBVision;
	
	public List<AutonStrategy>autons = new ArrayList<AutonStrategy>();
	
	public abstract void initialize();
	public abstract void teleopInit();
	public abstract void teleop();
	public abstract String getName();
	

	/**
	 * Logs data to Smartdashboard. override and call super.logSmartDashboard() to use.
	 */
	public void logSmartDashboard()
	{
		if(Robot.bot.getName() != null)
		{
			SmartDashboard.putString("Current Robot", Robot.bot.getName());
		}
		
		if(Robot.bot.forwardDriveEncoder != null && Robot.bot.sideDriveEncoder != null)
		{
			SmartDashboard.putNumber("Forward Drive Encoder", Robot.bot.forwardDriveEncoder.getDistance());
			SmartDashboard.putNumber("Side Drive Encoder", Robot.bot.sideDriveEncoder.getDistance());
		}
		
		if(accelerometer != null)
		{
			Robot.bot.accelerometer.startLiveWindowMode();
		}

		if(accelerometer != null)
		{
			SmartDashboard.putNumber("Accelerometer X", Robot.bot.accelerometer.getX());
			SmartDashboard.putNumber("Accelerometer Y", Robot.bot.accelerometer.getY());
		}
	}
	
	/**
	 * Only needed for custom  (drawing stuff on screen). IP Camera will still work without calling this.
	 * @return
	 */
	public boolean usesIPCamera()
	{
		return false;
	}
	
	/**
	 * Call for using the USB camera. Intializes the CameraServer for showing it on the SmartDashboard.
	 * @return
	 */
	public boolean usesSingleUSBCamera()
	{
		return false;
	}
	
	public boolean usesDualUSBCameras()
	{
		return false;
	}

	public RobotHardware()
	{
		bot = this;
	}
	
	public RobotHardware getBot()
	{
		return bot;
	}
	
	public RobotHardware setBot(RobotHardware r)
	{
		return bot = r;
	}	
	
	public void addAuton(AutonStrategy a)
	{
		autons.add(a);
	}
	
}

