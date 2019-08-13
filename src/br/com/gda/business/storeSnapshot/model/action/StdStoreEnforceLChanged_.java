package br.com.gda.business.storeSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStoreEnforceLChanged_ implements ActionStd<StorapInfo> {
	private ActionStd<StorapInfo> actionHelper;	
	
	
	public StdStoreEnforceLChanged_(DeciTreeOption<StorapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStoreEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
