package br.com.gda.business.snapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSnapEnforceLChanged implements ActionStd<SnapInfo> {
	private ActionStd<SnapInfo> actionHelper;	
	
	
	public StdSnapEnforceLChanged(DeciTreeOption<SnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiSnapEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
