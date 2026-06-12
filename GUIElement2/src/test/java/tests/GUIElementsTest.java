package tests;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ScreenshotUtil;

public class GUIElementsTest extends BaseTest {

	@Test
	public void automateGUIElements() throws Exception {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Name
		driver.findElement(By.id("name")).sendKeys("Agam ");

//		System.out.println("Before Screenshot");

		ScreenshotUtil.takeScreenshot(driver, "NameEntered");

//		System.out.println("After Screenshot");
		// Email
		driver.findElement(By.id("email")).sendKeys("agam@gmail.com");

		// Phone
		driver.findElement(By.id("phone")).sendKeys("9876543210");

		// Address
		driver.findElement(By.id("textarea")).sendKeys("Noida, India");

		System.out.println("Text Fields Completed");

		// Gender
		driver.findElement(By.id("male")).click();

		System.out.println("Gender Selected");

		// Dynamic button
		driver.findElement(By.xpath("//button[@name='start']")).click();
		ScreenshotUtil.takeScreenshot(driver, "Dynamic_button");
		
		
		
		// Days
		driver.findElement(By.id("monday")).click();
		driver.findElement(By.id("wednesday")).click();
		driver.findElement(By.id("friday")).click();

		System.out.println("Checkboxes Selected");

		// Country
		Select country = new Select(driver.findElement(By.id("country")));

		country.selectByVisibleText("India");

		System.out.println("Country Selected");

		// Colors
		Select colors = new Select(driver.findElement(By.id("colors")));

		colors.selectByVisibleText("Blue");

		System.out.println("Color Selected");

		// Sorted List
		Select animals = new Select(driver.findElement(By.id("animals")));

		animals.selectByVisibleText("Lion");

		System.out.println("Animal Selected");

		// Date Picker
		driver.findElement(By.id("datepicker")).sendKeys("06/10/2026");

		System.out.println("Date Selected");

		// File Upload
		WebElement upload = driver.findElement(By.id("singleFileInput"));

		File file = new File("sample.text");

		System.out.println("File Path: " + file.getAbsolutePath());
		System.out.println("File Exists: " + file.exists());

		upload.sendKeys(file.getAbsolutePath());

		System.out.println("File Uploaded");

		// Slider
		WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][1]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value=80;", slider);

		System.out.println("Slider Moved");

		// Double Click
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));

		Actions act = new Actions(driver);

		act.doubleClick(doubleClickBtn).perform();

		System.out.println("Double Click Performed");

		// Drag and Drop
		WebElement source = driver.findElement(By.id("draggable"));

		WebElement target = driver.findElement(By.id("droppable"));

		act.dragAndDrop(source, target).perform();

		System.out.println("Drag And Drop Completed");

		Assert.assertEquals(target.getText(), "Dropped!");

		System.out.println("Drop Verified");

		// Alert
		driver.findElement(By.id("alertBtn")).click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		System.out.println("Alert Handled");

		Thread.sleep(3000);
	}
}