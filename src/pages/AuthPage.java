package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
public WebElement getAccount() {
	return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li[1]"));
}
public WebElement getMyAccount() {
	return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[1]"));
}
public WebElement getLogout() {
	return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[2]"));
}
public void logOut() { 
	this.getLogout().click();
}

}
