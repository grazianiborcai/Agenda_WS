package br.com.mind5.model.action.commom;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;

public abstract class ActionStdObfuscateTemplate<T extends InfoRecord> implements ActionStdV1<T> {
	private ActionStdV1<T> helper;
	
	
	
	public ActionStdObfuscateTemplate(Class<T> clazz) {
		helper = new ActionStdDummy<>(buildDeciResult(clazz));
	}	
	
	
	
	private DeciResult<T> buildDeciResult(Class<T> clazz) {
		final boolean SUCCESS = true;
		
		DeciResultHelper<T> deciResult = new DeciResultHelper<>();
		deciResult.isSuccess = SUCCESS;
		deciResult.hasResultset = SUCCESS;
		
		T emptyRecord = getNewInstance(clazz);
		
		List<T> dummyResultset = new ArrayList<>();
		dummyResultset.add(emptyRecord);
		deciResult.resultset = dummyResultset;
		
		return deciResult;
	}
	
	
	
	private T getNewInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
			
		} catch (InstantiationException | IllegalAccessException e) {
			logException(e);
			throw new InternalError(e);
		}
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<T> actionHandler) {
		helper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return helper.executeAction();
	}
	
	
	
	@Override public DeciResult<T> getDecisionResult() {
		return helper.getDecisionResult();
	}
	
	
	
	private void logException(Exception e) {		
		SystemLog.logError(this.getClass(), e);
	}
}