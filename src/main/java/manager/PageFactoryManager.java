package manager;

import org.openqa.selenium.WebDriver;
import pagefactory.pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){ return new HomePage(driver);}

    public NewsPage getNewsPage(){ return new NewsPage(driver);}

    public SearchResultPage getSearchResultPage(){ return new SearchResultPage(driver);}

}
