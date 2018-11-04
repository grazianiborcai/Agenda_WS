package br.com.gda.model.action.commom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.decisionTree.DeciResult;

public final class ActionStdDummy<T> implements ActionStd<T> {
	private DeciResult<T> deciResult;
	
	public ActionStdDummy(DeciResult<T> decisionResult) {
		checkArgument(decisionResult);
		deciResult = decisionResult;
	}
	
	
	
	private void checkArgument(DeciResult<T> decisionResult) {
		if (decisionResult == null)
			throwException(new NullPointerException("decisionResult" + SystemMessage.NULL_ARGUMENT));
	}


	
	@Override public boolean executeAction() {
		return deciResult.isSuccess();
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		return deciResult;
	}

	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		throwException(new IllegalStateException(SystemMessage.NO_IMPLEMENTATION));		
	}
	
	
	
	private void throwException(Exception e) {
		try {
			logException(e);
			throw e;
			
		} catch (Exception e1) {
			logException(new IllegalArgumentException(SystemMessage.WRONG_EXCEPTION));
			throw new IllegalArgumentException(SystemMessage.WRONG_EXCEPTION);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
