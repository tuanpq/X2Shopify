package com.pqt.x2shopify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobResultListener implements JobExecutionListener {

	private static final Logger log = LoggerFactory.getLogger(JobResultListener.class);
		
	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("beforeJob: enter");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("afterJob: enter");
		if (jobExecution.getStatus() == BatchStatus.COMPLETED ) {
			log.info("afterJob: COMPLETED");
	    }
	    else if (jobExecution.getStatus() == BatchStatus.FAILED) {
	    	log.info("afterJob: FAILED");
	    }
	}

}
