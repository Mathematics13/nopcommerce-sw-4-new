package com.nopcommerce.demo.browserfactory;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class ManageBrowser
{
    public static WebDriver driver;
    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");                //always inside double quotes

    public void selectBrowser(String browser)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        } else
        {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }
    public void closeBrowser()                                 //if driver = new ChromeDriver, Chrome browser launches
    {
        if (driver!= null)                                   //if driver = null means nothing launches , in that case give String value to launch
        {
            driver.quit();                                //if driver not equal to null means something already been launched and need to closed now
        }
    }
}

