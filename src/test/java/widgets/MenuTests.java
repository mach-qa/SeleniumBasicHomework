package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class MenuTests extends TestSetup {

    //TODO Do zrobienia

    @Test
    @DisplayName("Menu Tests")
    @Tag("Menu")
    @Tag("Widgets")
    void menuShouldBeExpandable() {

        getDriver().get("http://51.75.61.161:9102/menu-item.php");

        setElementCssPath("#ui-id-16").click();

        String choosenValueFromMenu = setElementCssPath("ul#menu").getAttribute("aria-activedescendant");

    }
}
