package test.support.com.voy.todolist.web.server;

import java.io.File;

import org.testinfected.hamcrest.ExceptionImposter;

public class TomcatWebServer {

//    private static final int SHUTDOWN_TIMEOUT = 1000;
//    private static final int MAX_THREADS = 5;
//    
//    private final Tomcat tomcat = new Tomcat();
//    
//    private String host;
//    private int port;
//    private String contextPath;
//    private String webAppPath;
//
//    public TomcatWebServer(String host, int port, String contextPath, String webAppPath) {
//        this.host = host;
//        this.port = port;
//        this.contextPath = contextPath;
//        this.webAppPath = webAppPath;
//    }
//
//    public void start() {
//        try {
//            tomcat.setPort(Integer.valueOf(port));
//            tomcat.addWebapp("/todolist", new File(webAppPath).getAbsolutePath());
//            System.out.println("configuring app with basedir: " + new File("./" + webAppPath).getAbsolutePath());
//
//            tomcat.start();
////            tomcat.getServer().await();  
//        } catch (Exception e) {
//            throw ExceptionImposter.imposterize(e);
//        }
//    }
//
//    public void stop()  {
//        try {
//        	tomcat.stop();
//        } catch (Exception e) {
//            throw ExceptionImposter.imposterize(e);
//        }
//    }


}
