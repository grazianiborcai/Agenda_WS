package br.com.gda.model.checker.common;

import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelChecker;

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
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}
	
	
	
	public int getFailCode() {
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}
}
