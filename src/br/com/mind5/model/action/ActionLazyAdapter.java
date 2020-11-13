package br.com.mind5.model.action;

import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciResult;

final class ActionLazyAdapter<T extends InfoRecord> implements ActionStdV1<T> {
	private ActionLazy<T> handler;
	private List<T> recordInfos;
	
	public ActionLazyAdapter(ActionLazy<T> actionHandler, List<T> recordInfos) {
		checkArgument(actionHandler, recordInfos);
		
		handler = actionHandler;
		this.recordInfos = recordInfos;
	}
	
	
	
	private void checkArgument(ActionLazy<T> actionHandler, List<T> recordInfos) {
		if (actionHandler == null) {
			logException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos == null) {
			logException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfos.isEmpty()) {
			logException(new NullPointerException("recordInfos" + SystemMessage.EMPTY_ARGUMENT));
			throw new NullPointerException("recordInfos" + SystemMessage.EMPTY_ARGUMENT);
		}
	}
	
	
	
	@Override public boolean executeAction() {			
		  handler.executeAction(recordInfos);
		  DeciResult<T> treeResult = handler.getDecisionResult();
		  return treeResult.isSuccess();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return handler.getDecisionResult();
	}
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
		//TODO: implementar esse método
		logException(new IllegalStateException(SystemMessage.NO_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_IMPLEMENTATION);
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}
