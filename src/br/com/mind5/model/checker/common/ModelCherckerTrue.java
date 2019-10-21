package br.com.mind5.model.checker.common;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelChecker;

public final class ModelCherckerTrue<T> implements ModelChecker<T> {
	private final boolean RESULT_SUCCESS = true;
	
	public boolean check(List<T> recordInfos) {
		return RESULT_SUCCESS;
	}
	
	
	
	public boolean check(T recordInfo) {
		return RESULT_SUCCESS;
	}
	
	
	
	public boolean getResult() {
		return RESULT_SUCCESS;
	}
	
	
	
	public String getFailMessage() {
		logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}
	
	
	
	public int getFailCode() {
		logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
