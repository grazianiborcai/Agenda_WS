package br.com.gda.business.customer.model.action;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCusValidatePhone1 implements ActionStd<CusInfo> {
	private ActionStd<CusInfo> actionHelper;	
	
	
	public StdCusValidatePhone1(DeciTreeOption<CusInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiCusValidatePhone1(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
	
	
	/*
	@Override protected DeciResult<T> buildResultFailedHook() {
		//Template Method: Default behavior
		return buildResultDataNotFound();
	} */
}
