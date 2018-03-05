package com.mrathena.spring.boot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mrathena.spring.boot.controller.IndexController;

// 引入Spring对JUnit4的支持
@RunWith(SpringRunner.class)
@SpringBootTest
// 开启Web应用的配置, 用于模拟ServletContext
@WebAppConfiguration
public class ApplicationTests {

	// 用于模拟调用Controller的接口发起请求, perform用于请求, andExpect用于判断接口返回的期望值
	private MockMvc mvc;

	@Before
	public void Before() {
		mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}

	@Test
	public void index() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello world")));
	}

}