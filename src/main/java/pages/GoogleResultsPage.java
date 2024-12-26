package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

public class GoogleResultsPage {
    private WebDriver driver;

    // Локатори
    private By resultTitles = By.xpath("//div[@class='MjjYud']//h3");

    // Конструктор
    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Перевірка, що сторінка результатів завантажилась
    public boolean isResultsPageLoaded() {
        return driver.findElements(resultTitles).size() > 0;
    }

    // Отримання всіх результатів
    public List<WebElement> getAllResults() {
        return driver.findElements(resultTitles);
    }

    // Перевірка, що всі результати містять ключове слово
    public boolean allResultsContainKeyword(String keyword) {
    boolean Check = true;
    String temp;
        for (WebElement result : getAllResults()  ) {
            temp = result.getText();
            if (!temp.isEmpty())
            {
                Check = temp.contains(keyword);
                //System.out.println(result.getText());
            }
        }
        return Check;
    }
}
