package org.scotsbots.robotbase.utils;

import org.scotsbots.robotbase.AutonStrategy;
import org.scotsbots.robotbase.Robot;
import org.scotsbots.robotbase.utils.RobotHardwareCompbot;

//import org.scotsbots.stronghold.RobotHardwareCompbot;

public class AutonStrategyBlueBoilerGear extends AutonStrategy
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
				else if(time >= 76 && time <=178 )
				{
					Robot.bot.drivetrain.drive(-0.42, -.1);
					
				}
		/**	else if(time >=165 && time <=170)
					//DRIVES TO TOP FROM BOTTOM or middle
			{	
				RobotHardwareCompbot protobot = (RobotHardwareCompbot)Robot.bot;		
				protobot.gearTray.set(-.55);
			}*/
				else if (time >= 179)
				{	
					Robot.bot.drivetrain.drive(0, 0);
				}
				
					
				}
	
	@Override
	public String getName()
	{
		return "Position Blue Boiler Gear";
	}
	

	}
