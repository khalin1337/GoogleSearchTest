package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
    private WebDriver driver;

    // Локатори
    private By searchInput = By.xpath("//textarea[@name='q']");
    private By searchButton = By.xpath("//input[@name='btnK']");

    // Конструктор
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методи взаємодії з елементами
    public void enterSearchKeyword(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).submit();
    }
}
