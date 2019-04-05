package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostPage {

	public static final String URL = "http://localhost/izlet/dashboard.php#";

	private static final String NAZIV = "//input[@placeholder='Naziv']";
	private static final String LOKACIJA = "//input[@placeholder='Lokacija']";
	private static final String PSREDSTVO = "//select[@name='transport']";
	private static final String OPIS = "//textarea[@placeholder='Opis']";
	private static final String POST = "//input[@value='Post']";
	// "E" at the beginning of String name refers to EDIT
	private static final String ENAZIV = "//input[@id='title']";
	private static final String ELOKACIJA = "//input[@id='location']";
	private static final String EPSREDSTVO = "//div[@class='popupEdit']//select[@name='transport']";
	private static final String EOPIS = "//textarea[@id='description']";
	private static final String EPOST = "//div[@class='popupEdit']//input[@value='Post']";

	// Post naziv
	public static WebElement getNaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(NAZIV));
		return wb;
	}

	public static void clickNaziv(WebDriver dr) {
		getNaziv(dr).click();
	}

	public static void sendKeysNaziv(WebDriver dr, String str) {
		getNaziv(dr).clear();
		getNaziv(dr).sendKeys(str);
	}

	// Post lokacija
	public static WebElement getLokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOKACIJA));
		return wb;
	}

	public static void clickLokacija(WebDriver dr) {
		getLokacija(dr).click();
	}

	public static void sendKeysLokacija(WebDriver dr, String str) {
		getLokacija(dr).clear();
		getLokacija(dr).sendKeys(str);
	}

	// Post select prevozno sredstvo
	public static void selectPSredstvo(WebDriver dr, int i) {
		Select prevoz = new Select(dr.findElement(By.xpath(PSREDSTVO)));
		prevoz.selectByIndex(i);

	}

	// Post opis
	public static WebElement getOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(OPIS));
		return wb;
	}

	public static void clickOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	public static void sendKeysOpis(WebDriver dr, String str) {
		getOpis(dr).clear();
		getOpis(dr).sendKeys(str);
	}

	// Post button
	public static WebElement getPostB(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(POST));
		return wb;
	}

	public static void clickPostB(WebDriver dr) {
		getPostB(dr).click();
	}

	// Edit Naziv in specific post
	public static WebElement getENaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(ENAZIV));
		return wb;
	}

	public static void clickENaziv(WebDriver dr) {
		getENaziv(dr).click();

	}

	public static void sendKeysENaziv(WebDriver dr, String str) {
		getENaziv(dr).clear();
		getENaziv(dr).sendKeys(str);
	}

	// Edit Lokacija in specific post
	public static WebElement getELokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(ELOKACIJA));
		return wb;
	}

	public static void clickELokacija(WebDriver dr) {
		getELokacija(dr).click();
	}

	public static void sendKeysELokacija(WebDriver dr, String str) {
		getELokacija(dr).clear();
		getELokacija(dr).sendKeys(str);
	}

	// Edit Prevozno sredstvo in specific post
	public static void selectEPSredstvo(WebDriver dr, int i) {
		Select prevoz = new Select(dr.findElement(By.xpath(EPSREDSTVO)));
		prevoz.selectByIndex(i);

	}

	// Edit Opis in specific post
	public static WebElement getEOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EOPIS));
		return wb;
	}

	public static void clickEOpis(WebDriver dr) {
		getEOpis(dr).click();
	}

	public static void sendKeysEOpis(WebDriver dr, String str) {
		getEOpis(dr).clear();
		getEOpis(dr).sendKeys(str);
	}

	// Post button
	public static WebElement getEPostB(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EPOST));
		return wb;
	}

	public static void clickEPostB(WebDriver dr) {
		getEPostB(dr).click();
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
