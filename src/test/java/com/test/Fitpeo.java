package com.test;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Fitpeo {
	public static void main(String[] args) throws AWTException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		WebElement ScrollDown = driver.findElement(By.xpath("(//p[contains(text(),'RPM and CCM ')])[2]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ScrollDown);
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		WebElement s = driver.findElement(By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']"));
		Actions a=new Actions(driver);

	    a.clickAndHold(slider).moveByOffset(93,0).release().perform();
	    
	   WebElement sValue=driver.findElement(By.xpath("//input[@id=':r0:']"));
	   sValue.click();
	   sValue.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
	   sValue.sendKeys("560");
	   String sliderValue = sValue.getAttribute("value");
	   System.out.println("slider value is:"+sliderValue);
	   
	   sValue.click();
	   sValue.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
	   sValue.sendKeys("820");
	   
	   driver.findElement(By.xpath("//p[text()='CPT-99091']/parent::div/descendant::span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1sp9p8c']")).click();
	   driver.findElement(By.xpath("//p[text()='CPT-99453']/parent::div/descendant::span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1sp9p8c']")).click();
	   driver.findElement(By.xpath("//p[text()='CPT-99454']/parent::div/descendant::span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1sp9p8c']")).click();
	   driver.findElement(By.xpath("//p[text()='CPT-99474']/parent::div/descendant::span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1sp9p8c']")).click();
	   
	WebElement txtReimbursement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 inter css-1xroguk'])[4]"));
	String text = txtReimbursement.getText();
	System.out.println(text);
	WebElement txt$ = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]"));
	String text2 = txt$.getText();
	if(text2.equals("$110700")) {
		System.out.println("Total Recurring Reimbursement for all Patients Per Month:"+text2);
		
	}

	}
}
