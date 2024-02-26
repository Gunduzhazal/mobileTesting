package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import steps.PageInitializer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static AppiumDriver driver;

    public static void launchApplication() throws MalformedURLException {
        ConfigReader.readProperties();
        //creating the app directory to find the application
        File appDir = new File("apk");
        File app = new File(appDir, "TestApp.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automatorName", "UIAutomator2");
        capabilities.setCapability("noSign", "true");

        //2 capabilities are important, we can't automate apk applications without them
        capabilities.setCapability("appPackage", ConfigReader.getPropertyValue("appPackage"));
        capabilities.setCapability("appActivity", ConfigReader.getPropertyValue("appActivity"));

        //we need appium server to connect our device with the scripts
        URL u = new URL("http://127.0.0.1:4723/wd/hub");

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver = new AppiumDriver(u, capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("Application launched");
        initializeObject();



    }



}
