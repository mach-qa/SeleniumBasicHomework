package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProgressBarTests extends TestSetup {

    @Test
    @DisplayName("Progress Bar Tests")
    @Tag("ProgressBar")
    @Tag("Widgets")
    void verifyProgressBarStatus() {

        getDriver().get("http://51.75.61.161:9102/progressbar.php");

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement progressBarStatus = getDriver().findElement(By.xpath("//*[.='Complete!']"));

        System.out.println(progressBarStatus.getText());
    }
}
