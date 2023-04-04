package letcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.drive", "E:\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();

		//navigate back
		driver.findElement(By.xpath("//*[text()='Click']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("home")).click();
		Thread.sleep(3000);
		driver.navigate().back();

		//get x&y coordinates
		WebElement element = driver.findElement(By.id("position"));
		Point point = element.getLocation();
		int xcod = point.getX();
		int ycod = point.getY();
		System.out.println("X : "+xcod +" "+"Y : "+ycod);

		// get css value - color
		WebElement color = driver.findElement(By.id("color"));
		String color1=color.getCssValue("Color");
		System.out.println(color1);

		// find size 
		WebElement size = driver.findElement(By.id("property"));
		System.out.println(size.getSize());

		// button enabled or disabled
		WebElement button = driver.findElement(By.id("isDisabled"));
		System.out.println(button.isEnabled());

		//click and hold 
		WebElement clickhold = driver.findElement(By.xpath("//*[text()='Button Hold!']"));
		new Actions(driver).clickAndHold(clickhold).perform();
		
		Thread.sleep(3000);
		
		//driver.close();

	}

}
