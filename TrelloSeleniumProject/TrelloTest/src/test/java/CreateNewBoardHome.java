import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class CreateNewBoardHome {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions() .setLegacy(true));
        wd.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }
    
    @Test
    public void CreateNewBoardHome() {
        openSite("https://trello.com/");
        clickLoginButton();
        fillLoginForm("elena.telran@yahoo.com", "12345.com");
        logIn();
        CreationBoard();
        fillBoardTitle("DeskQA13-3");
        openDropDownMenuVisibility();
        selectPublicBoardFromDropDownVisibility();
        clickButtonCreateBoard();
        clickButtonBackToBoards();
    }

    public void clickButtonBackToBoards() {
        wd.findElement(By.xpath("//div[@class='header-back-button']/a/span")).click();
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

    public void fillBoardTitle(String namesBoard) {
        wd.findElement(By.cssSelector("input.subtle-input")).click();
        wd.findElement(By.cssSelector("input.subtle-input")).clear();
        wd.findElement(By.cssSelector("input.subtle-input")).sendKeys(namesBoard);
    }

    public void CreationBoard() {
        wd.findElement(By.xpath("//div[@class='js-react-root']//span[.='Create new board…']")).click();
    }

    public void logIn() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLoginForm(String userName, String password) {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys(userName);
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        wd.findElement(By.linkText("Log In")).click();
    }

    public void openSite(String url) {
        wd.get(url);
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
