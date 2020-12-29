package com.vyTrack.pages;

import com.vyTrack.utillities.ConfigurationReader;
import com.vyTrack.utillities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base_Page {
    public Base_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
    Logger log = Logger.getLogger(Base_Page.class);
    Actions actions = new Actions(Driver.getDriver());
    String path="";

    @FindBy(xpath = "//div[@class='message']")
    public WebElement message;

    public void navigateTo(String username, String menu, String subMenu) throws InterruptedException {
//        String truckDrivers = "user36  user37 user38 ";
        String truckDrivers = ConfigurationReader.getProperty("TruckDrivers");

//        String managers = "storemanager75  storemanager76 salesmanager137  salesmanager138  salesmanager139 ";
        String managers = ConfigurationReader.getProperty("Managers");

        if (truckDrivers.contains(username)) {
            switch (menu) {
                case "Fleet":
                    path = "(//span[@class='title title-level-1'])[1]";
                    break;
                case "Customers":
                    path = "(//span[@class='title title-level-1'])[2]";
                    break;
                case "Activities":
                    path = "(//span[@class='title title-level-1'])[3]";
                    break;
                case "System":
                    path = "(//span[@class='title title-level-1'])[4]";
                    break;
            }

            WebElement mainMenu = Driver.getDriver().findElement(By.xpath(path));
            System.out.println(mainMenu);
            WebElement subMmenu = Driver.getDriver().findElement(By.xpath("//span[.='" + subMenu + "']"));

            actions.moveToElement(mainMenu).perform();
            log.info("Navigate to :" + menu);
            actions.moveToElement(subMmenu).click().perform();
            log.info("Navigate to :" + subMenu);
//            Thread.sleep(2000);
            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            path ="";

        } else if (managers.contains(username)) {
            switch (menu) {
                case "Dashboards":
                    path = "(//span[@class='title title-level-1'])[1]";
                    break;
                case "Fleet":
                    path = "(//span[@class='title title-level-1'])[2]";
                    break;
                case "Customers":
                    path = "(//span[@class='title title-level-1'])[3]";
                    break;
                case "Sales":
                    path = "(//span[@class='title title-level-1'])[4]";
                    break;
                case "Activities":
                    path = "(//span[@class='title title-level-1'])[5]";
                    break;
                case "Marketing":
                    path = "(//span[@class='title title-level-1'])[6]";
                    break;
                case "Reports & Segments":
                    path = "(//span[@class='title title-level-1'])[7]";
                    break;
                case "System":
                    path = "(//span[@class='title title-level-1'])[8]";
                    break;
            }

            WebElement mainMenu = Driver.getDriver().findElement(By.xpath(path));
            System.out.println(mainMenu);
            WebElement subMmenu = Driver.getDriver().findElement(By.xpath("//span[.='" + subMenu + "']"));

            actions.moveToElement(mainMenu).perform();
            log.info("Navigate to :" + menu);
            wait.until(ExpectedConditions.visibilityOf(subMmenu));
            actions.moveToElement(subMmenu).click().perform();
            log.info("Navigate to :" + subMenu);
            Thread.sleep(2000);
            path ="";

        } else {
            System.out.println("CHECK THE USERNAME IT IS NOT UNDER YOUR RESPONSIBILITY !!!!!");
        }




    }
}


