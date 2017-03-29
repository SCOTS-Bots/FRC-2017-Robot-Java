/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2016. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* Howell SCOTS Bots 2016 - Competition Season                                */
/*----------------------------------------------------------------------------*/

package org.scotsbots.robotbase;

import org.scotsbots.robotbase.utils.Gamepad;
import org.scotsbots.robotbase.utils.Logger;
import org.scotsbots.robotbase.utils.RobotHardwareCompbot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main Class for Robot Base code.
 * @author Domenic
 *
 */
public class Robot extends IterativeRobot 
{
	public static AutonStrategy selectedAuton = null;
	public static RobotHardware bot = null;	
	public SendableChooser autonSwitcher;
	VideoSink server;
	//Timer.delay(.005)
	UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
	//Timer.delay(.005)
	UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture();
	
    public void robotInit() 
    {
    	Logger.riolog("S.C.O.T.S. Bots Robot Base code Intializing.");
    	bot = new RobotHardwareCompbot(); //This changes which bot it loads. TODO Add abstraction way of doing this.
    	bot.initialize();
 
    	RobotOperation.initialize();
       	server = CameraServer.getInstance().getServer();//updated MF 3.19
    //	if(bot.usesIPCamera() && bot.vision != null)
    	{
    //		bot.vision.initialize();
    	}
    //	if(bot.usesSingleUSBCamera() && bot.vision != null)
    	{
    //		bot.vision.initUSBCam();
    	}
    //	if(bot.usesDualUSBCameras() && bot.dualUSBVision != null)
    	{
    //		bot.dualUSBVision.initializeCameras();
    	}
    	autonSwitcher = new SendableChooser();
    	autonSwitcher.addDefault("Nothing", new AutonStrategyDoNothing());
    	for(int i = 0; i < Robot.bot.autons.size(); i++)
    	{
    		autonSwitcher.addObject(Robot.bot.autons.get(i).getName(), Robot.bot.autons.get(i));
    	}
		Logger.riolog("S.C.O.T.S. Bots Robot Base code intialized.");
    }
    
    public void autonomousInit()
    {
    	RobotOperation.reset();
    	//selectedAuton = bot.getSwitchedAuton(); old non SD auton switching
    	if(autonSwitcher.getSelected() instanceof AutonStrategy)
    	{
    		selectedAuton = (AutonStrategy) autonSwitcher.getSelected();
    	}
    	selectedAuton.intialize();
    }
    
    public void autonomousPeriodic() 
    {
    	selectedAuton.update();
    	bot.logSmartDashboard();
    }
    
    public void teleopInit()
    {
    	Robot.bot.teleopInit();
    	RobotOperation.reset();
    //	if(bot.usesDualUSBCameras() && bot.dualUSBVision != null)
    	{
   // 		bot.dualUSBVision.initializeCameras();
    	}
    }
    
    public void teleopPeriodic() 
    {
 //   	if(bot.usesIPCamera() && bot.vision != null)
    	{
    	//	bot.vision.stream();
    	}
		bot.teleop();
    	bot.logSmartDashboard();
    
 	if(Gamepad.primaryLeftAttackJoystick.getButton(1))
	{
		cam1.setResolution(160,120);
		server.setSource(cam1);
		//drivetrain.setInvertedMotor(MotorType.kRearRight, true);
		//drivetrain.setInvertedMotor(MotorType.kRearLeft, true);
	}
	if(Gamepad.primaryRightAttackJoystick.getButton(1))
	{
		cam0.setResolution(160,120);
		server.setSource(cam0);
	}}

    public void testInit()
    {
    	RobotOperation.reset();
    }
    
    public void testPeriodic() 
    {
    	LiveWindow.run();
    	bot.logSmartDashboard();
    }
    
    public void disabledInit() 
    {
		RobotOperation.reset();
		
	//	if(Robot.bot.usesDualUSBCameras() && Robot.bot.dualUSBVision != null)
		{
			//Robot.bot.dualUSBVision.endCameras();
		}

    }
    
    public void disabledPeriodic()
    {
    	if(autonSwitcher == null)
    	{
    		autonSwitcher = new SendableChooser();
        	autonSwitcher.addDefault("Nothing", new AutonStrategyDoNothing());
        	for(int i = 0; i < Robot.bot.autons.size(); i++)
        	{
        		autonSwitcher.addObject(Robot.bot.autons.get(i).getName(), Robot.bot.autons.get(i));
        	}
    	}
    	else
    	{
    		SmartDashboard.putData("Auton Modes", autonSwitcher);
    	}
    }
}

