package test.support.com.voy.todolist.web;

import org.openqa.selenium.WebDriver;

import test.support.com.voy.todolist.TestEnvironment;
import test.support.com.voy.todolist.web.page.HomePage;

public class ApplicationDriver {

    private final TestEnvironment environment;

    private WebDriver browser;
    private HomePage homePage;
    
    public ApplicationDriver(TestEnvironment environment){
    	this.environment=environment;
    }

    public void start() throws Exception {
        cleanupEnvironment();
        startWebServer();
        startBrowser();
        makeDrivers();
    }

    private void cleanupEnvironment() {
    	environment.wipe();
	}

	private void startWebServer() {
        environment.startServer();
    }

    private void startBrowser() throws Exception {
    	this.browser=environment.launchBrowser();
    }

    private void makeDrivers() {
        homePage = new HomePage(browser);
    }

    public void stop() {
        stopServer();
        stopBrowser();
    }

    private void stopBrowser() {
        browser.quit();
    }

    private void stopServer() {
        environment.stopServer();
    }

	public void returnHome() {
        homePage.displays();
	}

}
