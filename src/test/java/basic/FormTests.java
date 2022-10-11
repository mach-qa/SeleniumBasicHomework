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

    //TODO Poprawić i zrobić w Page Object Pattern

    @Test
    @DisplayName("Form Tests")
    @Tag("Form")
    @Tag("Basic")
    void shouldFillFormWithSuccess() {
        getDriver().get("http://51.75.61.161:9102/form.php");

        Random randomGrid = new Random();

        //First Name
        setElementCssPath("#inputFirstName3").sendKeys("Tomasz");
        //Last Name
        setElementCssPath("#inputLastName3").sendKeys("Nowak");
        //E-mail
        setElementCssPath("#inputEmail3").sendKeys("t.nowak@gmail.com");
        //Sex sprawdzić jak zredukować
        List<WebElement> sexGrid = getDriver().findElements(By.name("gridRadiosSex"));
        sexGrid.get(randomGrid.nextInt(sexGrid.size())).click();
        //Age
        setElementCssPath("#inputAge3").sendKeys("28");
        //Year of Experience sprawdzić jak zredukować
        List<WebElement> experience = getDriver().findElements(By.name("gridRadiosExperience"));
        experience.get(randomGrid.nextInt(experience.size())).click();
        //Profession sprawdzić jak zredukować
        List<WebElement> professionsList = getDriver().findElements(By.cssSelector(".checkbox-profession"));
        professionsList.get(new Random().nextInt(professionsList.size())).click();
        //WebElement randomProfession = professionsList.get(new Random().nextInt(professionsList.size()));
        //randomProfession.click();
        //Continents
        Select continents = new Select(setElementCssPath("#selectContinents"));
        continents.selectByValue("asia");
        //Selenium Commands sprawdzić jak zredukować
        List<WebElement> seleniumCommandsList = getDriver().findElements(By.cssSelector("#selectSeleniumCommands"));
        seleniumCommandsList.get(new Random().nextInt(seleniumCommandsList.size())).click();
        //WebElement randomCommand = seleniumCommandsList.get(new Random().nextInt(seleniumCommandsList.size()));
        //randomCommand.click();

        //File
        File file = new File("src/main/resources/file.txt");
        setElementCssPath("#chooseFile").sendKeys(file.getAbsolutePath());

        //Button
        setElementCssPath(".btn-primary").click();

        //Assertion
        String confirmationMessage = setElementCssPath("#validator-message").getText();
        assertThat(confirmationMessage).isEqualTo("Form send with success");
    }
}
