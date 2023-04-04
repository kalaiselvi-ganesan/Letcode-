package letcode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectOptions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/test");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[text()='Drop-Down']")).click();
		Thread.sleep(2000);

		//visible text
		WebElement fruits = driver.findElement(By.id("fruits"));
		Select sel = new Select(fruits);
		sel.selectByVisibleText("Apple");

		//is contain multiple options and select multiple values 
		Select list = new Select(driver.findElement(By.id("superheros")));
		System.out.println(list.isMultiple());
		if(list.isMultiple()) {
			list.selectByVisibleText("Ant-Man");
			list.selectByVisibleText("Batman");
			list.selectByVisibleText("The Avengers");
		}

		// select last value and print all options
		Select lang = new Select(driver.findElement(By.id("lang")));
		lang.selectByIndex(4);

		List<WebElement> langAll = lang.getOptions();
		for(WebElement  all : langAll) {
			System.out.println(all.getText());
		}

		//select the value by select by value and print the selected value
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByValue("India");

		WebElement ctry = country.getFirstSelectedOption();
		String selectedoption = ctry.getText();
		System.out.println("Selected element: " + selectedoption);

		Thread.sleep(3000);
		driver.close();
	}

}
