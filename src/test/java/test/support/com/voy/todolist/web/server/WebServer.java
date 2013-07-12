package test.support.com.voy.todolist.web.server;

import java.util.List;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.util.StringUtils;
import org.testinfected.hamcrest.ExceptionImposter;

import com.google.common.collect.Lists;

public class WebServer {

    private static final int SHUTDOWN_TIMEOUT = 1000;
    private static final int MAX_THREADS = 5;
    
    private final Server server=new Server();
    
    private String host;
    private int port;
    private String contextPath;
    private String webAppPath;

    public WebServer(String host, int port, String contextPath, String webAppPath) {
        this.host = host;
        this.port = port;
        this.contextPath = contextPath;
        this.webAppPath = webAppPath;

        configureThreadPool();
        configureConnector();
        bindDefaultHandler();
        configureApplication();
        configureExtraOptions();
    }
    
	private void setTldJarNames() {
		WebAppContext context = (WebAppContext) server.getHandler();
		context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/jstl-[^/]*\\.jar$|.*/.*taglibs[^/]*\\.jar$");
	}

    public void start() {
        try {
            server.start();
        } catch (Exception e) {
            throw ExceptionImposter.imposterize(e);
        }
    }

    public void stop()  {
        try {
            server.stop();
        } catch (Exception e) {
            throw ExceptionImposter.imposterize(e);
        }
    }

    public void stopOnShutdown() {
        server.setStopAtShutdown(true);
    }
    private void configureThreadPool() {
        QueuedThreadPool threadPool = new QueuedThreadPool(MAX_THREADS);
        server.setThreadPool(threadPool);
    }

    private void configureConnector() {
        Connector connector = new SelectChannelConnector();
        connector.setHost(host);
        connector.setPort(port);
        server.addConnector(connector);
    }

    private void bindDefaultHandler() {
        server.setHandler(new HandlerList());
//        server.addHandler(new DefaultHandler());
    }

    private void configureApplication() {
        WebAppContext appContext = new WebAppContext();
        appContext.setContextPath(contextPath);
        appContext.setWar(webAppPath);
        appContext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/jstl-[^/]*\\.jar$|.*/.*taglibs[^/]*\\.jar$");
        server.setHandler(appContext);
    }

    private void configureExtraOptions() {
        server.setGracefulShutdown(SHUTDOWN_TIMEOUT);
    }

}
