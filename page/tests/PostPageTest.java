package page.tests;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.PostPage;
import utilites.Constant;
import utilites.ExcelUtils;

public class PostPageTest {

	// *1 Entering data through scanner to make a post
	public static void makePost(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		// Make a new post button
		HomePage.clickMakeAPost(dr);
		// Post naziv
		System.out.println("Enter naziv:");
		String naziv = sc.nextLine();
		PostPage.clickNaziv(dr);
		PostPage.sendKeysNaziv(dr, naziv);
		// Post lokacija
		System.out.println("Enter lokacija:");
		String lokacija = sc.nextLine();
		PostPage.clickLokacija(dr);
		PostPage.sendKeysLokacija(dr, lokacija);
		// Post prevozno sredstvo
		System.out.println(
				"Select prevozno sredstvo. For 'Walk' enter 1, for 'Car' enter 2, for 'Motorbike' enter 3, for 'Bicycle' enter 4 and for 'Bus' enter 5");
		int s = sc.nextInt();
		PostPage.selectPSredstvo(dr, s - 1);
		sc.nextLine();
		// Post opis
		System.out.println("Enter opis:");
		String opis = sc.nextLine();
		PostPage.clickOpis(dr);
		PostPage.sendKeysOpis(dr, opis);

		// Confirming button to make a post
		PostPage.clickPostB(dr);
		sc.close();
	}

	// *2 Making a post using single row data from excel by choosing row (int i)
	// If you want to use data from 3rd row int i=3
	public static void makePostExcel(WebDriver dr, int i) throws IOException {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET2);
		// Clicking make a new post button
		HomePage.clickMakeAPost(dr);
		// Post naziv
		data = ExcelUtils.getCell((i - 1), 0);
		PostPage.clickNaziv(dr);
		PostPage.sendKeysNaziv(dr, data);
		// Post lokacija
		data = ExcelUtils.getCell((i - 1), 1);
		PostPage.clickLokacija(dr);
		PostPage.sendKeysLokacija(dr, data);
		// Post prevozno sredstvo
		int s = Integer.parseInt(ExcelUtils.getCell((i - 1), 2));
		PostPage.selectPSredstvo(dr, s - 1);
		// Post opis
		data = ExcelUtils.getCell((i - 1), 3);
		PostPage.clickOpis(dr);
		PostPage.sendKeysOpis(dr, data);
		// Confirming button to make a post
		PostPage.clickPostB(dr);
	}

	// *3 Making multiple posts using data from excel (one by one)
	public static void makePosts(WebDriver dr) throws IOException {
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET2);
		for (int i = 2; i < ExcelUtils.getWSheet().getLastRowNum() + 2; i++) {
			makePostExcel(dr, i);
		}
	}

}
