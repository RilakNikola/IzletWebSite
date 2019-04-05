package main;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.HomePage;
import page.objects.IzletPage;

import page.tests.HomePageTest;
import page.tests.IzletLogInTest;
import page.tests.IzletRegTest;
import page.tests.PostPageTest;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		try {
			// Method that opens page
			IzletPage.openPage(dr);
			// Method that registers new user using data entered through scanner
			IzletRegTest.regNewUser(dr);
			// Method that uses all data from excel to register new users (one by one)
			IzletRegTest.mReg(dr);
			// Method that is logging in with data entered through scanner (by user)
			IzletLogInTest.logIn(dr);
			// Method that is logging out user
			HomePageTest.logOut(dr);
			// Method that uses all data from excel to register new users (one by one)
			IzletLogInTest.mLogIn(dr);
			// Method that is logging in with 42nd row data from excel
			IzletLogInTest.logInExcel(dr, 42);
			// Method that makes post with data entered through scanner (by user)
			PostPageTest.makePost(dr);
			// Method that uses all data from excel to make new posts (one by one)
			PostPageTest.makePosts(dr);
			// Method that deletes 2 most recents posts
			HomePageTest.deletePosts(dr, 2);
			// Method that edits first post using data entered through scanner (by user)
			HomePage.clickEdit(dr, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		sc.close();
	}

}
