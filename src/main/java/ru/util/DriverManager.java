package ru.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class DriverManager {
    private static Properties properties = TestProperties.getInstance().getProperties();
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if(driver == null){
            driver = createDriver();
        }
        return driver; }

    private static WebDriver createDriver(){
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        return new ChromeDriver();
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
