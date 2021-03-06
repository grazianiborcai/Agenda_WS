package br.com.mind5.model.decisionTree.common;

import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;

public final class DeciResultNotFound<T extends InfoRecord> implements DeciResult<T> {
	private final boolean FAILED = false;
	private DeciResultHelper<T> helper;
	
	
	public DeciResultNotFound() {
		helper = new DeciResultHelper<>();
		helper.isSuccess = FAILED;
		helper.failCode = SystemCode.DATA_NOT_FOUND;
		helper.failMessage = SystemMessage.DATA_NOT_FOUND;
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
