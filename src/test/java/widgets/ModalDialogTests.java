package widgets;

import base.TestSetup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ModalDialogTests extends TestSetup {

    @ParameterizedTest (name = "Modal Dialog Tests - User no. {0}")
    @CsvFileSource(resources = "/users_database.csv")
    @Tag("Modal")
    @Tag("Widgets")
    void newUserCanBeAddedViaModalDialog(String key, String name, String email, String password) {

        getDriver().get("http://51.75.61.161:9102/modal-dialog.php");

        setElementCssPath("#create-user").click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-dialog")));

        getDriver().switchTo().activeElement();

        setElementCssPath("#name").clear();
        setElementCssPath("#name").sendKeys(name);
        setElementCssPath("#email").clear();
        setElementCssPath("#email").sendKeys(email);
        setElementCssPath("#password").clear();
        setElementCssPath("#password").sendKeys(password);

        setElementCssPath("button:first-child").click();

        List<WebElement> newAddedUser = getDriver().findElements(By.cssSelector("tbody tr:last-child td"));

        assertThat(newAddedUser.get(0).getText()).isEqualTo(name);
        assertThat(newAddedUser.get(1).getText()).isEqualTo(email);
        assertThat(newAddedUser.get(2).getText()).isEqualTo(password);
    }
}