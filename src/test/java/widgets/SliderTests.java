package widgets;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SliderTests extends TestSetup {

    @Test
    @DisplayName("Slider Tests")
    @Tag("Slider")
    @Tag("Widgets")
    void verifySliderElement() {

        getDriver().get("http://51.75.61.161:9102/slider.php");
        WebElement slider = getDriver().findElement(By.cssSelector("#slider"));
        WebElement buttonText = getDriver().findElement(By.cssSelector("#custom-handle"));

        moveSlider(slider, 50);
        assertThat(buttonText.getText()).isEqualTo("50");

        moveSlider(slider, 80);
        assertThat(buttonText.getText()).isEqualTo("80");

        moveSlider(slider, 20);
        assertThat(buttonText.getText()).isEqualTo("20");

        moveSlider(slider, 0);
        assertThat(buttonText.getText()).isEqualTo("0");
    }

    private void moveSlider (WebElement slider, int position) {
        Actions move = new Actions(getDriver());
        int width=slider.getSize().getWidth();
        move.moveToElement(slider, ((width*(position-50))/100), 0).click();
        move.build().perform();
    }
}