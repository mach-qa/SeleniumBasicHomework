package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class TableTests extends TestSetup {

    //do poprawienia jeszcze

    @Test
    @DisplayName("Table Tests")
    @Tag("Table")
    void tableShouldContainsSomeData() throws Exception {

        getDriver().get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> mountainsTable = createListOfElementsByCssPath("tbody tr");

        for (WebElement mountain : mountainsTable) {
            String peakHeight = mountain.findElements(By.cssSelector("td")).get(3).getText();
            String peakRegion = mountain.findElements(By.cssSelector("td")).get(2).getText();

            String peakRank = mountain.findElements(By.cssSelector("th")).get(0).getText();
            String peakName = mountain.findElements(By.cssSelector("td")).get(0).getText();
            String peakRange = mountain.findElements(By.cssSelector("td")).get(1).getText();
            if (Integer.parseInt(peakHeight) >= 4000
                    && peakRegion.contains("Switzerland")) {
                System.out.println(peakRank + ". " + peakName + ", " + peakRange);
            }
        }
    }
}
