package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {

    public FormPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    Random randomGrid = new Random();

    @FindBy(id = "inputFirstName3")
    private WebElement firstName;
    @FindBy(id = "inputLastName3")
    private WebElement lastName;
    @FindBy(id = "inputEmail3")
    private WebElement email;
    public void provideBasicUserData (String firstName, String lastName, String email) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
    }

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexGrid;
    public void selectRandomSexGrid() {
        int sizeOfList = sexGrid.size()-1;
        sexGrid.get(randomGrid.nextInt(sizeOfList)).click();
    }

    @FindBy(css = "#inputAge3")
    private WebElement age;
    public void provideUserAge (String age) {
        this.age.sendKeys(age);
    }

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experience;
    public void selectRandomExperience() {
        int sizeOfList = experience.size()-1;
        experience.get(randomGrid.nextInt(sizeOfList)).click();
    }

    @FindBy(css = ".checkbox-profession")
    private List<WebElement> professions;
    public void selectRandomProfession() {
        int sizeOfList = professions.size()-1;
        professions.get(randomGrid.nextInt(sizeOfList)).click();
    }

    @FindBy(css = "#selectContinents")
    private WebElement continents;
    public void chooseContinent(String name) {
        Select selectContinents = new Select(continents);
        selectContinents.selectByValue(name);
    }

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement seleniumCommandsList;
    public void selectRandomSeleniumCommands (int index) {
        Select selectSeleniumCommands = new Select(seleniumCommandsList);
        selectSeleniumCommands.selectByIndex(index);
    }

    @FindBy(css = "#chooseFile")
    private WebElement chooseFile;
    public void sendFile (String filePath) {
        File file = new File(filePath);
        chooseFile.sendKeys(file.getAbsolutePath());
    }

    @FindBy(css = ".btn-primary")
    private WebElement confirmButton;
    public void clickConfirmationButton() {
        confirmButton.click();
    }

    @FindBy(css= "#validator-message")
    private WebElement validationMessage;
    public String returnValidatorMessage () {
        return this.validationMessage.getText();
    }

}
