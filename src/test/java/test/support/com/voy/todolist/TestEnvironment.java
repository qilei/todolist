package test.support.com.voy.todolist;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.openqa.selenium.WebDriver;

import static java.lang.Integer.parseInt;

import test.support.com.voy.todolist.db.Database;
import test.support.com.voy.todolist.db.Spring;
import test.support.com.voy.todolist.web.Routing;
import test.support.com.voy.todolist.web.browser.BrowserControl;
import test.support.com.voy.todolist.web.browser.LastingBrowser;
import test.support.com.voy.todolist.web.server.LastingServer;
import test.support.com.voy.todolist.web.server.ServerLifeCycle;

public class TestEnvironment {

    public static final String APPLICATION_HOST = "application.host";
    public static final String APPLICATION_PORT = "application.port";
    public static final String CONTEXT_PATH = "context.path";
    
    public static final String WEBAPP_PATH = "webapp.path";

    public static final int DEFAULT_TIMEOUT = 5000;

    //private static final String INTEGRATION_TEST_PROPERTIES = "integration/test.properties";

    private static final String TEST_PROPERTIES = "system/test.properties";
    
    private static TestEnvironment environment;

    private Properties props;
    private Routing appRoutes;
    private Spring spring;
    private final ServerLifeCycle serverLifeCycle;
    private final BrowserControl browser;

    public static TestEnvironment load() {
        if (environment == null) {
            environment = load(TEST_PROPERTIES);
        }
        return environment;
    }

    public static TestEnvironment load(final String name) {
        return new TestEnvironment(PropertyFile.load(name));
    }

    public TestEnvironment(Properties properties) {
    	this.props=configure(properties);
        this.spring = new Spring(properties);
        this.serverLifeCycle = selectServer();
        this.browser=selectBrowser();
		this.appRoutes=new Routing(appUrl());
	}

    private Properties configure(Properties settings) {
        Properties actual = new Properties();
        actual.putAll(settings);
        actual.putAll(System.getProperties());
        System.getProperties().putAll(actual);
        return actual;
    }

    public <T> T get(Class<T> type) {
        return spring.getBean(type);
    }
    
    public void wipe(){
    	Database database=Database.connect(spring.getBean(SessionFactory.class));
    	database.clean();
    	database.close();
    }

	private ServerLifeCycle selectServer() {
		return new LastingServer(asString(APPLICATION_HOST),asInt(APPLICATION_PORT),asString(CONTEXT_PATH),asString(WEBAPP_PATH));
	}

	private BrowserControl selectBrowser() {
		return new LastingBrowser();
	}

    public void startServer() {
        serverLifeCycle.start();
    }

    public void stopServer() {
        serverLifeCycle.stop();
    }

	public WebDriver launchBrowser() throws Exception {
		WebDriver webDriver=browser.launch();
		webDriver.navigate().to(appRoutes.toHome());
		return webDriver;
	}

	private String appUrl() {
        return String.format("http://%s:%s%s", asString(APPLICATION_HOST), asString(APPLICATION_PORT), asString(CONTEXT_PATH));
	}

    private String asString(final String key) {
        return props.getProperty(key);
    }

    private int asInt(String key) {
        return parseInt(asString(key));
    }

    private URL asURL(final String key) {
        String url = asString(key);
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(key + " is not a valid url: " + url, e);
        }
    }

    
    
}
