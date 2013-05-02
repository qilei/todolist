package test.support.com.voy.todolist.web.page;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class HomePage extends Page {

	public HomePage(WebDriver browser) {
		super(browser);
	}

	public void displays() {
		assertEquals("to do list",browser.getTitle());
	}
	
}
