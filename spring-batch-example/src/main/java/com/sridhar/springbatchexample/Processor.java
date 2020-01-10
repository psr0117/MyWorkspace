package com.sridhar.springbatchexample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.sridhar.springbatchexample.model.User;

@Component
public class Processor implements ItemProcessor<User, User>{

	private static Map<String, String> DEPT_NAMES = new HashMap<>();
	
	public Processor() {
		DEPT_NAMES.put("001", "Technology");
		DEPT_NAMES.put("002", "Operations");
		DEPT_NAMES.put("003", "Accounts");
		DEPT_NAMES.put("004", "Finance");
		
	}
	@Override
	public User process(User user) throws Exception {
		//convert DeptCode to Dept Name
		String deptCode = user.getDept();
		String deptName = DEPT_NAMES.get(deptCode);
		user.setDept(deptName);
		return user;
		
	}

}
