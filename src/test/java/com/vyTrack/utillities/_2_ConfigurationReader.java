package com.vyTrack.utillities;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class _2_ConfigurationReader {

    /**
     * To go into the method/class implementation click and hold control/command and make a click
     *
     * @param args
     */

    private static Properties properties;
    WebDriver driver;

    static {

        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
//        // try with resource used to automatically close input stream
//
//        String browser = properties.getProperty("browser");
//        System.out.println(browser);
//        // you will get null is no such a property
//        System.out.println(properties.getProperty("UsernameTruckDriver2"));
    }

    @Test
    public void loginTest() {
        String browser = getProperty("browser");
        String URL = getProperty("urlVyTrack");
        String username = getProperty("username");
        String password = getProperty("password");
         driver = new ChromeDriver();
        driver.get(URL);
        System.out.println("Page title :: " + driver.getTitle());
//        //login
//        driver.findElement(By.id("prependedInput")).sendKeys(username);
//        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
//
//        Thread.sleep(5000);
//
//        String expected = "Dashboard";
//        String actual = driver.getTitle();
//        Assert.assertEquals(actual, expected, "Page title is not correct!");
    }

    //
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}