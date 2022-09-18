package intercations;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.Assertions.assertThat;

public class DroppableTests extends TestSetup {

    @Test
    @DisplayName("Droppable Tests")
    @Tag("Droppable")
    void itemShouldBeDroppable() {

        getDriver().get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = setElementCssPath("#draggable");
        WebElement drop = setElementCssPath("#droppable");

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(drag, drop).build().perform();

        String dropConfirmText = setElementCssPath("#droppable").getText();
        assertThat(dropConfirmText).isEqualTo("Dropped!");
    }
}
