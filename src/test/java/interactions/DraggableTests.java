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

        WebElement drag = setElementCssPath("#draggable");
        WebElement pagesize = setElementCssPath("html");

        pagesize.getSize();

        Point currentLocation = drag.getLocation();

        Actions actions = new Actions(getDriver());
        actions.dragAndDropBy(drag, 420, 173).build().perform();

        Point newLocation = drag.getLocation();

        assertThat(newLocation).isNotEqualTo(currentLocation);
    }
}