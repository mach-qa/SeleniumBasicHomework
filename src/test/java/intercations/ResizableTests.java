package intercations;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class ResizableTests extends TestSetup {

    //TODO Zrobić według zadania domowego

    @Test
    @DisplayName("Resizable Tests")
    @Tag("Resizable")
    @Tag("Interactions")
    void itemShouldBeResizable() {

        getDriver().get("http://51.75.61.161:9102/resizable.php");

        WebElement resize = setElementCssPath(".ui-icon");
        WebElement resizeBox = setElementCssPath("#resizable");

        Dimension currentLocation = resizeBox.getSize();

        Actions actions = new Actions(getDriver());
        actions.clickAndHold(resize)
                .moveByOffset(420, 173)
                .build()
                .perform();

        Dimension newLocation = resizeBox.getSize();
        assertThat(newLocation).isNotEqualTo(currentLocation);
    }
}
