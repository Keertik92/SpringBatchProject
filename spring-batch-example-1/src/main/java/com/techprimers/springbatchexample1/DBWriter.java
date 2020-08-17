package com.techprimers.springbatchexample1;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component 
public class DBWriter implements ItemWriter<User>{

	
	@Autowired 
	UserRepository userRepository;
	
	@Override
	public void write(List<? extends User> users) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("DATA SAVED FOR USERS" + users);
		userRepository.saveAll(users);
	}

}
