package page.tests;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.PostPage;
import utilites.Constant;
import utilites.ExcelUtils;

public class HomePageTest {

	// *1 Log out from the profile
	public static void logOut(WebDriver dr) {
		HomePage.clickLogOut(dr);
	}

	// *2 Deleting a single post. If you want to delete 5th post from site p=5
	public static void deletePost(WebDriver dr, int p) {
		HomePage.clickMore(dr, p - 1);
		HomePage.clickDelete(dr, p - 1);
	}

	// *3 Deleting multiple posts where p represents how many posts you want to
	// delete
	// If you enter p=10 it will delete 10 most recent posts
	public static void deletePosts(WebDriver dr, int p) {
		for (int i = 0, j = 0; j < p; j++) {
			deletePost(dr, i + 1);
		}
	}

	// *4 Editing a post by entering all data through scanner. Int p represents what
	// post you want to edit
	// If you want to edit 9th post, int p=9
	public static void editPost(WebDriver dr, int p) {
		Scanner sc = new Scanner(System.in);
		// More options button
		HomePage.clickMore(dr, (p - 1));
		// Edit button
		HomePage.clickEdit(dr, (p - 1));
		// Naziv
		System.out.println("Enter naziv:");
		String naziv = sc.nextLine();
		PostPage.clickENaziv(dr);
		PostPage.sendKeysENaziv(dr, naziv);
		// Lokacija
		System.out.println("Enter lokacija:");
		String lokacija = sc.nextLine();
		PostPage.clickELokacija(dr);
		PostPage.sendKeysELokacija(dr, lokacija);
		// Prevozno sredstvo
		System.out.println(
				"Select pSredstvo. For 'Walk' enter 1, for 'Car' enter 2, for 'Motorbike' enter 3, for 'Bicycle' enter 4 and for 'Bus' enter 5");
		int s = sc.nextInt();
		PostPage.selectEPSredstvo(dr, s - 1);
		sc.nextLine();
		// Opis
		System.out.println("Enter opis:");
		String opis = sc.nextLine();
		PostPage.clickEOpis(dr);
		PostPage.sendKeysEOpis(dr, opis);
		// Confirm button to edit a post
		PostPage.clickEPostB(dr);
		sc.close();
	}

	// *6 Editing a post using single row data from excel by choosing row.
	// Int p represents what post you want to edit
	// If you want to edit 9th post, int p=9
	// Int i represents what row number from excel you want to use
	// If you want to use 5th row, int i=5
	public static void editPostExcel(WebDriver dr, int p, int i) throws IOException {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET2);
		// More options button
		HomePage.clickMore(dr, (p - 1));
		// Edit button
		HomePage.clickEdit(dr, (p - 1));
		// Naziv
		data = ExcelUtils.getCell((i - 1), 0);
		PostPage.clickENaziv(dr);
		PostPage.sendKeysENaziv(dr, data);
		// Lokacija
		data = ExcelUtils.getCell((i - 1), 1);
		PostPage.clickELokacija(dr);
		PostPage.sendKeysELokacija(dr, data);
		// Prevozno sredstvo
		int s = Integer.parseInt(ExcelUtils.getCell((i - 1), 2));
		PostPage.selectEPSredstvo(dr, s - 1);
		// Opis
		data = ExcelUtils.getCell((i - 1), 3);
		PostPage.clickEOpis(dr);
		PostPage.sendKeysEOpis(dr, data);
		// Confirm button to edit a post
		PostPage.clickEPostB(dr);
	}

	public static void editPostExcel1(WebDriver dr, int p, int i) throws IOException {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET2);
		// More options button
		HomePage.clickMore(dr, (p - 1));
		// Edit button
		HomePage.clickEdit(dr, (p - 1));
		// Naziv
		data = ExcelUtils.getCell((i - 1), 0);
		PostPage.clickENaziv(dr);
		PostPage.sendKeysENaziv(dr, data);
		// Lokacija
		data = ExcelUtils.getCell((i - 1), 1);
		PostPage.clickELokacija(dr);
		PostPage.sendKeysELokacija(dr, data);
		// Prevozno sredstvo
		int s = Integer.parseInt(ExcelUtils.getCell((i - 1), 2));
		PostPage.selectEPSredstvo(dr, s - 1);
		// Opis
		data = ExcelUtils.getCell((i - 1), 3);
		PostPage.clickEOpis(dr);
		PostPage.sendKeysEOpis(dr, data);
		// Confirm button to edit a post
		PostPage.clickEPostB(dr);
	}

//	// *7 Editing mutliple posts with data from excel
//	// Int k represents how many posts you want to edit
//	// If k=5, first 5 posts will be edited
//	// Int i represents with what data rows from excel you want to edit previous 5
//	// posts
//	// If i=5, new data will be from rows 5-9 (one for each previous post)
//	public static void editPostsExcel(WebDriver dr, int k, int i) throws IOException {
//		// Setting excel file
//		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET2);
//		for (int p = 1; p < k + 1; p++, i++) {
//			editPostExcel(dr, p, i);
//		}
//
//	}
}
