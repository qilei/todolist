package test.support.com.voy.todolist.web;

import java.net.MalformedURLException;
import java.net.URL;

public class Routing {
	private String baseUrl;

    public Routing(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public URL toHome() throws MalformedURLException {
        return urlFor("/");
    }

    public URL urlFor(String path) throws MalformedURLException {
        return new URL(baseUrl + path);
    }

}
