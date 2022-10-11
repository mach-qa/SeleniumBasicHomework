package intercations;

import base.TestSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Collections;
import java.util.List;

public class SortableTests extends TestSetup {

    //TODO Dokończyć zadanie domowe

    @Test
    @DisplayName("Sortable Tests")
    @Tag("Sortable")
    @Tag("Interactions")
    void itemsAreSortable() {

        getDriver().get("http://51.75.61.161:9102/sortable.php");

        List<WebElement> itemLists = createListOfElementsByCssPath("#sortable span");

//        for (int i = 1; i< itemLists.size(); i++) {
//            WebElement element = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div["+ i +"]"));
//
//            WebElement destination6 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[6]"));
//            WebElement destination5 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[5]"));
//            WebElement destination4 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[4]"));
//            WebElement destination3 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[3]"));
//            WebElement destination2 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[2]"));
//            WebElement destination1 = driver.findElement(By.xpath("//*[@id='demo-tabpane-list']/div/div[1]"));
//
//            Actions action = new Actions(driver);
//
//            if(element!=null) {
//                action.dragAndDrop(element, destination6).perform();
//                action.dragAndDrop(element, destination5).perform();
//                action.dragAndDrop(element, destination4).perform();
//                action.dragAndDrop(element, destination3).perform();
//                action.dragAndDrop(element, destination2).perform();
//                action.dragAndDrop(element, destination1).perform();
//                break;


        }

    }
