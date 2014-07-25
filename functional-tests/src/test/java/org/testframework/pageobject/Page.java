package org.testframework.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testframework.Utils.TestWebDriver;

import java.util.List;

public abstract class Page {

    public TestWebDriver testWebDriver;

    protected Page(TestWebDriver driver) {
        this.testWebDriver = driver;
    }


    @FindBy(how = How.CLASS_NAME, using = "search-input")
    protected static WebElement searchField =null;

    @FindBy(how = How.CSS, using = "#search-2 > div > div > form > div > button")
    protected static WebElement searchButton=null;

    @FindBy(how = How.CSS, using = "#breadcrumbs > div > div > ul > li.active > span")
    private static WebElement currentBreadcrumb=null;

    @FindBy(how = How.CSS, using = "post_list post_list_paginated archive search-results")
    private static WebElement searchResult=null;

    @FindBy(how = How.CSS, using = "article[id$='post-']")
    protected static List<WebElement> searchResultList=null;

    @FindBy(how = How.CSS, using = "#text-6 > div > div > div > div > a.hoverfade")
    private static WebElement coffeeMugLink=null;

    @FindBy(how = How.CSS, using = "#cat")
    private static WebElement categoryDropDown=null;

    public boolean verifySearchBarPresent() {
        return searchField.isDisplayed();
    }

    public boolean verifyCategoryDropdownPresent() {
        return categoryDropDown.isDisplayed();
    }

    public boolean verifyCoffeeMugIsClickable() {
       return  coffeeMugLink.isEnabled();
    }
}