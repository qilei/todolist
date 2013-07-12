package test.support.com.voy.todolist.web.server;

public class LastingTomcatServer implements ServerLifeCycle{
	private WebServer server;
	
	public LastingTomcatServer(String host,int port,String contextPath,String webappPath){
		server=new WebServer(host,port,contextPath,webappPath);
	}

	public void start() {
		server.start();
	}

	public void stop() {
		server.stop();
	}

}
