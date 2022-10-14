package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuTests extends TestSetup {

    @Test
    @DisplayName("Menu Tests")
    @Tag("Menu")
    @Tag("Widgets")
    void menuShouldBeExpandable() {

        getDriver().get("http://51.75.61.161:9102/menu-item.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        Actions action = new Actions(getDriver());

        WebElement parentMenuItem = setElementCssPath("#ui-id-9");

        action.moveToElement(parentMenuItem).perform();

        WebElement childMenuItem = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("#ui-id-13")));

        action.moveToElement(childMenuItem).perform();

        WebElement grandChildMenuItem = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("#ui-id-16")));

        action.moveToElement(grandChildMenuItem).click().perform();
    }
}
