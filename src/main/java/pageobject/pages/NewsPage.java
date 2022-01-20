package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class NewsPage extends BasePage{

    private static final String SEARCH_INPUT = "//h2[@class='gel-double-pica-bold']";
    private static final String FIRST_NEWS = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']/h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']";
    private static final String NAME_OF_ARTICLES_LIST = "//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']";
    private static final String SEARCH_BUTTON = "//button[@class='orb-search__button']";
    private static final String BACK_TO_NEWS_PAGE = "//li[@class='ssrcss-so3uhw-GlobalNavigationProduct eki2hvo15']/a[@href='https://www.bbc.com/news']";
    private static final String CORONAVIRUS = "//li[contains(@class, 'gs-u-float-left nw-c-nav__wide-menuitem-container')]//a[@href='/news/coronavirus']";
    private static final String CORONA_STORY = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']/a[@class='nw-o-link'][@href='/news/have_your_say']";
    private static final String SIGN_IN = "//a[@id='idcta-link']]";
    private static final String EMAIL_INPUT = "//input[@type='email']";
    private static final String PASSWORD_INPUT = "//input[@type='password']";
    private static final String SIGN_IN_BUTTON = "//button[@class='button button--full-width']";
    private static final String ANSWER_FOR_INPUT = "//p[@class='form-message__text']/span/span']";


    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public void search(final String toSearch) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(toSearch);
    }

    public String getTextOfFirstArticle() {
        return driver.findElement(xpath(FIRST_NEWS)).getText();
    }

    public List<WebElement> getNamesOfArticlesList() {
        return driver.findElements(xpath(NAME_OF_ARTICLES_LIST));
    }

    public WebElement getAnswerForInput() {
        return driver.findElement(xpath(ANSWER_FOR_INPUT));
    }


    public void searchByKeyword(final String keyword) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(keyword);
        driver.findElement(xpath(SEARCH_BUTTON)).click();
    }

    public void clickOnFirstNewsArticle() {
        driver.findElement(xpath(FIRST_NEWS)).click();
    }

    public void clickOnBackToNewsPage() {
        driver.findElement(xpath(BACK_TO_NEWS_PAGE)).click();
    }

    public void clickCoronavirus() {
        driver.findElement(xpath(CORONAVIRUS)).click();
    }

    public void clickCoronaStory() {
        driver.findElement(xpath(CORONA_STORY)).click();
    }

    public void clickSignIn() {
        driver.findElement(xpath(SIGN_IN)).click();
    }

    public void inputDataInput(final String email, final String password ) {
        driver.findElement(xpath(EMAIL_INPUT)).sendKeys(email);
        driver.findElement(xpath(PASSWORD_INPUT)).sendKeys(password);
        driver.findElement(xpath(SIGN_IN_BUTTON)).click();
    }

}

