package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	

	public WebElement getSearcMeal() {
		return this.driver.findElement(By.className("js-search-keywords"));
	}

	public void clickSrcMealBtn() {
		WebElement src = this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_frmSearchMeals\"]/span/input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", src);
	}

	

	public WebElement latestProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.latestProduct());
		return this.driver.findElement(By.className("sort-toggle is-active"));

	}

	public WebElement getLowtoHigh() {
		return this.driver
				.findElement(By.xpath("//*[@id=\"body\"]/div[2]/section[1]/div/ul/li[2]/div/div/div/ul/li[1]"));
	}

	public WebElement getHightoLow() {
		return this.driver
				.findElement(By.xpath("//*[@id=\"body\"]/div[2]/section[1]/div/ul/li[2]/div/div/div/ul/li[2]"));
	}

	public WebElement getFilterResetAll() {
		return this.driver.findElement(By.className("link reset-all"));
	}

	public WebElement getCheef() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.getCheef());
		return this.driver.findElement(By.className("heading4 heading4-js is-active"));
	}

	public WebElement getResetCheef() {
		return this.driver.findElement(By.className("link js-reset-chef"));
	}

	public WebElement getPriceBtnLeft() {
		return this.driver.findElement(By.className("irs-line-left"));
	}

	public WebElement getPriceBtnRight() {
		return this.driver.findElement(By.className("irs-line-right"));
	}

	public WebElement getResetPrice() {
		return this.driver.findElement(By.className("link js-reset-price"));
	}

	public WebElement getVeganMeal() {
		return this.driver.findElement(
				By.xpath("//*[@id=\"body\"]/div[2]/section[2]/div/div[1]/div[7]/div[2]/ul/li[1]/label/input"));
	}
	public WebElement getNonVeganMeal() {
		return this.driver.findElement(
				By.xpath("//*[@id=\"body\"]/div[2]/section[2]/div/div[1]/div[7]/div[2]/ul/li[2]/label/input"));
	}
	public WebElement getResetVegMeal() {
		return this.driver.findElement(By.className("link js-reset-veg-type"));
	}
	public WebElement getSelectMealType() {
		return this.driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/section[2]/div/div[1]/div[9]/div[2]"));
	}
	public WebElement getResetSelectMealType() {
		return this.driver.findElement(By.className("link js-reset-meal-type"));
	}
	
	public WebElement getSelectCuisineType() {
		return this.driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/section[2]/div/div[1]/div[11]/div[2]/ul"));
	}
	public WebElement getResetCuisineType() { 
		return this.driver.findElement(By.className("link js-reset-cuisine")); 
	}
	public void addToChart(int quantity) {
		WebElement qty = driver.findElement(By.xpath("//*[@id=\"body\"]/section[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[3]/input"));
		 String q= Integer.toString(quantity); 
		 qty.sendKeys(q);
		driver.findElement(By.xpath("//*[@id=\"body\"]/section[1]/div/div/div[2]/div/div[3]/div[2]/a")).click();

		
	}
	public void addFavorite() {
		this.driver.findElement(By.className("svg-icn")).click();
	}

	}
	


