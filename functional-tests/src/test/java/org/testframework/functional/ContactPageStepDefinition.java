package org.testframework.functional;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.testframework.Utils.ManageTest;
import org.testframework.pageobject.ContactPage;

import java.io.IOException;
import java.sql.SQLException;

public class ContactPageStepDefinition extends ManageTest {

    @Before
    public void setUp() throws Exception {
        super.setup();
    }

    @After
    public void tearDown(Scenario scenario) throws SQLException {
        try {
            if (scenario.isFailed()) {
                scenario.embed(testWebDriver.takeScreenShot(), "image/png");
            }
        } finally {
            testWebDriver.quitDriver();
        }
    }

    @Then("^I should see the search bar$")
    public void viewSearchBar() throws IOException {
        ContactPage contactPage = new ContactPage(testWebDriver);
        Assert.assertTrue(contactPage.verifySearchBarPresent());
    }

    @And("^I should see the category dropdown$")
    public void viewCategoryDropDown() throws IOException {
        ContactPage contactPage = new ContactPage(testWebDriver);
        Assert.assertTrue(contactPage.verifyCategoryDropdownPresent());
    }

    @When("^I should see the coffee mug link$")
    public void clickCoffeeMug() throws IOException {
        ContactPage contactPage = new ContactPage(testWebDriver);
        Assert.assertEquals(true, contactPage.verifyCoffeeMugIsClickable());
    }

    @Then("^I should be able to see a form$")
    public void viewForm() throws Throwable {
        ContactPage contactPage = new ContactPage(testWebDriver);
        Assert.assertTrue(contactPage.verifyFormPresent());
    }

    @Then("^I should be able to submit my details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void I_should_be_able_to_enter_my_details_(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        ContactPage contactPage = new ContactPage(testWebDriver);
        contactPage.enterFormDetails(arg1,arg2,arg3,arg4);
    }
}
