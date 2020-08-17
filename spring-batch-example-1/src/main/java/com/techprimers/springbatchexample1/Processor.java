package com.techprimers.springbatchexample1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class Processor implements ItemProcessor<User,User>{

	
	private static Map<String, String>  DEPT_NAMES= new HashMap<>();
	public Processor()
	{
	DEPT_NAMES.put("001", "Technology");
	DEPT_NAMES.put("002", "Operations");
	DEPT_NAMES.put("003", "Accounts");
	}
	@Override
	public User process(User user) throws Exception {
		String DeptCode = user.getDept();
		String dept=DEPT_NAMES.get(DeptCode);
		user.setDept(dept);
		
		System.out.println("converted deptCode to deptName");
		return user;
	}

}
