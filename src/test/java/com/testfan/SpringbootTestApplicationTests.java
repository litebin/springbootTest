package com.testfan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.testfan.model.CaseSystem;
import com.testfan.service.MyTestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTestApplicationTests {

	@Autowired
	MyTestService mytest;
	
	@Test
	public void contextLoads() {
		CaseSystem casesystem = mytest.getById("1100071d-7cdf-434a-bb12-601afa3c0768");
		System.out.println(casesystem);
	}

}
