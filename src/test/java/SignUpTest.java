import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void zipCodeShouldAccept5Digits(){
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // Ввести в zipCode 5 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        // Нажать кнопку "Continue"
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        // Убедиться, что мы на странице signUp
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplayed);

        // Закрыть браузер
       // driver.quit();

    }

    @Test
    public void zipCodeShouldAccept6Digits(){
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // Ввести в zipCode 6 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");

        // Нажать кнопку "Continue"
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        // Убедиться, что отображена ошибка
        //boolean isDisplayed = driver.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        boolean isDisplayed = driver.findElement(By.className("error_message")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Не отображена ошибка \"Oops, error on page. ZIP code should have 5 digits\"");

        // Закрыть браузер
        // driver.quit();
    }

    @Test
    public void zipCodeShouldAccept4Digits(){
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // Ввести в zipCode 5 цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");

        // Нажать кнопку "Continue"
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        // Убедиться, что отображена ошибка
        boolean isDisplayed = driver.findElement(By.className("error_message")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Не отображена ошибка \"Oops, error on page. ZIP code should have 5 digits\"");

        // Закрыть браузер
         driver.quit();
    }
    
}
