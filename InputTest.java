package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Downloads\\drivers\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[text()='Edit']")).click();

		driver.findElement(By.id("fullName")).sendKeys("Kalaiselvi"); // send input data

		driver.findElement(By.id("join")).sendKeys(" person",Keys.TAB); // append and press TAB

		WebElement attri = driver.findElement(By.id("getMe")); // get the attributes
		System.out.println(attri.getAttribute("value"));

		driver.findElement(By.id("clearMe")).clear(); // clear the field

		WebElement enable =driver.findElement(By.id("noEdit")); // is enabled
		System.out.println(enable.isEnabled());

		WebElement disable =driver.findElement(By.id("dontwrite"));
		System.out.println(disable.isEnabled());
		
		Thread.sleep(2000);
		driver.close();

	}

}
