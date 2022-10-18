package other;

import base.TestSetup;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class OtherTests extends TestSetup {

    @Test
    @DisplayName("Form Tests")
    @Tag("Form")
    @Tag("Basic")
    void scrollToBottomOfPage() throws NoSuchElementException, IOException {

        getDriver().get("http://51.75.61.161:9102/high-site.php");

        Actions action = new Actions(getDriver());

        WebElement paragraph = getDriver().findElement(By.cssSelector(".high-site-paragraph:nth-child(4)"));

        action.scrollToElement(paragraph).scrollByAmount(0,200).perform();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        WebElement submitButton = getDriver().findElement(By.cssSelector("#scroll-button"));

        wait.until(ExpectedConditions.visibilityOf(submitButton));

        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/resources/otherTests.jpg"));

        assertThat(paragraph.getText()).isEqualTo("30%");
    }
}
