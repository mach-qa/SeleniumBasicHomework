package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsTabsTests extends TestSetup {

    @Test
    @DisplayName("Window/Tabs Tests")
    @Tag("Window")
    @Tag("Basic")
    void shouldOpenNewWindowWithSuccess() {

        getDriver().get("http://51.75.61.161:9102/windows-tabs.php");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        String originalWindow = getDriver().getWindowHandle();
        setElementCssPath("#newBrowserWindow").click();

        windowHandleLoop(originalWindow);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        List<WebElement> newBrowserMountainsTable = createListOfElementsByCssPath("tbody tr");
        printMountainsFromTable(newBrowserMountainsTable);

        getDriver().close();
        getDriver().switchTo().window(originalWindow);

        ///////////////////////

        setElementCssPath("#newMessageWindow").click();

        windowHandleLoop(originalWindow);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        String confirmNewWindowMessage = setElementCssPath("body").getText();
        assertThat(confirmNewWindowMessage)
                .isEqualTo("Knowledge increases by sharing but not by saving. Please share this website with " +
                        "your friends and in your organization.");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);

        /////////////////
        setElementCssPath("#newBrowserTab").click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        windowHandleLoop(originalWindow);

        List<WebElement> newTabMountainsTable = createListOfElementsByCssPath("tbody tr");

        printMountainsFromTable(newTabMountainsTable);

        getDriver().close();
    }

    private void printMountainsFromTable(List<WebElement> mountainsTable) {
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

    private void windowHandleLoop (String originalWindow){
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}