package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChartSummeryPage extends BasicPage {

	public ChartSummeryPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getClearAllBtn() {
		return this.driver.findElement(By.xpath("//*[@id=\"cartSummary\"]/div/div[1]/a[2]"));
	}

	public void clearAll() {
		JavascriptExecutor js= (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click(); ", this.getClearAllBtn()); 
	}

}
