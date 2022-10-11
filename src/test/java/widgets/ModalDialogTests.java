package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ModalDialogTests extends TestSetup {

    //TODO Do skończenia weryfikacje danych + dodanie data providera

    @Test
    @DisplayName("Modal Dialog Tests")
    @Tag("Modal")
    @Tag("Widgets")
    void newUserCanBeAddedByModalDialog() {

        getDriver().get("http://51.75.61.161:9102/modal-dialog.php");

        setElementCssPath("#create-user").click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-dialog")));

        getDriver().switchTo().activeElement();

        String newName = "Piter";
        String newEmail = "piter@interia.pl";
        String newPassword = "123456";

        setElementCssPath("#name").sendKeys(newName);
        setElementCssPath("#email").sendKeys(newEmail);
        setElementCssPath("#password").sendKeys(newPassword);
        getDriver().findElement(By.partialLinkText("Create")).click();

        List<WebElement> usersTable = createListOfElementsByCssPath("table #users");
    }
}
