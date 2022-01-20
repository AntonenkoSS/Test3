package pagefactory.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//li[contains(@class, 'nw-c-nav__wide-menuitem-container')]/a[@class='nw-o-link'][@href='/news/business']")
    private WebElement businessPageButton;

    @FindBy(xpath = "//div[@id='orb-nav-links']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']")
    private WebElement newsPageButton;

    @FindBy(xpath = "//div[contains(@class, 'gs-u-mt gs-u-mt0@xs')]//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']/h3")
    private WebElement nameFirstNews;

    @FindBy(xpath = "//button[@class='orb-search__button']")
    private WebElement searchButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnBusinessPageButton() {
        businessPageButton.click();
    }

    public void clickOnNewsPage() {
        newsPageButton.click();
    }

    public String getTextNameFirstNews() {
        return nameFirstNews.getText();
    }


}
