package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AccordionTests extends TestSetup {

    @Test
    @DisplayName("Accordion Tests")
    @Tag("Accordion")
    @Tag("Widgets")
    void printTextInAccordionWidget() {
        getDriver().get("http://51.75.61.161:9102/accordion.php");

        for (int y = 1; y < 5; ++y) {
            setElementCssPath("#ui-id-" + (y * 2 - 1)).click();
            String sectionOneText = setElementCssPath("#ui-id-" + (y * 2)).getText();
            System.out.println(sectionOneText);
        }
    }
}
