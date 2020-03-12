package com.udemy.backend.components;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component("taskComponent")
public class TaskComponent {
	
	private static final Log log = LogFactory.getLog(TaskComponent.class);

	@Scheduled(fixedDelay = 5000)
	public void doTask() {
		
		log.info("Time is : " + new Date());
	}
	
}
