package br.com.gda.model.decisionTree.common;

import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;

public final class DeciResultInternalError<T> implements DeciResult<T> {
	private final boolean FAILED = false;
	private DeciResultHelper<T> helper;
	
	
	public DeciResultInternalError() {
		helper = new DeciResultHelper<>();
		helper.isSuccess = FAILED;
		helper.failCode = SystemCode.INTERNAL_ERROR;
		helper.failMessage = SystemMessage.INTERNAL_ERROR;
		helper.hasResultset = false;
		helper.resultset = null;
	}

	
	
	@Override public boolean isSuccess() {
		return helper.isSuccess();
	}

	
	
	@Override public String getFailMessage() {
		return helper.getFailMessage();
	}


	
	@Override public int getFailCode() {
		return helper.getFailCode();
	}

	
	@Override public boolean hasResultset() {
		return helper.hasResultset();
	}

	
	
	@Override public List<T> getResultset() {
		return helper.getResultset();
	}
}
