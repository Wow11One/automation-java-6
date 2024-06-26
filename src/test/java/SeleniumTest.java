import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void testThatGooglePageButtonDoesNotHaveText() {
        webDriver.get("https://www.google.com.ua");
        WebElement button = webDriver.findElement(By.xpath("//input[@type='submit']"));

        assertThat(button).isNotNull();
        assertThat(button.getText()).isEmpty();
        assertThat(button.getDomProperty("value")).isEqualTo("Пошук Google");
    }

    @Test
    public void testThatLuckyButtonIsOfSubmitType() {
        webDriver.get("https://www.google.com.ua");
        WebElement button = webDriver.findElement(By.xpath("//input[@value='Мені пощастить']"));

        assertThat(button).isNotNull();
        assertThat(button.getText()).isEmpty();
        assertThat(button.getDomProperty("type")).isEqualTo("submit");
    }

    @Test
    public void testThatLuckyButtonChangesPage() {
        String googleUrl = "https://www.google.com.ua";
        webDriver.get("https://www.google.com.ua");
        WebElement button = webDriver.findElement(By.xpath("//input[@value='Мені пощастить']"));

        assertThat(button).isNotNull();

        button.submit();

        assertThat(webDriver.getCurrentUrl()).isNotEqualTo(googleUrl);
    }
}
