package br.com.gda.business.customer.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdCusMergePerson implements ActionStd<CusInfo> {
	private ActionStd<CusInfo> actionHelper;	
	
	
	public StdCusMergePerson(DeciTreeOption<CusInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCusMergePerson(option.conn, option.schemaName));
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
}
