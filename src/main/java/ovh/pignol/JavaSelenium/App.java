package ovh.pignol.JavaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TestProbe vProbe = new TestProbe();
        vProbe.mStart();
        System.out.println( "Bye World!" );
    }
}
