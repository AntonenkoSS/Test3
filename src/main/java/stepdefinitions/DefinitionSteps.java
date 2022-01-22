package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.pages.*;

import java.awt.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.Keys.ENTER;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 300;

    WebDriver driver;
    HomePage homePage;
    NewsPage newsPage;
    SearchResultPage searchResultPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void checkLastDivVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isFooterVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @When("User clicks 'Sign In' button")
    public void clickSignInButton() {
        homePage.clickHelloSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks email and password fields visibility on sign in popup")
    public void checkEmailVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInPage());
        assertTrue(homePage.isEmailFieldVisible());
        assertTrue(homePage.isPasswordFieldVisible());
    }

    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(language));
    }

    @When("User clicks 'Hello Sign In' button")
    public void userClicksTodayDealsButton() {
        homePage.clickHelloSignInButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }


    @After
    public void tearDown() {
        driver.close();
    }

    @Then("User checks that current url contains {string}")
    public void userChecksThatCurrentUrlContainsKeyword(final String keyword){
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }
}
