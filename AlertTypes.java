package letcode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTypes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[text()='Dialog']")).click();
		Thread.sleep(2000);

		//simple accept alert
		driver.findElement(By.id("accept")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Alert simple = driver.switchTo().alert();
		simple.accept();

		//ok or cancel alert
		driver.findElement(By.id("confirm")).click();
		Alert okCan = driver.switchTo().alert();
		System.out.println(okCan.getText());
		Thread.sleep(2000);
		okCan.dismiss();

		// alert with text
		driver.findElement(By.id("prompt")).click();
		Alert text = driver.switchTo().alert();
		text.sendKeys("Kalaiselvi");
		text.accept();

		//sweet or modern alert
		driver.findElement(By.id("modern")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/app-root/app-alert/section[1]/div/div/div[1]/div/div/div[5]/button")).click();

	}

}
