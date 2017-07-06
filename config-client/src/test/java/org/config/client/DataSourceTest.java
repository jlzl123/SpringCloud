package org.config.client;

import org.config.client.dataSourceConfig.DataSourceProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration
public class DataSourceTest {

	@Autowired
	private DataSourceProperties dataSource;
	
	@Test
	public void test(){
		System.out.println(dataSource.getUrl());
	}
}
