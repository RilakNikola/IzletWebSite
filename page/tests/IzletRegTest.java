package page.tests;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.IzletPage;
import utilites.Constant;
import utilites.ExcelUtils;

public class IzletRegTest {

	// *1 Entering data through scanner to register new user
	public static void regNewUser(WebDriver dr) throws IOException {
		Scanner sc = new Scanner(System.in);
		// First name
		System.out.println("Enter first name:");
		String firstName = sc.nextLine();
		IzletPage.clickFirstName(dr);
		IzletPage.sendKeysFirstName(dr, firstName);
		// Last name
		System.out.println("Enter last name:");
		String lastName = sc.nextLine();
		IzletPage.clickLastName(dr);
		IzletPage.sendKeysLastName(dr, lastName);
		// Username
		System.out.println("Enter username:");
		String username = sc.nextLine();
		IzletPage.clickRegUsername(dr);
		IzletPage.sendKeysRegUsername(dr, username);
		// Email
		System.out.println("Enter email:");
		String email = sc.nextLine();
		IzletPage.clickEmail(dr);
		IzletPage.sendKeysEmail(dr, email);
		// Password
		System.out.println("Enter password:");
		String password = sc.nextLine();
		IzletPage.clickRegPassword(dr);
		IzletPage.sendKeysRegPassword(dr, password);
		// Register Button
		IzletPage.clickRegister(dr);
		sc.close();

	}

	// *2 Register new user using single row data from excel by choosing row (int i)
	// If you want to use data from 5th row int i=5
	public static void regNewUserExcel(WebDriver dr, int i) throws IOException {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET1);
		// First name
		data = ExcelUtils.getCell((i - 1), 0);
		IzletPage.clickFirstName(dr);
		IzletPage.sendKeysFirstName(dr, data);
		// Last name
		data = ExcelUtils.getCell((i - 1), 1);
		IzletPage.clickLastName(dr);
		IzletPage.sendKeysLastName(dr, data);
		// Username
		data = ExcelUtils.getCell((i - 1), 2);
		IzletPage.clickRegUsername(dr);
		IzletPage.sendKeysRegUsername(dr, data);
		// Email
		data = ExcelUtils.getCell((i - 1), 3);
		IzletPage.clickEmail(dr);
		IzletPage.sendKeysEmail(dr, data);
		// Password
		data = ExcelUtils.getCell((i - 1), 4);
		IzletPage.clickRegPassword(dr);
		IzletPage.sendKeysRegPassword(dr, data);
		// Register Button
		IzletPage.clickRegister(dr);

	}

	// *3 Register multiple users using data from excel (one by one) and entering
	// Pass or Fail in excel file in specific (i) row
	//
	// Pass/fail check is done by trying to login specific user right after that
	// user is registered
	//
	// If register and login were successful, after entering Pass in excel, program
	// is logging out user, so it can register next user
	//
	// If register was unsuccessful, after entering Fail in excel, program is
	// redirecting back to register page, so it can register next user
	public static void mReg(WebDriver dr) throws Exception {
		// Setting excel file
		ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET1);
		for (int i = 2; i < ExcelUtils.getWSheet().getLastRowNum() + 2; i++) {
			regNewUserExcel(dr, i);
			IzletLogInTest.logInExcel(dr, i);
			// Because another sheet from excel file (sheet3) in
			// IzletLogInTestExcel.logIn(dr,i) method is set, we need to set our sheet1
			// again
			ExcelUtils.setExcelFile(Constant.FILE_PATH + Constant.FILE_NAME, Constant.SHEET1);
			if (dr.getCurrentUrl().equals(HomePage.URL)) {
				ExcelUtils.setCellData("Pass", (i - 1), 5);
				HomePageTest.logOut(dr);
			} else {
				ExcelUtils.setCellData("Fail", (i - 1), 5);
				dr.navigate().to(IzletPage.URL);
			}
		}
	}

}
