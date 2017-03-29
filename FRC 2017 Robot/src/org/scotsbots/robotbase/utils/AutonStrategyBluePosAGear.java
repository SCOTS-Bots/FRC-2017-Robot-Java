package org.scotsbots.robotbase.utils;

import org.scotsbots.robotbase.AutonStrategy;
import org.scotsbots.robotbase.Robot;

public class AutonStrategyBluePosAGear extends AutonStrategy
{
	public int time = 0;
	
	@Override
	public void intialize()
	{
		time = 0;
	}

	@Override
	public void update()
	{
		time++;
		if(Robot.bot instanceof RobotHardwareCompbot)
		{
			RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;
		}
			if(time >= 0 && time <= 75)
			{
				Robot.bot.drivetrain.drive(-0.3, 0);
			}
			else if(time >= 76 && time <=150 )
			{
				Robot.bot.drivetrain.drive(-0.4 ,0);
				
			}
			else if (time >= 151)
			{	
				Robot.bot.drivetrain.drive(0, 0);
			}
			
				
			}
	/**	else if(time >=55 && time>=60)
			//DRIVES TO TOP FROM BOTTOM or middle
	{	
		RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;		
		protobot.gearTray.set(.55);
		
	}}
		
		else if(time >= 60 && time <= 190)
		{
			Robot.bot.drivetrain.drive(-0.7, 0);
		}
		else if(time >= 191 && time <= 215)
		{
			Robot.bot.drivetrain.tankDrive(0.7, -0.7);
		}
		else if(time >= 216 && time <=280)
		{
			Robot.bot.drivetrain.drive(-0.35, 0);
		}
		else if(time > 280 && time <= 350)
		{
			if(Robot.bot instanceof RobotHardwarePrototypeBot)
			{
				RobotHardwarePrototypeBot protobot = (RobotHardwarePrototypeBot)Robot.bot;			
				protobot.intake.set(1);
			}
			
			if(Robot.bot instanceof RobotHardwareCompbot)
			{
				RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;
				protobot.intake.set(1);
			}
		}
		else
		{
			Robot.bot.drivetrain.drive(0, 0);
			
			if(Robot.bot instanceof RobotHardwarePrototypeBot)
			{
				RobotHardwarePrototypeBot protobot = (RobotHardwarePrototypeBot)Robot.bot;			
				protobot.intake.set(0);
			}
			
			if(Robot.bot instanceof RobotHardwareCompbot)
			{
				RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;
				protobot.intake.set(0);
			}
		}
	}
*/
	@Override
	public String getName()
	{
		return "Blue Position A Gear";
	}

}
