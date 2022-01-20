package pageobject.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    private static final int TIME_TO_WAIT = 50;
    private static final String SEARCH_KEYWORD_IN_TITLE = "Word";
    private static final String EXPECTED_NAME_OF_FIRST_ARTICLES = "Tonga says tsunami was 'unprecedented disaster'";
    private static final String EXPECTED_NAME_OF_FIRST_ARTICLES_AFTER_SEARCH = "Bitesize Daily: 9-11 Year Olds: English: Word Classes";
    private static final int EXPECTED_AMOUNT_ARTICLES = 43;
    private static final String EMAIL = "ssantonenko@gmail.com";
    private static final String EMAIL_NOT_CORRECT = "ssantonenko.com";
    private static final String PASSWORD = "password";
    private static final String ANSWER = "Sorry, that password isn't valid";
    private static final String ANSWER_TO_NOT_CORRECT_EMAIL = "Sorry";

    @Test(priority = 1)
    public void checkThatNameOfFirstArticleOnNewsPage() {
        getHomePage().clickOnNewsPage();
        getHomePage().implicitWait(TIME_TO_WAIT);
        Assert.assertEquals(getNewsPage().getTextOfFirstArticle(), EXPECTED_NAME_OF_FIRST_ARTICLES);
    }

    @Test(priority = 2)
    public void checkElementsThatNamesArticlesOnNewsPage() {
        getHomePage().clickOnNewsPage();
        getHomePage().implicitWait(50);
        String[] articles = {
                "Tonga tsunami: Before and after eruption",
                "Nobody told me drinks event broke rules - Johnson",
                "Saudis warned of jail time for posting rumours"
        };    // 43 articles must be!!!  or create FOR from i=3 to size  articles[i] =''

        for (int i = 0; i < getNewsPage().getNamesOfArticlesList().size(); i++) {
            assertEquals(articles[i], getNewsPage().getNamesOfArticlesList().get(i).getText());
        }
        assertEquals(getNewsPage().getNamesOfArticlesList().size(), EXPECTED_AMOUNT_ARTICLES);
    }

    @Test(priority = 3)
    public void checkTakeCategoryAndInputToSearchBar(){
        getHomePage().clickOnNewsPage();
        getNewsPage().implicitWait(TIME_TO_WAIT);
        getNewsPage().clickOnFirstNewsArticle();

        String url = getDriver().getCurrentUrl();
        //https://www.bbc.com/news/world-asia-60034179
        int index1 = url.indexOf("/", 22);
        int index2 = url.indexOf("-", 22);
        String keyword = url.substring(index1,index2);

        getNewsPage().clickOnBackToNewsPage();
        getNewsPage().searchByKeyword(keyword);
        getNewsPage().implicitWait(TIME_TO_WAIT);

        assertTrue(getSearchResultPage().getSearchResultsArticleList().get(0).getText().contains(SEARCH_KEYWORD_IN_TITLE));
        assertEquals(getSearchResultPage().getSearchResultsArticleList().get(0).getText(), EXPECTED_NAME_OF_FIRST_ARTICLES_AFTER_SEARCH);
    }

    @Test(priority = 4)
    public void checkTest1Part2BBC1(){
        getHomePage().clickOnNewsPage();
        getNewsPage().waitForPageLoadComplete(TIME_TO_WAIT);
        getNewsPage().clickCoronavirus();
        getNewsPage().implicitWait(TIME_TO_WAIT);
        getNewsPage().clickCoronaStory();
        getNewsPage().implicitWait(TIME_TO_WAIT);
        getNewsPage().clickSignIn();
        getNewsPage().implicitWait(TIME_TO_WAIT);
        getNewsPage().inputDataInput(EMAIL, PASSWORD);
        getNewsPage().implicitWait(TIME_TO_WAIT);
        assertTrue(getNewsPage().getAnswerForInput().getText().contains(ANSWER));
    }

    @Test(priority = 5)
    public void checkTest2Part2BBC1(){
        getHomePage().clickOnNewsPage();
        getNewsPage().waitForPageLoadComplete(TIME_TO_WAIT);
        getNewsPage().clickCoronavirus();
        getNewsPage().implicitWait(TIME_TO_WAIT);
        getNewsPage().clickCoronaStory();
        getNewsPage().implicitWait(TIME_TO_WAIT);
        getNewsPage().clickSignIn();
        getNewsPage().implicitWait(TIME_TO_WAIT);
        getNewsPage().inputDataInput(EMAIL_NOT_CORRECT, PASSWORD);
        getNewsPage().implicitWait(TIME_TO_WAIT);
        assertTrue(getNewsPage().getAnswerForInput().getText().contains(ANSWER_TO_NOT_CORRECT_EMAIL));
    }




}
