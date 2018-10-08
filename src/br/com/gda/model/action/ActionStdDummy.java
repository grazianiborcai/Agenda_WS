package br.com.gda.model.action;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;

public final class ActionStdDummy<T> implements ActionStd<T> {
	private DeciResult<T> deciResult;
	
	public ActionStdDummy(DeciResult<T> decisionResult) {
		checkArgument(decisionResult);
		deciResult = decisionResult;
	}
	
	
	
	private void checkArgument(DeciResult<T> decisionResult) {
		if (decisionResult == null)
			throw new NullPointerException("decisionResult" + SystemMessage.NULL_ARGUMENT);
	}


	
	@Override public boolean executeAction() {
		return deciResult.hasSuccessfullyFinished();
	}

	
	
	@Override public DeciResult<T> getDecisionResult() {
		return deciResult;
	}

	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		throw new IllegalStateException(SystemMessage.NO_IMPLEMENTATION);		
	}
}
