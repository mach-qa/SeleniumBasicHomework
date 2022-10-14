package interactions;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class ResizableTests extends TestSetup {

    @Test
    @DisplayName("Resizable Tests")
    @Tag("Resizable")
    @Tag("Interactions")
    void itemShouldBeResizable() {

        getDriver().get("http://51.75.61.161:9102/resizable.php");

        WebElement resize = setElementCssPath(".ui-icon");
        WebElement resizeBox = setElementCssPath("#resizable");

        Dimension currentLocation = resizeBox.getSize();

        resizeBoxByOffset(resize, 10, 0);

        assertThat(resizeBox.getSize()).isNotEqualTo(currentLocation);

        Dimension currentLocation2 = resizeBox.getSize();

        resizeBoxByOffset(resize, 0, 10);
        assertThat(resizeBox.getSize()).isNotEqualTo(currentLocation2);

        Dimension currentLocation3 = resizeBox.getSize();

        resizeBoxByOffset(resize, 10, 10);
        assertThat(resizeBox.getSize()).isNotEqualTo(currentLocation3);
    }

    private void resizeBoxByOffset (WebElement resize, int X, int Y) {
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(resize)
                .moveByOffset(X, Y)
                .build()
                .perform();
    }
}
