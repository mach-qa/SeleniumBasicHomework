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
        setElementCssPath("#inputFirstName3").sendKeys("Piter");
        setElementCssPath("#inputSurname3").sendKeys("Machre");

        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame("iframe2");
        setElementCssPath("#inputLogin").sendKeys("Piter");
        setElementCssPath("#inputPassword").sendKeys("12353");

        Select continents = new Select(setElementCssPath("#inlineFormCustomSelectPref"));
        continents.selectByValue("asia");

        List<WebElement> experience = createListOfElementsByCssPath("[name=gridRadios]");
        getRandomRowInList(experience).click();

        getDriver().switchTo().defaultContent();
        setElementCssPath(".nav-ite").click();
    }

}
