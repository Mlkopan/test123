package com.Mainframe.Screens;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang.RandomStringUtils;

public class CaptureSnapShot {
	public static String screenshotfolderpath; 
	
	public String snapshot() throws AWTException
	{
		String randomnumber = RandomStringUtils.randomNumeric(5);
		String fileName="";		
		 try {
	            Robot robot = new Robot();
	            String format = "png";
	            fileName = "C:\\workspace\\Manoj\\Automation\\ScreenShots\\"+ randomnumber+"."+ format;
	             
	            Rectangle cap = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	            Rectangle screenRect = new Rectangle(0,60,(cap.width/2)-20,(cap.height)-250);
	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	            ImageIO.write(screenFullImage, format, new File(fileName));
	       	        } catch (IOException ex) {
	            System.err.println(ex);
	        }
		 return fileName;
	} 
 
}
