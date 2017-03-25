package org.scotsbots.robotbase;

import org.scotsbots.robotbase.utils.CustomCameraServer;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class RobotVisionDualUSB
{
	CustomCameraServer cameraServer;
	USBCamera firstCam = null;
	USBCamera secondCam = null;
	String camName1 = "cam1";
	String camName2 = "cam2";

	String currCam = "cam2 ";
	
	//boolean isCam1 = true;

	public RobotVisionDualUSB(String cam1, String cam2)
	{
		this.camName1 = cam1;
		this.camName2 = cam2;
	}
/**
	public void switchCameras()
	{
		if (currCam.equals(camName1))
		{
			cameraServer.startAutomaticCapture(secondCam);
			currCam = camName2;

		} else
		{
			cameraServer.startAutomaticCapture(firstCam);
			currCam = camName1;
		}
		*/
		/*
		if(isCam1)
		{
			cameraServer.startAutomaticCapture(secondCam);
			currCam = camName2;
			isCam1 = false;
		}
		else
		{
			cameraServer.startAutomaticCapture(firstCam);
			currCam = camName1;
			isCam1 = true;
		}
		*/
	

	public void endCameras()
	{
		if (firstCam != null)
		{
			firstCam.closeCamera();
			firstCam = null;
		}
		if (secondCam != null)
		{
			secondCam.closeCamera();
			secondCam = null;
		}
	}

	public void initializeCameras()
	{
		endCameras();
		try
		{
			firstCam = new USBCamera(camName1);
		} catch (Exception e)
		{
			firstCam = null;
		}
		try
		{
			secondCam = new USBCamera(camName2);
		}   catch (Exception e)
		{
			secondCam = null;
		}
		if (cameraServer == null)
		{
			UsbCamera cameraServer = CameraServer.getInstance().startAutomaticCapture();
			cameraServer.setVideoMode(PixelFormat.kMJPEG, 640, 480, 15);
			
		}
		currCam = camName1;
		UsbCamera cam2  = CameraServer.getInstance().startAutomaticCapture();
		cam2.setVideoMode(PixelFormat.kMJPEG, 640, 480, 15);
	}
}	

	