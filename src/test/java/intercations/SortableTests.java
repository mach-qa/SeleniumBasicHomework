package intercations;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.util.Collections.shuffle;
import static org.assertj.core.api.Assertions.assertThat;

public class SortableTests extends TestSetup {

    @Test
    @DisplayName("Sortable Tests")
    @Tag("Sortable")
    void verifyMultipleSelectFeature() {

        getDriver().get("https://seleniumui.moderntester.pl/sortable.php");

        List<WebElement> itemLists = createListOfElementsByCssPath(".ui-state-default");

        shuffle(itemLists);

        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.CONTROL)
                .click(itemLists.get(0))
                .click(itemLists.get(2))
                .click(itemLists.get(4))
                .keyUp(Keys.CONTROL)
                .build().perform();

        String selectConfirmText = setElementCssPath("#feedback").getText();
        assertThat(selectConfirmText).isEqualTo("You've selected: #1 #3 #4.");
    }
}
