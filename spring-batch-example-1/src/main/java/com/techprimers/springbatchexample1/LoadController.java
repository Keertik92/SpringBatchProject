package com.techprimers.springbatchexample1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJpaRepositories(basePackages = "repository", considerNestedRepositories = true)
//@RequestMapping("/load")
public class LoadController {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@GetMapping("/load")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		Map<String , JobParameter> maps= new HashMap<>();
		maps.put("time" , new JobParameter(System.currentTimeMillis()));
		
		JobParameters jobParameters =new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		
		
		System.out.println("status of the job "+ jobExecution.getStatus());
		
		System.out.println("Batch is running .....");
		
		while(jobExecution.isRunning())
		{
			
		System.out.println("....");
		}
		
		return jobExecution.getStatus();
		
	}
	
	
	
}
