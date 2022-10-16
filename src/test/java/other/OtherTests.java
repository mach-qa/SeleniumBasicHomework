package other;

import base.TestSetup;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class OtherTests extends TestSetup {

    @Test
    @DisplayName("Form Tests")
    @Tag("Form")
    @Tag("Basic")
    void scrollToBottomOfPage() throws IOException {

        getDriver().get("http://51.75.61.161:9102/high-site.php");

        Actions action = new Actions(getDriver());

        WebElement bottomOfPage = getDriver().findElement(By.cssSelector(".high-site-paragraph:last-child"));
        action.scrollToElement(bottomOfPage).perform();

        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/resources/otherTests.jpg"));

        assertThat(bottomOfPage.getText()).isEqualTo("100%");

    }
}
