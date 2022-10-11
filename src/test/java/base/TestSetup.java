package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class TestSetup {

    static WebDriver driver;

    //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebElement setElementCssPath (String cssPath) {
        return getDriver().findElement(By.cssSelector(cssPath));
    }
    protected List<WebElement> createListOfElementsByCssPath (String cssPath) {
        return getDriver().findElements(By.cssSelector(cssPath));
    }

    protected void windowHandleLoop (String originalWindow){
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    protected WebElement getRandomRowInList (List<WebElement> elementsList) {
        Random randomGrid = new Random();
        return elementsList.get(randomGrid.nextInt(elementsList.size()));
    }

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void exit() {
        driver.quit();
    }
}
