package com.gametest.com.Game;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		String chromedriver = "/Users/chidambaramp/eclipse-workspace/Game/chromedriver";
		System.setProperty("webdriver.chrome.driver", chromedriver);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open facebook
		driver.get("file:///Users/chidambaramp/Downloads/Google.html");
		int randomInt, maxrange = 0;
		int minrange = 0, midrange = 0;
		int i = 0;
		Random rd = new Random();
		randomInt = rd.nextInt(100);
		int firstint = 50;
		driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(firstint));
		driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
		Thread.sleep(2000);
		String range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])")).getText();
		if (range.equals("Last guess was too high!")) {
			maxrange = firstint;
			while (("Last guess was too high!").equals(range)) {
				maxrange -= 10;
				driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(maxrange));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
				range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])")).getText();
			}
			if (range.equals("Last guess was too low!")) {
				midrange = maxrange + 5;
				driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(midrange));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
				range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])")).getText();
				if (range.equalsIgnoreCase("Last guess was too low!")) {
					while (range.equalsIgnoreCase("Last guess was too low!")) {
						midrange += 1;
						driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(midrange));
						Thread.sleep(2000);
						driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
						range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])"))
								.getText();
					}
				} else {
					while (range.equalsIgnoreCase("Last guess was too high!")) {
						midrange -= 1;
						driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(midrange));
						Thread.sleep(2000);
						driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
						range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])"))
								.getText();
					}
				}
			}
		}
		else if (range.equals("Last guess was too low!")) {
			minrange = firstint;
			while (("Last guess was too low!").equals(range)) {
				minrange += 10;
				driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(minrange));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
				range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])")).getText();
			}
			if (range.equals("Last guess was too high!")) {
				midrange = minrange - 5;
				driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(midrange));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
				range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])")).getText();
				if (range.equalsIgnoreCase("Last guess was too low!")) {
					while (range.equalsIgnoreCase("Last guess was too low!")) {
						midrange += 1;
						driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(midrange));
						Thread.sleep(2000);
						driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
						range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])"))
								.getText();
					}
				} else {
					while (range.equalsIgnoreCase("Last guess was too high!")) {
						midrange -= 1;
						driver.findElement(By.xpath("//input[@id='guessField']")).sendKeys(String.valueOf(midrange));
						Thread.sleep(2000);
						driver.findElement(By.xpath("//input[@class='guessSubmit']")).click();
						range = driver.findElement(By.xpath("(//div[@class='resultParas']/p[@class='lowOrHi'])"))
								.getText();
					}
				}
			}
		}
		System.out.println("Congratulations! You have guessed the correct number");
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}
