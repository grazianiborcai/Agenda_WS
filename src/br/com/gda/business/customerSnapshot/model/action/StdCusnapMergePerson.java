package br.com.gda.business.customerSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCusnapMergePerson implements ActionStd<CusnapInfo> {
	private ActionStd<CusnapInfo> actionHelper;	
	
	
	public StdCusnapMergePerson(DeciTreeOption<CusnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCusnapMergePerson(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
