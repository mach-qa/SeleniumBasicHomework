package interactions;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class DraggableTests extends TestSetup {

    //TODO Zrobić według zadania domowego

    @Test
    @DisplayName("Draggable Tests")
    @Tag("Draggable")
    @Tag("Interactions")
    void itemShouldBeDraggable() {

        getDriver().get("http://51.75.61.161:9102/draggable.php");

        WebElement draggableBox = setElementCssPath("#draggable");
        WebElement pageSize = setElementCssPath("html");

        int x = pageSize.getSize().getWidth();
        int y = pageSize.getSize().getHeight();

        Point currentLocation = draggableBox.getLocation();

        Actions actions = new Actions(getDriver());
        actions.clickAndHold().moveByOffset(x, y).release().perform();

        Point newLocation = draggableBox.getLocation();

        assertThat(newLocation).isNotEqualTo(currentLocation);
    }
}
