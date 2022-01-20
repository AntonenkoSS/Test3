package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage {

    private static final String SEARCH_RESULT_ARTICLE_LIST = "//div[@class='ssrcss-11rb3jo-Promo ett16tt0']";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultCount() {
        return getSearchResultsArticleList().size();
    }

    public List<WebElement> getSearchResultsArticleList() {
        return driver.findElements(xpath(SEARCH_RESULT_ARTICLE_LIST));
    }
}
