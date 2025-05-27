package demo.native_demo;

import demo.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Execution(ExecutionMode.CONCURRENT)
public class AndroidExampleTest extends BaseTest {

    protected AndroidDriver driver = null;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("cloud:com.experitest.ExperiBank/.LoginActivity")
                .setAppPackage("com.experitest.ExperiBank")
                .setAppActivity(".LoginActivity")
                .amend("digitalai:testName", "Android Native Demo")
                .amend("digitalai:accessKey", getProperty("cloud.accessKey"))
                .amend("digitalai:deviceQuery", "@os='android'")
                .amend("digitalai:appiumVersion", "2.18.0");
        driver = new AndroidDriver(new URL(getProperty("cloud.url") + "/wd/hub"), options);
    }

    @Test
    public void androidNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
        driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.id("com.experitest.ExperiBank:id/makePaymentButton")));
        driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
        driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("0501234567");
        driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("John Snow");
        driver.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("50");
        driver.findElement(By.id("com.experitest.ExperiBank:id/countryTextField")).sendKeys("'Switzerland'");
        driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
        driver.findElement(By.id("android:id/button1")).click();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
        driver.quit();
    }
}
