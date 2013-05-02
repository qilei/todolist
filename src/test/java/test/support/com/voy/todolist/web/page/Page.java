package test.support.com.voy.todolist.web.page;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	protected final WebDriver browser;
	
	protected Page(WebDriver browser){
		this.browser=browser;
	}
}
