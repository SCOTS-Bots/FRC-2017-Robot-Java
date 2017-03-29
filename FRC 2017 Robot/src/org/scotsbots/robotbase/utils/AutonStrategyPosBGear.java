package org.scotsbots.robotbase.utils;

import org.scotsbots.robotbase.AutonStrategy;
import org.scotsbots.robotbase.Robot;

public class AutonStrategyPosBGear extends AutonStrategy
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
		
		if(time >= 0 && time <= 60)
		{
			Robot.bot.drivetrain.drive(-0.2, 0);
			//if(Robot.bot instanceof RobotHardwareCompbot)
			//{
			//	RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;
				//protobot.shroud.set(0.75);
			
		}
		
		else if(time >= 61 && time <= 193)
		{
			Robot.bot.drivetrain.drive(-.3, 0);
			
		}
	/**	else if(time >= 181 && time <= 192)
		 //{
			//	RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;
				//protobot.shroud.set(0.75);)
		{
			RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;		
			protobot.gearTray.set(-.55);
		}
		*/
		else if(time >=175)
		{
			Robot.bot.drivetrain.drive(0, 0);
		}}
	
	//if(time >230)
		//DRIVES TO TOP FROM BOTTOM or middle

		/**
		else if(time >= 200 && time <= 218)
		{
			Robot.bot.drivetrain.tankDrive(-0.64, 0.64);
			if(Robot.bot instanceof RobotHardwareCompbot)
			{
				RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;
				protobot.shroud.set(-0.75);
			}
		}
		else if(time >= 219 && time <= 230)
		{
			Robot.bot.drivetrain.drive(-0.65, 0);
		}
		else if(time > 231 && time <= 280)
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
		return "Position B Gear";
	}

}
