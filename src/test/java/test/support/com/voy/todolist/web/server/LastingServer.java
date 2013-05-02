package test.support.com.voy.todolist.web.server;

public class LastingServer implements ServerLifeCycle{
	private WebServer server;
	
	public LastingServer(String host,int port,String contextPath,String webappPath){
		server=new WebServer(host,port,contextPath,webappPath);
	}

	public void start() {
		server.start();
	}

	public void stop() {
		server.stop();
	}

}
