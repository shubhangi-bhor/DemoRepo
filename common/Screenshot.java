package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class Screenshot extends BaseClass
{
public static String getSreenshotPath(String TestCaseName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String dest=System.getProperty("user.dir")+ "/Screenshot/"+TestCaseName+".png" ;
	File file=new File(dest);
	FileUtils.copyFile(src, file);
	return dest;
	
	
}
}