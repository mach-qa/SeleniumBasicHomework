package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FormTests extends TestSetup {

    @Test
    @DisplayName("Form Tests")
    @Tag("Form")
    void shouldFillFormWithSuccess() {
        getDriver().get("https://seleniumui.moderntester.pl/form.php");

        getDriver().findElement(By.id("inputFirstName3")).sendKeys("Tomasz");
        getDriver().findElement(By.id("inputLastName3")).sendKeys("Nowak");
        getDriver().findElement(By.id("inputEmail3")).sendKeys("t.nowak@gmail.com");
        getDriver().findElement(By.id("inputAge3")).sendKeys("28");


    }
}
