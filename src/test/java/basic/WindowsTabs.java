package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsTabs extends TestSetup {

    @Test
    @DisplayName("Window/Tabs Tests")
    @Tag("Window")
    void shouldOpenNewWindowWithSuccess() throws InterruptedException {

        getDriver().get("https://seleniumui.moderntester.pl/windows-tabs.php");

        String originalWindow = getDriver().getWindowHandle();

        getDriver().findElement(By.cssSelector("#newBrowserWindow")).click();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep (5500);

        //getDriver().switchTo().newWindow(WindowType.WINDOW);

        String confirmNewWindowURL = getDriver().getTitle();
        assertThat(confirmNewWindowURL).isEqualTo("Automation Pratice");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);

        ///////////////////////

        getDriver().findElement(By.cssSelector("#newMessageWindow")).click();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep (5500);

        //getDriver().switchTo().newWindow(WindowType.WINDOW);

        String confirmNewWindowMessage = getDriver().findElement(By.cssSelector("body")).getText();
        assertThat(confirmNewWindowMessage).isEqualTo("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);

        /////////////////

        getDriver().findElement(By.cssSelector("#newMessageWindow")).click();

        Thread.sleep (5500);

        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        String confirmNewTabURL = getDriver().getTitle();
        assertThat(confirmNewTabURL).isEqualTo("Automation Pratice");

    }
}
