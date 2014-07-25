package org.testframework.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testframework.Utils.TestWebDriver;

import java.io.IOException;


public class HomePage extends Page {


    @FindBy(how = How.CSS, using = "#menu-item-52 > a")
    private static WebElement contactPageLink=null;

    @FindBy(how = How.CSS, using = "#menu-item-27 > a")
    private static WebElement recrutingPageLink=null;

    @FindBy(how = How.CSS, using = "#menu-item-58 > a")
    private static WebElement trainingPageLink=null;

    @FindBy(how = How.CSS, using = "#menu-item-1589 > a")
    private static WebElement publicationPageLink=null;

    @FindBy(how = How.CSS, using = "#menu-item-1561 > a")
    private static WebElement blogPageLink=null;

    @FindBy(how = How.CSS, using = "#menu-item-1518 > a")
    private static WebElement consultingPageLink=null;

    @FindBy(how = How.CSS, using = "div.slider.nivoSlider > img.nivo-main-image")
    private static WebElement ImageCarousel=null;

    private String HOME_PAGE_URL = "http://xndev.com/";


    public HomePage(TestWebDriver driver) throws IOException {
        super(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), 10), this);
        testWebDriver.waitForPageToLoad();
    }

    public void accessHomePage(){
        testWebDriver.setBaseURL(HOME_PAGE_URL);
        testWebDriver.waitForElementToAppear(searchField);
    }

    public void accessRecrutingPage() {
        recrutingPageLink.click();
        testWebDriver.waitForPageToLoad();
    }

    public void accessTrainingPage() {
        trainingPageLink.click();
        testWebDriver.waitForPageToLoad();
    }

    public void accessContactPage() {
        contactPageLink.click();
        testWebDriver.waitForPageToLoad();
    }

    public void accessPublicationPage() {
        publicationPageLink.click();
        testWebDriver.waitForPageToLoad();
    }

    public void accessConsultingPage() {
        consultingPageLink.click();
        testWebDriver.waitForPageToLoad();
    }

    public void accessBlogPage() {
        blogPageLink.click();
        testWebDriver.waitForPageToLoad();
    }

    public void setSearchField(String searchText){
        searchField.clear();
        searchField.sendKeys(searchText);
        searchButton.click();

    }

    public String getSearchResult(int listNumber){
        return searchResultList.get(listNumber).getText();
    }

    public boolean verifyImageCarouselPresent() {
        return ImageCarousel.isDisplayed();
    }
}