import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidExampleTest extends BaseTest {
	
	protected AndroidDriver<AndroidElement> driver = null;

	@BeforeEach
	public void setUp() throws MalformedURLException {
		dc.setCapability("testName", "Android Native Demo");
		dc.setCapability("accessKey", getProperty("cloud.accessKey"));
		dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		driver = new AndroidDriver<>(new URL(new URL(getProperty("cloud.url")), "/wd/hub"), dc);
	}
	
	@Test
	public void quickStartAndroidNativeDemo() {
		driver.rotate(ScreenOrientation.PORTRAIT);
		driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
		driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
		driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
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