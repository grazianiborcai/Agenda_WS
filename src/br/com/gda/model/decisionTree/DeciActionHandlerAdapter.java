package br.com.gda.model.decisionTree;

import java.util.List;

import br.com.gda.common.SystemMessage;

public final class DeciActionHandlerAdapter<T> implements DeciAction<T> {
	private DeciActionHandler<T> handler;
	private List<T> recordInfos;
	
	public DeciActionHandlerAdapter(DeciActionHandler<T> actionHandler, List<T> recordInfos) {
		checkArgument(actionHandler, recordInfos);
		
		handler = actionHandler;
		this.recordInfos = recordInfos;
	}
	
	
	
	private void checkArgument(DeciActionHandler<T> actionHandler, List<T> recordInfos) {
		if (actionHandler == null)
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		
		if (recordInfos == null)
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		
		if (recordInfos.isEmpty())
			throw new NullPointerException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);
	}
	
	
	

	@Override public boolean executeAction() {			
		  handler.executeAction(recordInfos);
		  DeciResult<T> treeResult = handler.getDecisionResult();
		  return treeResult.hasSuccessfullyFinished();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return handler.getDecisionResult();
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<T> actionHandler) {
		throw new IllegalStateException(SystemMessage.NO_IMPLEMENTATION);
	}
}
