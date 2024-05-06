package testCases;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;


public class BeforeEachClass {
    ReadConfig readconfig=new ReadConfig();
    public String baseURL= readconfig.getApplicationURL();
    WebDriver driver;
    public static Logger logger;
    @Parameters("browser")
    @BeforeClass
public void setUp(String browser) {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        logger = Logger.getLogger("Automation framework");
    PropertyConfigurator.configure("Log4j.properties");
    }
    @BeforeMethod
    public void goToWebsite(){
        driver.get(baseURL);
        logger.info("URL is opend");
    }
    @AfterMethod
    public void captureScreenshots(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
        /*    var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);*/
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File target = new File(System.getProperty("user.dir") + "/Screenshots/" +  result.getName()  + ".png");
                FileUtils.copyFile(source, target);            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

}
