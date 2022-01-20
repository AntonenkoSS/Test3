package pageobject.pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String NAME_FIRST_NEWS = "//div[contains(@class, 'gs-u-mt gs-u-mt0@xs')]//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']/h3";
    private static final String SEARCH_INPUT = "//input[@placeholder='Search']";
    private static final String SEARCH_BUTTON = "//button[@class='orb-search__button']";
    private static final String BUSINESS_PAGE_BUTTON = "//li[contains(@class, 'nw-c-nav__wide-menuitem-container')]/a[@class='nw-o-link'][@href='/news/business']";
    private static final String NEWS_PAGE_BUTTON = "//div[@id='orb-nav-links']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(keyword);
        driver.findElement(xpath(SEARCH_BUTTON)).click();
    }

    public void clickOnBusinessPageButton() {
        driver.findElement(xpath(BUSINESS_PAGE_BUTTON)).click();
    }

    public void clickOnNewsPage() {
        driver.findElement(xpath(NEWS_PAGE_BUTTON)).click();
    }

    public String getTextNameFirstNews() {
        return driver.findElement(xpath(NAME_FIRST_NEWS)).getText();//return String
    }



}
