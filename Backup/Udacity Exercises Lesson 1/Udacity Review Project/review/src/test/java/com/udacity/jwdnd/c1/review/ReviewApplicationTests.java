package com.udacity.jwdnd.c1.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private SignupPage signup;
	private LoginPage login;
	private ChatPage chat;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll(){
		driver.quit();
	}



	@Test
	public void testUserSignupLoginMessage() {
		driver.get("http://localhost:" + port + "/signup");
		signup = new SignupPage(driver);
		signup.signup("Frank", "Glantz", "Frank", "Glantz");

		driver.get("http://localhost:" + port + "/login");
		login = new LoginPage(driver);
		login.login("Frank", "Glantz");

		driver.get("http://localhost:" + port + "/chat");
		chat = new ChatPage(driver);
		chat.postMessage("hello", "Say");
		chat.postMessage("bye", "Say");

		List<WebElement> chatMessages = chat.getChatMessages();
		assertEquals("Frank: hello", chatMessages.get(0).getText());
		assertEquals("Frank: bye", chatMessages.get(1).getText());



	}

}
