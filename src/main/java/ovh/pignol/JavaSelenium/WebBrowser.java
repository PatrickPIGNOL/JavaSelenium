package ovh.pignol.JavaSelenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebBrowser extends AutoCloseable
{
	public WebDriver mDriver();
	public void mClose();
	public String mPageSource();
	WebElement mFindElement(By pBy);
	List<WebElement> mFindElements(By pBy);
}
