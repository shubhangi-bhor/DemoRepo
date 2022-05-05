package common;

import java.io.IOException;

import liabrary.FileUtils;

public class Constants {
	public static String ohrmurl="";
	public static String browser="";
	public static String ohrm_username="Admin";
	public static String ohrm_password="admin123";
	
	public static void Initconfig() throws IOException
	{
		ohrmurl=FileUtils.readPropertyFile("ohrmurl");
		browser=FileUtils.readPropertyFile("browser");
		
	}

}
