package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class IFrameTests extends TestSetup {

    @Test
    @DisplayName("iFrame Tests")
    @Tag("iFrame")
    void fillIFrameInputFields() {
        getDriver().get("https://seleniumui.moderntester.pl/iframes.php");

        getDriver().switchTo().frame("iframe1");
        getDriver().findElement(By.id("inputFirstName3")).sendKeys("Piter");
        getDriver().findElement(By.id("inputSurname3")).sendKeys("Piter");

        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame("iframe2");
        getDriver().findElement(By.id("inputLogin")).sendKeys("Piter");
        getDriver().findElement(By.id("inputPassword")).sendKeys("12353");

        Select continents = new Select(getDriver().findElement(By.id("inlineFormCustomSelectPref")));
        continents.selectByValue("Asia");

        Random randomGrid = new Random();
        List<WebElement> experience = getDriver().findElements(By.name("gridRadios"));
        experience.get(randomGrid.nextInt(experience.size())).click();

        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.linkText("Basic")).click();

    }

}
