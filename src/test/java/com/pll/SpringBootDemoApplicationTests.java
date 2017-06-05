package com.pll;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	WebApplicationContext webCtx;
	
	MockMvc mockMvc;
	
	@Before
	public void setUP() throws Exception {
//		mockMvc = MockMvcBuilder.webAppContextSetup(mockMvc).build();
	}
	
	
	@Test
	public void contextLoads() {
	}

}
