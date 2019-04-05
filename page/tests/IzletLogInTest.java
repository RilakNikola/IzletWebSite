package page.tests;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;

import page.objects.IzletPage;
import utilites.Constant;
import utilites.ExcelUtils;

public class IzletLogInTest {

	// *1 Entering data through scanner to login
	public static void logIn(WebDriver dr) throws IOException {
		Scanner sc = new Scanner(System.in);
		// Username
		System.out.println("Enter username:");
		String username=sc.nextLine();
		IzletPage.clickLUsername(dr);
		IzletPage.sendKeysLUsername(dr, username);
		// Password
		System.out.println("Enter password: ");
		String pass = sc.nextLine();
		IzletPage.clickLPassword(dr);
		IzletPage.sendKeysLPassword(dr, pass);
		// Log in button
		IzletPage.clickLogInButton(dr);
		sc.close();
	}

	// *2 Login using single row data from excel by choosing row (int i)
	// If you want to use data from 7th row int i=7
	public static void logInExcel(WebDriver dr, int i) throws Exception {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET3);
		// Username
		data = ExcelUtils.getCell((i - 1), 2);
		IzletPage.clickLUsername(dr);
		IzletPage.sendKeysLUsername(dr, data);
		// Password
		data = ExcelUtils.getCell((i - 1), 4);
		IzletPage.clickLPassword(dr);
		IzletPage.sendKeysLPassword(dr, data);
		// Log in button
		IzletPage.clickLogInButton(dr);

	}

	// *3 Login using multiple data from excel (one by one) and entering Pass or
	// Fail in excel file in specific (i) row
	//
	// If login was successful, after entering Pass in excel, program is logging out
	// from specific profile, so it can log in with next user
	//
	// If login was unsuccessful, after entering Fail in excel program is
	// redirecting
	// back to login page, so it can log in with next user
	public static void mLogIn(WebDriver dr) throws Exception {
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET3);
		for (int i = 2; i < ExcelUtils.getWSheet().getLastRowNum() + 2; i++) {
			logInExcel(dr, i);
			if (dr.getCurrentUrl().equals(HomePage.URL)) {
				ExcelUtils.setCellData("Pass", (i - 1), 5);
				HomePageTest.logOut(dr);
			} else
				ExcelUtils.setCellData("Fail", (i - 1), 5);
			IzletPage.navigateTo(dr);

		}
	}

}
