package test.support.com.voy.todolist.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class HomePage extends Page {

	public HomePage(WebDriver browser) {
		super(browser);
	}

	public void displays() {
		assertEquals("Todo List",browser.getTitle());
	}
	
	public void addTask(String taskInfo){
		browser.findElement(By.id("task")).sendKeys(taskInfo);
		browser.findElement(By.id("btnAdd")).click();
	}
	
	public void displayTask(String taskInfo){
		//assertThat(browser.findElement(By.className("table")).getText(),containsString(taskInfo));

		assertThat(browser.findElement(By.xpath("//*[@id='item-0']/td[5]")).getText(),containsString(taskInfo));
		
		//assertThat(browser.findElement(By.cssSelector("#item-0 td.info")).getText(),containsString(taskInfo));
	}
}
