package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.FormPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTests extends TestSetup {

    @Test
    @DisplayName("Form Tests")
    @Tag("Form")
    @Tag("Basic")
    void shouldFillFormWithSuccess() {
        getDriver().get("http://51.75.61.161:9102/form.php");

        FormPage formPage = new FormPage(getDriver());

        formPage.provideBasicUserData("Mateusz", "Nowak", "tenten@gmail.com");
        formPage.selectRandomSexGrid();
        formPage.provideUserAge("28");
        formPage.selectRandomExperience();
        formPage.selectRandomProfession();
        formPage.chooseContinent("asia");
        formPage.selectRandomSeleniumCommands(2);
        formPage.sendFile("src/main/resources/file.txt");
        formPage.clickConfirmationButton();
        assertThat(formPage.returnValidatorMessage()).isEqualTo("Form send with success");
    }
}
