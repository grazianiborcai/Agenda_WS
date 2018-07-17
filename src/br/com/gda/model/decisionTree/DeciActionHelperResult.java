package br.com.gda.model.decisionTree;

import br.com.gda.common.SystemMessage;

public final class DeciActionHelperResult<T> implements DeciAction<T> {
	private DeciResult<T> deciResult;
	
	public DeciActionHelperResult(DeciResult<T> decisionResult) {
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

	
	
	@Override public void addPostAction(DeciActionHandler<T> actionHandler) {
		throw new IllegalStateException(SystemMessage.NO_IMPLEMENTATION);		
	}
}
