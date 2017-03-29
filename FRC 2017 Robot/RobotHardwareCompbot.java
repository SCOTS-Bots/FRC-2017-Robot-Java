package org.scotsbots.robotbase.utils;

//import java.util.Base64.Encoder;

import org.scotsbots.robotbase.RobotHardware;
import org.scotsbots.robotbase.RobotOperation;
import org.scotsbots.robotbase.RobotVision;
import org.scotsbots.robotbase.RobotVisionDualUSB;
import org.scotsbots.robotbase.utils.Gamepad;
//import org.scotsbots.robotbase.AutonStrategy;
//import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

//import com.ctre.CANTalon.FeedbackDevice;
//import com.ctre.CANTalon.StatusFrameRate;
//import com.ctre.CANTalon.TalonControlMode;

//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.AnalogInput;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;

public class RobotHardwareCompbot extends RobotHardware {
	// private static final Encoder I = null;
	public Victor leftMotor;
	public Victor rightMotor;
	public DigitalOutput gearWiperOpen;
	public DigitalOutput gearWiperClosed;
	public Victor floorRollers;

	//public Victor gearTray;
	public Spark gearTray;
	public Victor ballShoot;
	public Victor ballFeed;
	public Victor pickRelease;
	public Victor ballDump;
	public Victor agitator;
	public Victor scaler;
	public Victor ballPickUp;
	public Servo gearWiper;
	public char fudge;
	public static DigitalInput gearswitch0;
	//public static DigitalInput gearswitch1;
	//public static DigitalInput gearswitch2;

	/**boolean gearswitch1 = false;
	boolean gearswitch2 = false;
	boolean gearswitch3 = false;
	*/	
	
	
	//public double speed = 1;
	//public double scoopSpeed = 1;

	boolean camSwitchBump = false;
	int camSwitchBumpTime = 0;
	
  
	

	@Override
	public void initialize() {
		vision = new RobotVision("10.47.76.20", "cam1");
		dualUSBVision = new RobotVisionDualUSB("cam1", "cam2"); // TODO set for
																// changing cams

		leftMotor = new Victor(0);
		rightMotor = new Victor(1);
		drivetrain = new RobotDrive(leftMotor, rightMotor);

		//drivetrain.setInvertedMotor(MotorType.kRearRight, true);
		//drivetrain.setInvertedMotor(MotorType.kRearLeft, true);
		drivetrain.setSafetyEnabled(false);

		ballShoot = new Victor(2);

		gearTray = new Spark(3);

		floorRollers = new Victor(4);
		ballPickUp = new Victor(5);
		scaler = new Victor(6);

		ballFeed = new Victor(7);

		agitator = new Victor(8);
		gearWiper = new Servo(9);
		gearswitch0 = new DigitalInput (0);
		/**
		addAuton(new AutonStrategyBlueBoilerGear());
		addAuton(new AutonStrategyBluePosAGear());
		addAuton(new AutonStrategyPosBGear());
		addAuton(new AutonStrategyBoilerShoot());
		addAuton(new AutonStrategyRedBoilerGear());
		addAuton(new AutonStrategyRedPosAGear());
		*/
		//DigitalInput gearswitch0 = new DigitalInput(0);
		//SmartDashboard.putBoolean("MIDDLE", gearswitch0.get());
		//speed = 1;
		//scoopSpeed = 1;
	
	//	SmartDashboard.putNumber("Speed", speed);
		// SmartDashboard.putNumber("Scoop Speed", scoopSpeed);

		camSwitchBump = false;
		camSwitchBumpTime = 0;
	}

	public void teleopInit() {
		// commented out smart dash board speed set and changed into manual
		// speed set
/**
		speed = 1;
		scoopSpeed = 1;
		SmartDashboard.putNumber("Speed", speed);
		SmartDashboard.putNumber("Scoop Speed", scoopSpeed);
		*/
		
		camSwitchBump = false;
		camSwitchBumpTime = 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void teleop() {
		//RobotOperation.driveTank(1, SmartDashboard.getNumber("Speed"));
		/**if(Gamepad.primaryLeftAttackJoystick.getButton(1))
		{
			drivetrain.setInvertedMotor(MotorType.kRearRight, true);
			drivetrain.setInvertedMotor(MotorType.kRearLeft, true);
		}
		*/	
		if (Gamepad.secondaryAttackJoystick.getLeftT()) {
			ballPickUp.set(-1);

		}

		else if (Gamepad.secondaryAttackJoystick.getLB()) {
			ballPickUp.set(0);
		}
		
	
		
		if (Gamepad.secondaryAttackJoystick.getY())
		//DRIVES TO TOP FROM BOTTOM or middle
		{
			gearTray.set(.65);
		}
		else 
		{	
			gearTray.set(0);
	}
			
		
		if(Gamepad.secondaryAttackJoystick.getX())//drives to bottom from top or middle
		{
			gearTray.set(-.65);
		}
			/**else 
			{	
				gearTray.set(0);
				
		}
		*/
		/**
		if(Gamepad.secondaryAttackJoystick.getX())
			//drives to middle from top
		{
			gearTray.set(-.6);
		Timer.delay(1.2);
		gearTray.set(0);
		}
		*/
		if(Gamepad.secondaryAttackJoystick.getSelect())
		{	
			gearWiper.set(.75);
			gearWiper.setAngle(40);
		}
		if(Gamepad.secondaryAttackJoystick.getB())
		{
	
			gearWiper.set(.75);
			gearWiper.setAngle(-30);
		}
		


		if (Gamepad.secondaryAttackJoystick.getDPadRight()) {
			// TODO Auto-generated method stub

		
		

			int fudge = 1;

			while (fudge < 12) {

				ballShoot.set(-1);
				Timer.delay(.3);
				ballFeed.set(-1);
				Timer.delay(.75);
				ballFeed.set(0);
				fudge++;
			
			
				if (fudge == 12)
					;
				ballShoot.set(0);
				ballFeed.set(0);

			}

		}

		if (Gamepad.secondaryAttackJoystick.getDPadDown()) {
			ballShoot.set(-1);
			Timer.delay(.3);
			ballFeed.set(-1);
			Timer.delay(.5);
			ballFeed.set(0);
			Timer.delay(.3);
			ballShoot.set(0);
		}
/**
		if (Gamepad.secondaryAttackJoystick.getRightT()) {
			floorRollers.set(-.6);
			
		}
		else if (Gamepad.secondaryAttackJoystick.getRB()) {
			floorRollers.set(0);
		}
*/		
		// agitator.set(1);
		// }
		// else{
		// agitator.set(0);
		// }
		// if(Gamepad.secondaryAttackJoystick.getA()) {
		// pickRelease.set(1);
		// }
		// else{
		// pickRelease.set(0);
		// }
		// if(Gamepad.secondaryAttackJoystick.getX()) {
		// ballDump.set(1);
		// }
		// else
		// {
		// ballDump.set(0);
		// }

		if(Gamepad.secondaryAttackJoystick.getRightT())
		{
			scaler.set(1);
		}
		else if(Gamepad.secondaryAttackJoystick.getRB())
		{
			scaler.set(.4);
		}
			else
			{
		scaler.set(0);
			}}

		
/**
		if (camSwitchBump && Gamepad.secondaryAttackJoystick.getSelect()) {
			dualUSBVision.switchCameras();
			camSwitchBump = false;
		}
		if (camSwitchBump && Gamepad.primaryRightAttackJoystick.getButton(1)) {
			dualUSBVision.switchCameras();
			camSwitchBump = false;
		}

		if (!camSwitchBump) {
			camSwitchBumpTime++;
			if (camSwitchBumpTime > 100) {
				camSwitchBump = true;
				camSwitchBumpTime = 0;
			}
		}}
	
*/
	// private void elseif(boolean secondaryAttackjoystickgetLeftT) {
	// TODO Auto-generated method stub

	// }

	/**
	 * 
	 * @return Done shooting?
	 */

	/**public void logSmartDashboard()
	{
		//DigitalInput gearswitch0 = new DigitalInput(0);
		SmartDashboard.putBoolean("MIDDLE", gearswitch0.get());
		//super.logSmartDashboard();
	}
*/
	public boolean usesDualUSBCameras() {
		return true;
	}

	/*
	 * public boolean usesSingleUSBCamera() { return true; }
	 */
	@Override
	public String getName() {
		return "Compbot";
	}
}
