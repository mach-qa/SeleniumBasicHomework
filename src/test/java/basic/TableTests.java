package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableTests extends TestSetup {

    @Test
    @DisplayName("Table Tests")
    @Tag("Table")
    @Tag("Basic")
    void tableShouldContainsSomeData() throws Exception {

        getDriver().get("http://51.75.61.161:9102/table.php");

        List<WebElement> mountainsTable = getDriver().findElements(By.cssSelector("tbody tr"));

        filterTableList(mountainsTable);
    }

    public void filterTableList(List<WebElement> table) {
        for (WebElement index : table) {
            String peakHeight = index.findElements(By.cssSelector("td")).get(3).getText();
            String peakRegion = index.findElements(By.cssSelector("td")).get(2).getText();

            String peakRank = index.findElements(By.cssSelector("th")).get(0).getText();
            String peakName = index.findElements(By.cssSelector("td")).get(0).getText();
            String peakRange = index.findElements(By.cssSelector("td")).get(1).getText();
            if (Integer.parseInt(peakHeight) >= 4000
                    && peakRegion.contains("Switzerland")) {
                System.out.println(peakRank + ". " + peakName + ", " + peakRange);
            }
        }
    }
}
