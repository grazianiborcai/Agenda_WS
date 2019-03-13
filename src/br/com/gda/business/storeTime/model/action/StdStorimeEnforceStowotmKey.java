package br.com.gda.business.storeTime.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeTime.info.StorimeInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStorimeEnforceStowotmKey implements ActionStd<StorimeInfo> {
	private ActionStd<StorimeInfo> actionHelper;	
	
	
	public StdStorimeEnforceStowotmKey(DeciTreeOption<StorimeInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStorimeEnforceStowotmKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StorimeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorimeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
