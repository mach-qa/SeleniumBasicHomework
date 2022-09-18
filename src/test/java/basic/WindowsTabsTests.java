package basic;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsTabsTests extends TestSetup {

    @Test
    @DisplayName("Window/Tabs Tests")
    @Tag("Window")
    void shouldOpenNewWindowWithSuccess() throws InterruptedException {

        getDriver().get("https://seleniumui.moderntester.pl/windows-tabs.php");

        String originalWindow = getDriver().getWindowHandle();

        setElementCssPath("#newBrowserWindow").click();

        windowHandleLoop(originalWindow);
        Thread.sleep (5500);

        //getDriver().switchTo().newWindow(WindowType.WINDOW);

        String confirmNewWindowURL = getDriver().getTitle();
        assertThat(confirmNewWindowURL).isEqualTo("Automation Pratice");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);

        ///////////////////////

        setElementCssPath("#newMessageWindow").click();

        windowHandleLoop(originalWindow);
        Thread.sleep (5500);
        //getDriver().switchTo().newWindow(WindowType.WINDOW);

        String confirmNewWindowMessage = setElementCssPath("body").getText();
        assertThat(confirmNewWindowMessage)
                .isEqualTo("Knowledge increases by sharing but not by saving. Please share this website with " +
                        "your friends and in your organization.");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);

        /////////////////
        setElementCssPath("#newMessageWindow").click();

        Thread.sleep (5500);
        windowHandleLoop(originalWindow);

        String confirmNewTabURL = getDriver().getTitle();
        assertThat(confirmNewTabURL).isEqualTo("Automation Pratice");
    }
}
