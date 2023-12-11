package week2.day4assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) 
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='Basic']")).click();
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'Tri')]//following::div[contains(@id,'Tri')]")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'toggleswitch-slider')]")).click();
		
		driver.findElement(By.xpath("//div[contains(@class,'selectcheckboxmenu-multiple')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'selectcheckboxmenu-header')]//following::label[text()='Paris']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'selectcheckboxmenu-header')]//following::label[text()='Barcelona']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[contains(@class,'selectcheckboxmenu-multiple')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String checked = driver.findElement(By.xpath("//span[text()='Checked']")).getText();
		if(checked.equalsIgnoreCase("Checked"))
		{
			System.out.println(checked);
		}
		else
			System.out.println("String is not as expected");
		boolean checkboxState = driver.findElement(By.xpath("//div[contains(@class,'ui-state-disabled')]")).isEnabled();
		if(checkboxState==false)
		{
			System.out.println("checkbox is disabled");
		}
		String triState = driver.findElement(By.xpath("//span[text()='State has been changed.']")).getText();
		System.out.println(triState);
		if(triState.equalsIgnoreCase("State has been changed."))
		{
			System.out.println(triState);
		}
		else
			System.out.println("String is not displayed as expected");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.quit();

	}
}