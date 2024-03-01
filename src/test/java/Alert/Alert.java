package Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class Alert {

     WebDriver driver;


    @Test
    public void TestJSConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")));
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        alert.dismiss();
        driver.quit();
    }

//    @Test
//         public void TestJSAlert(){
//             driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Click for JS Alert")));
//    org.openqa.selenium.Alert alert = driver.switchTo().alert();
//        alert.dismiss();
//        driver.quit();
//}

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }}







