package intercations;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTests extends TestSetup {

    @Test
    @DisplayName("Selectable Tests")
    @Tag("Selectable")
    @Tag("Interactions")
    void verifyMultipleSelectFeature() {

        getDriver().get("http://51.75.61.161:9102/selectable.php");

        List<WebElement> itemLists = createListOfElementsByCssPath(".ui-widget-content");

        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.CONTROL)
                .click(itemLists.get(0))
                .click(itemLists.get(2))
                .click(itemLists.get(3))
                .keyUp(Keys.CONTROL)
                .build().perform();

        String selectConfirmText = setElementCssPath("#feedback").getText();
        assertThat(selectConfirmText).isEqualTo("You've selected: #1 #3 #4.");
    }
}
