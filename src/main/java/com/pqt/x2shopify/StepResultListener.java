package com.pqt.x2shopify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepResultListener implements StepExecutionListener {

	private static final Logger log = LoggerFactory.getLogger(StepResultListener.class);
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		log.info("beforeStep: enter");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		log.info("afterStep: enter");
		return stepExecution.getExitStatus();
	}

}
