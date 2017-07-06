package org.config.client.dataSourceConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties注解绑定属性,prefix为属性名的前缀，如:jdbc.url
@ConfigurationProperties(prefix="jdbc",ignoreUnknownFields=false)
public class DataSourceProperties {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
