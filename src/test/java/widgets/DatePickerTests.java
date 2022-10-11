package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class DatePickerTests extends TestSetup {

    //TODO Do zrobienia od nowa

    @Test
    @DisplayName("DatePicker Tests")
    @Tag("DatePicker")
    @Tag("Widgets")
    void shouldChooseDateFromDatePickerWidget() {
        getDriver().get("http://51.75.61.161:9102/datepicker.php");

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        setElementCssPath("#datepicker").click();

        //This is from date picker table
        //WebElement dateWidgetFrom = wait.until(
                //ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar"))).get(0);

    }
}
