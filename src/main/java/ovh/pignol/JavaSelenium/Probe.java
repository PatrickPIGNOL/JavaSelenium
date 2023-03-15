package ovh.pignol.JavaSelenium;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class Probe implements Runnable, AutoCloseable
{
	private Random aRandom; 
	private Thread aThread;
	public Probe()
	{	
		this.aRandom = new Random(System.nanoTime());
		this.aThread = new Thread(this);
	}
	
	@Override
	public void run()
	{
		this.mProbe();
	}
	
	public void mStart()
	{
		this.aThread.start();
	}
	
	public void mJoin() throws InterruptedException  
	{
		this.aThread.join();
	}
	
	public abstract void mProbe();
	
	public void mPause(int pBase, int pAumentation) 
	{
		int vRand = pBase;
		if(pAumentation > 0)
		{
			vRand += this.aRandom.nextInt(pAumentation); 
		}
		while(vRand > 0)
		{		
			System.out.println("Waiting for " + vRand + " seconds remaining...");
			try 
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			vRand--;
		}
	}
	
	public boolean mTestSite(WebBrowser pBrowser, String pURL)
	{
		boolean vContinue = true;
		while(vContinue)
		{		
			try
			{
				pBrowser.mDriver().get(pURL);
				vContinue = false;
				while
				(
					pBrowser.mDriver().getTitle().equals("403 Forbidden")
					||
					pBrowser.mDriver().getTitle().equals("405 Not Allowed")
				)
				{		
					if(pBrowser.mDriver().getTitle().equals("405 Not Allowed"))
					{
						vContinue = true;
					}
					try 
					{
						Thread.sleep(1000);
					}
					catch (InterruptedException e) 
					{					
						e.printStackTrace();
					}
				}
			}
			catch(Exception e) 
			{
				e.printStackTrace();
				this.mPause(5, 5);
			}
		}
		return true;
	}
	
	public List<WebElement> mFindElements(WebElement pWebElement, By pBy)
	{
		List<WebElement> vResult = null;
		try
		{
			vResult = pWebElement.findElements(pBy);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vResult;
	}
	
	public WebElement mFindElement(WebBrowser pBrowser, By pBy)
	{
		WebElement vResult = null;
		try
		{
			vResult = pBrowser.mFindElement(pBy);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}		
		return vResult;
	}
	
	public WebElement mFindElement(WebElement pWebElement, By pBy)
	{
		WebElement vResult = null;
		try
		{
			vResult = pWebElement.findElement(pBy);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}		
		return vResult;
	}
	
	public String mGetAttribute(WebElement pWebElement, String pName)
	{
		String vResult = null;
		try
		{
			vResult = pWebElement.getAttribute(pName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vResult;
	}

	@Override
	public void close() throws Exception 
	{
		this.aThread.interrupt();
	}
}
