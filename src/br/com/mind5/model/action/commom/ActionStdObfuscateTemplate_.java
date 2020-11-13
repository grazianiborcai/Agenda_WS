package br.com.mind5.model.action.commom;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciResultHelper;

public abstract class ActionStdObfuscateTemplate_<T extends InfoRecord> implements ActionStdV2<T> {
	private ActionStdV2<T> helper;
	
	
	
	public ActionStdObfuscateTemplate_(Class<T> clazz) {
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
	
	
	
	@Override public void addPostAction(ActionLazy<T> actionHandler) {
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
