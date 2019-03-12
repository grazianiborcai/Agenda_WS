package br.com.gda.business.storeWorkTime.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStowotmEnforceLChanged implements ActionStd<StowotmInfo> {
	private ActionStd<StowotmInfo> actionHelper;	
	
	
	public StdStowotmEnforceLChanged(DeciTreeOption<StowotmInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiStowotmEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StowotmInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StowotmInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
