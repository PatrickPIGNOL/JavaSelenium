package ovh.pignol.JavaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements WebBrowser
{
	private WebDriver aChromeDriver;
	
	public Chrome()
	{	
		this.aChromeDriver = new ChromeDriver();		
	}
	
	public Chrome(ChromeOptions pOptions)
	{	
		this.aChromeDriver = new ChromeDriver(pOptions);		
	}

	@Override
	public WebDriver mDriver()
	{
		return this.aChromeDriver;
	}

	@Override
	public void mClose()
	{
		if(this.aChromeDriver != null)
		{
			this.aChromeDriver.close();
			this.aChromeDriver.quit();
		}
	}

	@Override
	public void close() throws Exception 
	{
		this.mClose();
	}

	@Override
	public String mPageSource()
	{
		return this.aChromeDriver.getPageSource();
	}

	@Override
	public WebElement mFindElement(By pBy) 
	{		
		WebElement vResult = null;
		try
		{
			vResult = this.aChromeDriver.findElement(pBy);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vResult;
	}

	@Override
	public List<WebElement> mFindElements(By pBy) 
	{
		List<WebElement> vResult = null;
		try
		{
			vResult = this.aChromeDriver.findElements(pBy);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vResult;
	}
}
