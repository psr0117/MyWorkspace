package com.sridhar.springbatchexample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class JobController {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job myjob;
	
	@GetMapping
	public BatchStatus load() throws JobExecutionException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		Map<String, JobParameter> maps = new HashMap<String, JobParameter>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		
		JobParameters jobParameters = new JobParameters(maps);
		JobExecution jobExecution = (JobExecution) jobLauncher.run(myjob, jobParameters);
		System.out.println("Job Execution Status : " + jobExecution.getStatus());
		
		while (jobExecution.isRunning()) {
			System.out.println("Batch is Running ..... ");
		}
		return jobExecution.getStatus();
		
	 
	}
}
