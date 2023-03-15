package ovh.pignol.JavaSelenium;

import org.openqa.selenium.chrome.ChromeOptions;

public class TestProbe extends Probe
{
	@Override
	public void mProbe() 
	{
		ChromeOptions vOptions = new ChromeOptions();
		vOptions.addArguments("--remote-allow-origins=*");
		try(WebBrowser vBrowser = new Chrome(vOptions))
		{
			String vURL = "http://google.com";
			this.mTestSite(vBrowser, vURL);
			this.mPause(10, 0);
		}
		catch (Exception e)
		{		
			e.printStackTrace();
		}
	}
}
