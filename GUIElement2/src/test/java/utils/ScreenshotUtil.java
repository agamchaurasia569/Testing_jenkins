package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void takeScreenshot(WebDriver driver, String fileName) {

		System.out.println("Screenshot method started");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File folder = new File("./Screenshots");
		if (!folder.exists()) {
			folder.mkdirs();
		}

		File dest = new File("./Screenshots/" + fileName + ".png");

		System.out.println("Saving to: " + dest.getAbsolutePath());

		try {
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}