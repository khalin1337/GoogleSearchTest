import pages.GoogleSearchPage;
import pages.GoogleResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GoogleResultsPage;
import pages.GoogleSearchPage;

import java.time.Duration;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "searchKeywords")
    public Object[] searchKeywords() {
        String keyword = System.getProperty("searchKeyword","Java");
        return new Object[]{keyword};
    }

    @Test(dataProvider = "searchKeywords")
    public void testGoogleSearch(String keyword) {
        // Відкрити Google
        driver.get("https://www.google.com");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.enterSearchKeyword(keyword);
        searchPage.clickSearchButton();

        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsPageLoaded(), "Results page did not load.");
        Assert.assertTrue(resultsPage.allResultsContainKeyword(keyword),
                "Not all results contain the keyword: " + keyword);
    }
}
