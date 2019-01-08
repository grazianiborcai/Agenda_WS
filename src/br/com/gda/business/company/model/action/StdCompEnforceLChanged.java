package br.com.gda.business.company.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCompEnforceLChanged implements ActionStd<CompInfo> {
	private ActionStd<CompInfo> actionHelper;	
	
	
	public StdCompEnforceLChanged(DeciTreeOption<CompInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCompEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
