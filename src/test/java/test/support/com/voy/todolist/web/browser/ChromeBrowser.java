package test.support.com.voy.todolist.web.browser;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeBrowser implements BrowserControl {
	
	private static ChromeDriverService service;

    private WebDriver browser;

	public ChromeBrowser() {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File("C:\\Users\\qilei\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"))
				.usingAnyFreePort().build();
		try {
			service.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public WebDriver launch() {
        if (!started()) {
            browser = launchBrowser();
        }
        return browser;
    }

    private boolean started() {
        return browser != null;
    }

    protected WebDriver launchBrowser() {
        	browser = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        Runtime.getRuntime().addShutdownHook(new ShutdownHook(browser));
        return browser;
    }

    private class ShutdownHook extends Thread {
        private ShutdownHook(final WebDriver browser) {
            super(new Runnable() {
                public void run() {
                    browser.quit();
                }
            });
        }
    }
}
