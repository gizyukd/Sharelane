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

    @Test
    public void successfulSignUp(){
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

        //Ввести имя
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("TestName");

        //Ввести фамилию
        WebElement LastNameInput = driver.findElement(By.name("last_name"));
        LastNameInput.sendKeys("TestLastName");

        //Ввести Email
        WebElement EmailInput = driver.findElement(By.name("email"));
        EmailInput.sendKeys("test@testmail.test");

        //Ввести пароль
        WebElement PasswordInput = driver.findElement(By.name("password1"));
        PasswordInput.sendKeys("12345678");

        //Повторно ввести пароль
        WebElement RepeatPasswordInput = driver.findElement(By.name("password2"));
        RepeatPasswordInput.sendKeys("12345678");

        // Нажать кнопку "Register"
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        // Проверка на отображение страницы с текстом об успешной регистрации
        WebElement confirmMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(confirmMessage.isDisplayed());
        Assert.assertEquals(confirmMessage.getText(), "Account is created!");

        //  Закрыть браузер
        //  driver.quit();
    }

    @Test
    public void SignUpWithPassIsNotTheSameAsRepeatPass(){
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

        //Ввести имя
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("TestName");

        //Ввести фамилию
        WebElement LastNameInput = driver.findElement(By.name("last_name"));
        LastNameInput.sendKeys("TestLastName");

        //Ввести Email
        WebElement EmailInput = driver.findElement(By.name("email"));
        EmailInput.sendKeys("test@testmail.test");

        //Ввести пароль
        WebElement PasswordInput = driver.findElement(By.name("password1"));
        PasswordInput.sendKeys("12345678");

        //Повторно ввести пароль
        WebElement RepeatPasswordInput = driver.findElement(By.name("password2"));
        RepeatPasswordInput.sendKeys("12345679");

        // Нажать кнопку "Register"
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        // Проверка на отображение страницы с текстом об успешной регистрации
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used");

        //  Закрыть браузер
        //  driver.quit();
    }

    @Test
    public void SignUpWithInvalidEmail(){
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

        //Ввести имя
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("TestName");

        //Ввести фамилию
        WebElement LastNameInput = driver.findElement(By.name("last_name"));
        LastNameInput.sendKeys("TestLastName");

        //Ввести Email
        WebElement EmailInput = driver.findElement(By.name("email"));
        EmailInput.sendKeys("invalidemail");

        //Ввести пароль
        WebElement PasswordInput = driver.findElement(By.name("password1"));
        PasswordInput.sendKeys("12345678");

        //Повторно ввести пароль
        WebElement RepeatPasswordInput = driver.findElement(By.name("password2"));
        RepeatPasswordInput.sendKeys("12345679");

        // Нажать кнопку "Register"
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        // Проверка на отображение страницы с текстом об успешной регистрации
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used");

        //  Закрыть браузер
        //  driver.quit();
    }

    @Test
    public void CheckPassInputIsMasked(){
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

        //Проверить поле пароля на тип поля "Пароль"
        WebElement PasswordInput = driver.findElement(By.name("password1"));
        Assert.assertEquals(PasswordInput.getAttribute("type"),"password");

    }

    @Test
    public void successfulSignUpWithoutLastName(){
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

        //Ввести имя
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("TestName");

        //Ввести Email
        WebElement EmailInput = driver.findElement(By.name("email"));
        EmailInput.sendKeys("test@testmail.test");

        //Ввести пароль
        WebElement PasswordInput = driver.findElement(By.name("password1"));
        PasswordInput.sendKeys("12345678");

        //Повторно ввести пароль
        WebElement RepeatPasswordInput = driver.findElement(By.name("password2"));
        RepeatPasswordInput.sendKeys("12345678");

        // Нажать кнопку "Register"
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        // Проверка на отображение страницы с текстом об успешной регистрации
        WebElement confirmMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(confirmMessage.isDisplayed());
        Assert.assertEquals(confirmMessage.getText(), "Account is created!");


    }
    
}
