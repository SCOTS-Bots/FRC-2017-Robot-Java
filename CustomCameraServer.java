package org.scotsbots.robotbase.utils;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.vision.USBCamera;


public class CustomCameraServer extends IterativeRobot {
    
    public void robotInit() {
            new Thread(() -> {
               // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            	 UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture();
               // camera.setResolution(640, 480);
            	 cam1.setResolution(640, 480);
            	 UsbCamera cam2 = CameraServer.getInstance().startAutomaticCapture();
            	 cam2.setResolution(640, 480);
               // CvSink cvSink = CameraServer.getInstance().getVideo();
            	 CvSink cvSink1 = CameraServer.getInstance().getVideo();
            	 CvSink cvSink2 = CameraServer.getInstance().getVideo();
            	 
                CvSource outputStream1 = CameraServer.getInstance().putVideo("cam1", 640, 480);
                CvSource outputStream2 = CameraServer.getInstance().putVideo("cam2", 640, 480);
                
                Mat source1 = new Mat();
                Mat output1 = new Mat();
                Mat source2 = new Mat();
                Mat output2 = new Mat();
                //lines20-35 updated for cameras 2017
                while(!Thread.interrupted()) {
                    cvSink1.grabFrame(source1);
                    Imgproc.cvtColor(source1, output1, Imgproc.COLOR_BGR2GRAY);
                    outputStream1.putFrame(output1);
                    cvSink2.grabFrame(source2);
                    Imgproc.cvtColor(source2, output2, Imgproc.COLOR_BGR2GRAY);
                    outputStream2.putFrame(output2);
                }
            }).start();
}

	//_MF Comment public void startAutomaticCapture(UsbCamera thirdCam) {
		// TODO Auto-generated method stub
		

		

//	}

	public static CustomCameraServer getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public void startAutomaticCapture(UsbCamera thirdCam) {
		// TODO Auto-generated method stub
		
	}

	public void startAutomaticCapture(USBCamera secondCam) {
		// TODO Auto-generated method stub
		
	}}
