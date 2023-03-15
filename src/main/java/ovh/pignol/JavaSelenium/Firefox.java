package ovh.pignol.JavaSelenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements WebBrowser
{
	private WebDriver aFirefoxDriver;

	public Firefox()
	{	
		System.setProperty("webdriver.gecko.driver", "bin/geckodriver.exe");
		this.aFirefoxDriver = new FirefoxDriver();
	}

	@Override
	public String mPageSource()
	{
		return this.aFirefoxDriver.getPageSource();
	}

	@Override	
	public WebElement mFindElement(By pArgs)
	{
		WebElement vResult = null;
		try
		{
			vResult = this.aFirefoxDriver.findElement(pArgs);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return vResult;
	}
	
	@Override	
	public List<WebElement> mFindElements(By pArgs)
	{
		List<WebElement> vResult = null;
		try
		{
			vResult = this.aFirefoxDriver.findElements(pArgs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vResult;
	}
	
	@Override
	public WebDriver mDriver()
	{
		return this.aFirefoxDriver;
	}
	
	@Override
	public void mClose()
	{
		if(this.aFirefoxDriver != null)
		{
			this.aFirefoxDriver.close();
			this.aFirefoxDriver = null;
		}
	}

	@Override
	public void close()
	{
		this.mClose();
	}
}
