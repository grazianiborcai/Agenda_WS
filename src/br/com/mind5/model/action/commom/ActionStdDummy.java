package br.com.mind5.model.action.commom;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;

public final class ActionStdDummy<T extends InfoRecord> implements ActionStd<T> {
	private DeciResult<T> deciResult;
	
	public ActionStdDummy(DeciResult<T> decisionResult) {
		checkArgument(decisionResult);
		deciResult = decisionResult;
	}
	
	
	
	private void checkArgument(DeciResult<T> decisionResult) {
		if (decisionResult == null) {
			logException(new NullPointerException("decisionResult" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("decisionResult" + SystemMessage.NULL_ARGUMENT);
		}
	}


	
	@Override public boolean executeAction() {
		return deciResult.isSuccess();
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		return deciResult;
	}

	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		logException(new IllegalStateException(SystemMessage.NO_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_IMPLEMENTATION);
	}
	
	
	
	@Override public void close() {
		// No action
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
