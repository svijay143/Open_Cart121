package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass (groups= {"Regression", "Sanity", "Master"})
	@Parameters ({"os", "browser"})
	public void setup (String os, String br) throws IOException
	{
		//Loading config.properties file
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		logger= LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome": driver= new ChromeDriver(); break;
		case "firefox": driver= new FirefoxDriver(); break;
		case "edge": driver= new EdgeDriver(); break;
		default: System.out.println("Invalid browser name..."); return;
		
		}
		
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL")); //Reading url from config.properties file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass (groups= {"Regression", "Sanity", "Master"})
	public void closebrowser()
	{
		driver.quit();
	}
	
	public String randomString()
	{	
		String generateString= RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber()
	{	
		String generateNumber= RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}

	public String randomAlphanumeric()
	{	
		String generateString= RandomStringUtils.randomAlphabetic(5);
		String generateNumber= RandomStringUtils.randomAlphanumeric(3);
		
		return (generateString+"@"+generateNumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
