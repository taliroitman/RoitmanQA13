import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class CreateNewBoard {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
    
    @Test
    public void CreateNewBoard() {
        openSite();
        //wd.findElement(By.xpath("//div[2]")).click();
        clickLoginButton();
        fillLoginForm();
        logIn();
       // clickOnThePlusButton();
        initBoardCreationFromTheBody();
        fillBoardTitle();
        openDropDownMenuVisibility();
        selectPublicBoardFromDropDownVisibility();
        clickButtonCreateBoard();
        clickButtonBackToBoards();
    }

    public void clickButtonBackToBoards() {
        wd.navigate().back();
    }

    public void clickButtonCreateBoard() {
        wd.findElement(By.cssSelector("button.primary")).click();
    }

    public void selectPublicBoardFromDropDownVisibility() {
        wd.findElement(By.xpath("//div[@id='classic']/div[5]/div/div[2]/div/ul/li[2]/a/span[3]/span")).click();
    }

    public void openDropDownMenuVisibility() {
        wd.findElement(By.xpath("//form[@class='create-board-form']//button[.='Private']")).click();
    }

    public void fillBoardTitle() {
        wd.findElement(By.cssSelector("input.subtle-input")).click();
        wd.findElement(By.cssSelector("input.subtle-input")).clear();
        wd.findElement(By.cssSelector("input.subtle-input")).sendKeys("Roitman@13");
    }

    public void initBoardCreationFromTheBody() {
        wd.findElement(By.xpath("//*[@href='#']")).click();
    }

    public void clickOnThePlusButton() {
        wd.findElement(By.xpath("//div[@class='header-user']/a[1]/span")).click();
    }

    public void logIn() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLoginForm() {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("elena.telran@yahoo.com");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("12345.com");
    }

    public void clickLoginButton() {
        wd.findElement(By.linkText("Log In")).click();
    }

    public void openSite() {
        wd.get("https://trello.com/");
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
