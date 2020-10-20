package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ChartSummeryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;

public class MealItemTest extends BasicTest {

	@Test(priority = 0)
	public void addMealToChart() throws InterruptedException {
		this.driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		LocationPopupPage lpp = new LocationPopupPage(driver, wait);

		lpp.closePopUp();
		MealPage mp = new MealPage(driver, wait);

		mp.getFilterResetAll();
		mp.getSearcMeal().click();
		mp.getResetCheef();
		mp.getSearcMeal().sendKeys("GRILLED CUBAN CHICKEN BREAST");
		mp.clickSrcMealBtn();
		mp.addToChart(5);
		String msg = "The Following Errors Occurred:Please Select Location";
		NotificationSystemPage nsp = new NotificationSystemPage(driver, wait);

		Assert.assertTrue(nsp.AlertMsg().contains(msg), "[ERROR] select location first !");

		nsp.MessageDissapear();
		String location = "City Center - Albany";
		lpp.setLocation(location);
		Thread.sleep(3000);
		mp.addToChart(3);
		String msgVerify = "Meal Added To Cart";
		Assert.assertTrue(nsp.AlertMsg().contains(msgVerify), "[ERROR] meal not added to chart ");
		Thread.sleep(3000);

	}

	@Test(priority = 5)
	public void addMealToFavorite() throws InterruptedException {
		this.driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		LocationPopupPage lpp = new LocationPopupPage(driver, wait);

		lpp.closePopUp();
		MealPage mp = new MealPage(driver, wait);

		mp.getSearcMeal().sendKeys("MAHI WITH BEEF BOWL LEMONGRASS");
		mp.clickSrcMealBtn();
		mp.addFavorite();
		String msg = "Please login first!";
		NotificationSystemPage nsp = new NotificationSystemPage(driver, wait);

		Assert.assertTrue(nsp.AlertMsg().contains(msg), "[ERROR], adding meal to favorite failed !");
		LoginPage lp = new LoginPage(driver, wait);

		lp.LogIn(this.email, this.password);
		Thread.sleep(3000);
		this.driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		mp.addFavorite();
		String mssg = "Product has been added to your favorites";
		Assert.assertTrue(nsp.AlertMsg().contains(mssg), "[ERROR] , lobster adding to favorite failed ;)");

	}

	@Test(priority = 10)
	public void cleadChart() throws IOException, InterruptedException {
		this.driver.navigate().to(baseUrl + "/meals");
		LocationPopupPage lpp = new LocationPopupPage(driver, wait);

		lpp.setLocation("City Center - Albany");
		File file = new File("/data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(1);
			String mealUrl = cell.getStringCellValue();
			this.driver.navigate().to(mealUrl);
			Thread.sleep(3000);
			MealPage mp = new MealPage(driver, wait);

			mp.addToChart(3);
			SoftAssert sa = new SoftAssert();
			String saved = "Meal Added To Cart";
			NotificationSystemPage nsp = new NotificationSystemPage(driver, wait);

			sa.assertTrue(nsp.AlertMsg().contains(saved), "[ERROR] meal adding to chart failed!");

		}
		ChartSummeryPage csp = new ChartSummeryPage(driver, wait);

		csp.clearAll();
		String removed = "All meals removed from Cart successfully";
		NotificationSystemPage nsp = new NotificationSystemPage(driver, wait);

		Assert.assertTrue(nsp.AlertMsg().contains(removed), "[ERROR] chart not cleared!");

	}
}
