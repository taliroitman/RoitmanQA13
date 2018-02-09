import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class LoginTrelloTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void LoginTrelloTest() {
        wd.get("https://trello.com/");
        wd.findElement(By.xpath("//div[2]")).click();
        wd.findElement(By.linkText("Log In")).click();
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("troitman.jew@gmail.com");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("freedom2012");
        wd.findElement(By.id("login")).click();
        wd.findElement(By.cssSelector("img.member-avatar")).click();
        wd.findElement(By.linkText("Профиль")).click();
        wd.findElement(By.linkText("Доски")).click();
       // wd.findElement(By.linkText("Группа Was")).click();
        //wd.findElement(By.xpath("//div[@class='js-all-boards']/div/div[2]/ul/li[3]/div/a/span[2]/span")).click();
       // wd.findElement(By.linkText("Ещё")).click();
        //wd.findElement(By.linkText("Закрыть доску…")).click();
        //wd.findElement(By.xpath("//div[@id='classic']/div[5]/div/div[2]/div/div/div/input")).click();
        //wd.findElement(By.linkText("Безвозвратное удаление доски…")).click();
        //wd.findElement(By.xpath("//div[@id='classic']/div[5]/div/div[2]/div/div/div/input")).click();
        //wd.findElement(By.linkText("Доски")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
