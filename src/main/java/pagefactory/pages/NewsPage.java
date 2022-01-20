package pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor']/h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    private WebElement firstNews;

    @FindBy(xpath = "//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']")
    private List<WebElement> namesOfArticlesList;

    @FindBy(xpath = "//button[@class='orb-search__button']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class='ssrcss-so3uhw-GlobalNavigationProduct eki2hvo15']/a[@href='https://www.bbc.com/news']")
    private WebElement backToNewsPage;

    @FindBy(xpath = "//li[contains(@class, 'gs-u-float-left nw-c-nav__wide-menuitem-container')]//a[@href='/news/coronavirus']")
    private WebElement coronavirus;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']/a[@class='nw-o-link'][@href='/news/have_your_say']")
    private WebElement coronaStory;

    @FindBy(xpath = "//a[@id='idcta-link']")
    private WebElement signIn;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='button button--full-width']")
    private WebElement signInButton;

    @FindBy(xpath = "//p[@class='form-message__text']/span/span']")
    private WebElement answerForInput;



    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public void search(final String toSearch) {
        driver.findElement((By) searchInput).sendKeys(toSearch);
    }

    public String getTextOfFirstArticle() {
        return firstNews.getText();
    }

    public List<WebElement> getNamesOfArticlesList() {
        return namesOfArticlesList;
    }

    public WebElement getAnswerForInput() {
        return answerForInput;
    }


    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnFirstNewsArticle() {
        firstNews.click();
    }

    public void clickOnBackToNewsPage() {
        backToNewsPage.click();
    }

    public void clickCoronavirus() {
        coronavirus.click();
    }

    public void clickCoronaStory() {
        coronaStory.click();
    }

    public void clickSignIn() { signIn.click();}

    public void inputDataInput(final String email, final String password ) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

}
