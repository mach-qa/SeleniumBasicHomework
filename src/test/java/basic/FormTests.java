package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends TestSetup {

    @Test
    @DisplayName("Form Tests")
    @Tag("Form")
    void shouldFillFormWithSuccess() {
        getDriver().get("https://seleniumui.moderntester.pl/form.php");

        Random randomGrid = new Random();

        //First Name
        getDriver().findElement(By.id("inputFirstName3")).sendKeys("Tomasz");
        //Last Name
        getDriver().findElement(By.id("inputLastName3")).sendKeys("Nowak");
        //E-mail
        getDriver().findElement(By.id("inputEmail3")).sendKeys("t.nowak@gmail.com");
        //Sex
        List<WebElement> sexGrid = getDriver().findElements(By.name("gridRadiosSex"));
        sexGrid.get(randomGrid.nextInt(sexGrid.size())).click();
        //Age
        getDriver().findElement(By.id("inputAge3")).sendKeys("28");
        //Year of Experience
        List<WebElement> experience = getDriver().findElements(By.name("gridRadiosExperience"));
        experience.get(randomGrid.nextInt(experience.size())).click();
        //Profession
        List<WebElement> professionsList = getDriver().findElements(By.cssSelector(".checkbox-profession"));
        WebElement randomProfession = professionsList.get(new Random().nextInt(professionsList.size()));
        randomProfession.click();
        //Continents
        Select continents = new Select(getDriver().findElement(By.cssSelector("#selectContinents")));
        continents.selectByValue("asia");
        //Selenium Commands
        List<WebElement> seleniumCommandsList = getDriver().findElements(By.cssSelector("#selectSeleniumCommands"));
        WebElement randomCommand = seleniumCommandsList.get(new Random().nextInt(seleniumCommandsList.size()));
        randomCommand.click();

        //File
        File file = new File("src/main/resources/file.txt");
        getDriver().findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

        //Button
        getDriver().findElement(By.cssSelector(".btn-primary")).click();

        //Assertion
        String confirmationMessage = getDriver().findElement(By.id("validator-message")).getText();
        assertThat(confirmationMessage).isEqualTo("Form send with success");
    }
}
