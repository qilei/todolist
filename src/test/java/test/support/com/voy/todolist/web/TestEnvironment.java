package test.support.com.voy.todolist.web;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import test.support.com.voy.todolist.PropertyFile;
import test.support.com.voy.todolist.web.browser.BrowserControl;
import test.support.com.voy.todolist.web.browser.LastingBrowser;
import test.support.com.voy.todolist.web.server.LastingServer;
import test.support.com.voy.todolist.web.server.ServerLifeCycle;

import static java.lang.Integer.parseInt;

public class TestEnvironment {

	public static final String SERVER_LIFECYCLE = "server.lifecycle";
    public static final String WEBAPP_PATH = "webapp.path";
    public static final String CONTEXT_PATH = "context.path";

    public static final String SERVER_HOST = "server.host";
    public static final String SERVER_PORT = "server.port";

    public static final String APPLICATION_HOST = "application.host";
    public static final String APPLICATION_PORT = "application.port";

    public static final String BROWSER_LIFECYCLE = "browser.lifecycle";
    public static final String BROWSER_REMOTE_URL = "browser.remote.url";
    public static final String BROWSER_REMOTE_CAPABILITY = "browser.remote.capability.";

    public static final String EXTERNAL = "external";
    public static final String LASTING = "lasting";
    public static final String PASSING = "passing";
    public static final String REMOTE = "remote";

    public static final int DEFAULT_TIMEOUT = 5000;

    private static final String TEST_PROPERTIES = "system/test.properties";
    private static TestEnvironment environment;
    
    private Properties props;
    private Routing appRoutes;
    private ServerLifeCycle server;
    private BrowserControl browser;
    
    public static TestEnvironment load(){
    	if(environment == null){
    		environment=load(TEST_PROPERTIES);
    	}
    	return environment;
    }

	private static TestEnvironment load(String testProperties) {
		return new TestEnvironment(PropertyFile.load(testProperties));
	}
	
	public TestEnvironment(Properties props){
		this.props=configure(props);
		this.server=selectServer();
		this.browser=selectBrowser();
		this.appRoutes=new Routing(appUrl());
	}

	private String appUrl() {
        return String.format("http://%s:%s%s", asString(APPLICATION_HOST), asString(APPLICATION_PORT), asString(CONTEXT_PATH));
	}

	private BrowserControl selectBrowser() {
		return new LastingBrowser();
	}

	private ServerLifeCycle selectServer() {
		return new LastingServer(asString(SERVER_HOST),asInt(SERVER_PORT),asString(CONTEXT_PATH),asString(WEBAPP_PATH));
	}

	private String asString(String key) {
		return props.getProperty(key);
	}
	
	private int asInt(String key){
		return parseInt(asString(key));
	}

	private Properties configure(Properties config) {
		Properties actual=new Properties();
		actual.putAll(config);
		actual.putAll(System.getProperties());
		System.getProperties().putAll(actual);
		return actual;
	}

	public void startServer() {
		server.start();
	}

	public WebDriver launchBrowser() throws Exception {
		WebDriver webDriver=browser.launch();
		webDriver.navigate().to(appRoutes.toHome());
		return webDriver;
	}

	public void stopServer() {
		server.stop();
	}

}
