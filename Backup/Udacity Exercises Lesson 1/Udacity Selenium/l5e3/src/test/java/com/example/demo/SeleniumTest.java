package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.xpath.XPath;
import java.util.List;

public class SeleniumTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");
        WebElement inputField = driver.findElement(By.id("animalText"));
        inputField.sendKeys("Tiger");
        inputField = driver.findElement(By.id("adjective"));
        inputField.sendKeys("Gnarly");
        inputField = driver.findElement(By.xpath("//input[@value='submit']"));

        for(int i=0; i < 5 ; i++){
            Thread.sleep(1000);
            inputField = driver.findElement(By.xpath("//input[@value='submit']"));
            inputField.submit();
        }
        /* Code for iterating through trainingResults and outputting each trainingMessage
        List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));
        for(WebElement element : trainingResults){
            String trainingMessage = element.getText();
            System.out.println(trainingMessage);
        }*/
        WebElement conclusionMessage = driver.findElement(By.className("conclusionMessage"));
        String message = conclusionMessage.getText();
        System.out.println(message);
        Thread.sleep(5000);
        driver.quit();

    }
}
