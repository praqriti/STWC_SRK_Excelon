package org.testframework.functional;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testframework.Utils.ManageTest;
import org.testframework.pageobject.HomePage;

import java.io.IOException;
import java.sql.SQLException;

public class HomeStepDefinitions extends ManageTest {

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


    @Given("^I access excelon home$")
    public void accessExcelonHome() throws IOException {
        HomePage homePage = new HomePage(testWebDriver);
        homePage.accessHomePage();
    }

    @When("^I navigate to contacts page$")
    public void navigateToPage() throws IOException {
      HomePage homePage = new HomePage(testWebDriver);
        homePage.accessContactPage();
    }


    @Then("^I should see the image carousel$")
    public void viewImageCarousel() throws IOException {
       HomePage homePage = new HomePage(testWebDriver);
       homePage.verifyImageCarouselPresent();
    }
}
