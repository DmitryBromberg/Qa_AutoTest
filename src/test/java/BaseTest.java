import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.Scanner;

public class BaseTest {

    @Parameters("browser")
    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\X3M\\Desktop\\chromedriver.exe");
        Configuration.browser = "chrome";

    }
    public String getRandomEmail() {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * symbols.length());
            salt.append(symbols.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr+"@gmail.com";

    }
    public String getRandomName() {
        String symbols = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * symbols.length());
            salt.append(symbols.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
