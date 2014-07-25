package org.testframework.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testframework.Utils.TestWebDriver;

import java.io.IOException;


public class ContactPage extends Page {


    @FindBy(how = How.CSS, using = "#menu-item-52 > a")
    private static WebElement formHeading=null;

    @FindBy(how = How.CSS, using = "#menu-item-52 > a")
    private static WebElement formbody=null;

    @FindBy(how = How.CSS, using = "#menu-item-52 > a")
    private static WebElement formFooter=null;

    @FindBy(how = How.CSS, using = "#input_2_1_3")
    private static WebElement firstNameField=null;

    @FindBy(how = How.CSS, using = "#input_2_1_6")
    private static WebElement lastNameField=null;

    @FindBy(how = How.CSS, using = "#input_2_2")
    private static WebElement emailField=null;

    @FindBy(how = How.CSS, using = "#input_2_3")
    private static WebElement messageField=null;

    @FindBy(how = How.CSS, using = "#gform_submit_button_2")
    private static WebElement submitButton=null;


    public ContactPage(TestWebDriver driver) throws IOException {
        super(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 10), this);
        testWebDriver.waitForPageToLoad();
    }


    public void enterFormDetails(String firstName,String lastName,String message,String email) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        messageField.sendKeys(message);
        submitButton.click();
        testWebDriver.waitForPageToLoad();
    }

    public boolean verifyFormPresent() {
        formHeading.isDisplayed();
        formFooter.isDisplayed();
        return formbody.isDisplayed();
    }
}