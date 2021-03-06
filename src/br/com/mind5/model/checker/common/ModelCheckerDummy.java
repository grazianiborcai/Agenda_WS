package br.com.mind5.model.checker.common;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.checker.ModelChecker;

public final class ModelCheckerDummy<T extends InfoRecord> implements ModelChecker<T> {
	private final boolean RESULT_SUCCESS = true;	
	
	
	@Override public boolean check(List<T> recordInfos) {
		return RESULT_SUCCESS;
	}
	
	
	
	@Override public boolean check(T recordInfo) {
		return RESULT_SUCCESS;
	}
	
	
	
	@Override public boolean getResult() {
		return RESULT_SUCCESS;
	}
	
	
	
	@Override public String getFailMessage() {
		logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}
	
	
	
	@Override public int getFailCode() {
		logException(new IllegalStateException(SystemMessage.NO_ERROR_FOUND));
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}
	
	
	
	@Override public void close() {
		return;
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
