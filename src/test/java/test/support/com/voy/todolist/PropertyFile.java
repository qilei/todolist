package test.support.com.voy.todolist;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile {
	public static Properties load(String resource){
		return load(resource,Thread.currentThread().getContextClassLoader());
	}

	private static Properties load(String resource, ClassLoader classLoader) {
		InputStream config=classLoader.getResourceAsStream(resource);
		return load(config);
	}

	private static Properties load(InputStream config) {
		Properties properties=new Properties();
		try {
			properties.load(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	private PropertyFile(){}
}
