package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ChartSummeryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class MealItemTest extends BasicTest {

	LoginPage lp = new LoginPage(driver, wait);

	LocationPopupPage lpp = new LocationPopupPage(driver, wait);
	ChartSummeryPage csp = new ChartSummeryPage(driver, wait);
	MealPage mp = new MealPage(driver, wait);
	NotificationSystemPage nsp = new NotificationSystemPage(driver, wait);

	@Test(priority = 0)
	public void addMealToChart() throws InterruptedException {
		this.driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		lpp.closePopUp();
		mp.getFilterResetAll();
		mp.getSearcMeal().click();
		mp.getResetCheef();
		mp.getSearcMeal().sendKeys("GRILLED CUBAN CHICKEN BREAST");
		mp.clickSrcMealBtn();
		mp.addMeal();
		String msg = "The Following Errors Occurred:Please Select Location";
		Assert.assertTrue(nsp.AlertMsg().contains(msg), "[ERROR] select location first !");
		nsp.MessageDissapear();
		String location = "City Center - Albany";
		lpp.setLocation(location);
		Thread.sleep(3000);
		String msgVerify = "Meal Added To Cart";
		Assert.assertTrue(nsp.AlertMsg().contains(msgVerify), "[ERROR] meal not added to chart ");
		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void addMealToFavorite() throws InterruptedException {
		this.driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		lpp.closePopUp();
		mp.getSearcMeal().sendKeys("MAHI WITH BEEF BOWL LEMONGRASS");
		mp.clickSrcMealBtn();
//		this is add to favorite, but make add to chart
		mp.addMeal();
		String msg = "Please login first!";
		Assert.assertTrue(nsp.AlertMsg().contains(msg), "[ERROR], adding meal to favorite failed !");
		lp.LogIn(this.email, this.password);
		Thread.sleep(3000);
		this.driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		mp.addMeal();
		String mssg = "Product has been added to your favorites";
		Assert.assertTrue(nsp.AlertMsg().contains(mssg), "[ERROR] , lobster adding to favorite failed ;)");

	}
	@Test(priority=10)
	public void cleadChart() throws IOException, InterruptedException { 
		this.driver.navigate().to(baseUrl+"/meals");
		lpp.setLocation("City Center - Albany");
		File file = new File("/data/Data.xlsx");
		FileInputStream fis= new FileInputStream(file); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1); 
		for (int i=1; i<sheet.getLastRowNum(); i++) {
			XSSFRow row= sheet.getRow(i); 
			XSSFCell cell = row.getCell(1); 
			String mealUrl= cell.getStringCellValue(); 
			this.driver.navigate().to(mealUrl);
			Thread.sleep(3000);
			WebElement qty=  this.driver.findElement(By.name("product_qty"));
			qty.clear();
//			parses string to int  
			qty.sendKeys(arg0);
		}
		
		
	}

}
