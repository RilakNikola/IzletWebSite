package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static final String URL = "http://localhost/izlet/dashboard.php";
	private static final String MAKEAPOST = "//a[contains(text(),'Make a post')]";
	private static final String LOGOUT = "//a[contains(text(),'Logout')]";
	private static final String MORE = "fa-ellipsis-v";
	private static final String EDIT = "fa-edit";
	private static final String DELETE = "fa-trash-alt";

	// Make a post
	public static WebElement getMakeAPost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(MAKEAPOST));
		return wb;
	}

	public static void clickMakeAPost(WebDriver dr) {
		getMakeAPost(dr).click();
	}

	// More button
	public static WebElement getMore(WebDriver dr, int i) {
		List<WebElement> list = dr.findElements(By.className(MORE));
		WebElement wb = list.get(i);
		return wb;
	}

	public static void clickMore(WebDriver dr, int i) {
		getMore(dr, i).click();
	}

	// Delete a post
	public static WebElement getDelete(WebDriver dr, int i) {
		List<WebElement> list = dr.findElements(By.className(DELETE));
		WebElement wb = list.get(i);
		return wb;
	}

	public static void clickDelete(WebDriver dr, int i) {
		getDelete(dr, i).click();
	}

	// Edit a post
	public static WebElement getEdit(WebDriver dr, int i) {
		List<WebElement> list = dr.findElements(By.className(EDIT));
		WebElement wb = list.get(i);
		return wb;
	}

	public static void clickEdit(WebDriver dr, int i) {
		getEdit(dr, i).click();
	}

	// Log out
	public static WebElement getLogOut(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOGOUT));
		return wb;
	}

	public static void clickLogOut(WebDriver dr) {
		getLogOut(dr).click();
	}

	// Open page
	public static void openPage(WebDriver dr) {
		dr.get(URL);
	}

	// Navigate to page
	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(URL);
	}

}
