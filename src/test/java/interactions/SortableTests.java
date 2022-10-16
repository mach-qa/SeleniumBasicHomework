package interactions;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collections;
import java.util.List;

public class SortableTests extends TestSetup {

    @Test
    @DisplayName("Sortable Tests")
    @Tag("Sortable")
    @Tag("Interactions")
    void itemsAreSortable() {

        getDriver().get("http://51.75.61.161:9102/sortable.php");

        List<WebElement> shuffledListOfItems = getDriver().findElements(By.cssSelector("#sortable li"));

        Collections.shuffle(shuffledListOfItems);

        Actions actions = new Actions(getDriver());

        for (int i=0; i < shuffledListOfItems.size(); i++) {
            WebElement elementByOrder = getDriver().findElement(By.xpath("//*[@id='sortable']//li["+(i+1)+"]"));
            actions.dragAndDrop(shuffledListOfItems.get(i), elementByOrder).perform();
        }

        for (WebElement listRow : shuffledListOfItems) {
            System.out.println("Element: " +listRow.getText() + ", Location: " + listRow.getLocation());
        }
    }
}
