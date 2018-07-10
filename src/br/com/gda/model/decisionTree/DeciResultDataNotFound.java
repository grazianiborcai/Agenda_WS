package br.com.gda.model.decisionTree;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;

public final class DeciResultDataNotFound<T> implements DeciResult<T> {
	private final boolean FAILED = false;
	
	private DeciResultHelper<T> helper;
	
	
	public DeciResultDataNotFound() {
		buildResultDataNotFound();
	}
	
	
	
	private void buildResultDataNotFound() {
		helper = new DeciResultHelper<>();
		helper.finishedWithSuccess = FAILED;
		helper.failureCode = SystemCode.DATA_NOT_FOUND;
		helper.failureMessage = SystemMessage.DATA_NOT_FOUND;
		helper.hasResultset = false;
		helper.resultset = null;
	}
	
	
	
	
	@Override public boolean hasSuccessfullyFinished() {
		return helper.hasSuccessfullyFinished();
	}

	
	
	@Override public String getFailureMessage() {
		return helper.getFailureMessage();
	}

	
	
	@Override public int getFailureCode() {
		return helper.getFailureCode();
	}

	
	
	@Override public boolean hasResultset() {
		return helper.hasResultset();
	}

	
	
	@Override public List<T> getResultset() {
		return helper.getResultset();
	}
}
