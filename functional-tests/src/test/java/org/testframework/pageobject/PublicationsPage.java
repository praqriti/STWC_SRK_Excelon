package org.testframework.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testframework.Utils.TestWebDriver;

import java.io.IOException;


public class PublicationsPage extends Page {


    @FindBy(how = How.CSS, using = "#menu-item-52 > a")
    private static WebElement contactPageLink=null;


    public PublicationsPage(TestWebDriver driver) throws IOException {
        super(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 10), this);
        testWebDriver.waitForPageToLoad();
    }
}