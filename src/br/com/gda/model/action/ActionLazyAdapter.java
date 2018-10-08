package br.com.gda.model.action;

import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.model.decisionTree.DeciResult;

final class ActionLazyAdapter<T> implements ActionStd<T> {
	private ActionLazy<T> handler;
	private List<T> recordInfos;
	
	public ActionLazyAdapter(ActionLazy<T> actionHandler, List<T> recordInfos) {
		checkArgument(actionHandler, recordInfos);
		
		handler = actionHandler;
		this.recordInfos = recordInfos;
	}
	
	
	
	private void checkArgument(ActionLazy<T> actionHandler, List<T> recordInfos) {
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
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		//TODO: implementar esse método
		throw new IllegalStateException(SystemMessage.NO_IMPLEMENTATION);
	}
}
