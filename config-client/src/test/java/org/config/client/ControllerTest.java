package org.config.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.config.client.controller.TestController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)//1.5版本替换@SpringApplicationConfiguration
@WebAppConfiguration
public class ControllerTest {

	@Autowired
	private TestController testController;
	
	private MockMvc mvc;
	
//	@Value("${spring.datasource.username}")
//	@Value("${spring.cloud.consul.port}")
	private String name;
	
	@Before
	public void setup(){
		mvc=MockMvcBuilders.standaloneSetup(new TestController()).build();
	}
	
//	@Test
	public void test() throws Exception{
		RequestBuilder request=MockMvcRequestBuilders.get("/port");
		mvc.perform(request).andExpect(MockMvcResultMatchers.content()
				.string(Matchers.equalTo("123456")));
	}
	
	@Test
	public void testrt() throws IOException{
		InputStream input=this.getClass().getClassLoader().getResourceAsStream("application.properties");
		Properties p=new Properties();
		p.load(input);
		System.out.println(p.getProperty("spring.cloud.config.profile"));
		System.out.println(name);
	}
}
