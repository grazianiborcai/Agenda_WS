package br.com.gda.model.action;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
			throwException(new NullPointerException("actionHandler" + SystemMessage.NULL_ARGUMENT));
		
		if (recordInfos == null)
			throwException(new NullPointerException("recordInfos" + SystemMessage.NULL_ARGUMENT));
		
		if (recordInfos.isEmpty())
			throwException(new NullPointerException("recordInfos" + SystemMessage.EMPTY_ARGUMENT));
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
