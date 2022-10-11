package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoCompleteTests extends TestSetup {

    @Test
    @DisplayName("Autocomplete Search Tests")
    @Tag("Autocomplete")
    @Tag("Widgets")
    void autocompleteListShouldBeSelectable() {
        getDriver().get("http://51.75.61.161:9102/autocomplete.php");

        setElementCssPath("#search").sendKeys("a");

        List<WebElement> listFromAutoCompleteSearch = createListOfElementsByCssPath(".ui-menu-item");

        for (WebElement position : listFromAutoCompleteSearch) {
            System.out.println(position.getText());
        }

        WebElement chosenPosition = getRandomRowInList(listFromAutoCompleteSearch);

        chosenPosition.click();
        String displayedPosition = setElementCssPath(".ui-helper-hidden-accessible").getText();
        assertThat(chosenPosition.getAttribute("aria-label")).isEqualTo(displayedPosition);
    }
}
