package org.config.client.dataSourceConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties注解绑定属性,prefix为属性名的前缀，如:jdbc.url
/*
 * 配置客户端启动，先加载bootstrap.properties配置文件,然后从远程配置仓库获取配置，所以这些配置会优于application.properties
 * 的配置被容器加载，即远程仓库的配置会覆盖掉application的配置。这样，就可以直接把项目配置文件写在远程仓库。
 */
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
