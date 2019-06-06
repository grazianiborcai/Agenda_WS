package br.com.gda.business.personList.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersolisEnforceKey implements ActionStd<PersolisInfo> {
	private ActionStd<PersolisInfo> actionHelper;	
	
	
	public StdPersolisEnforceKey(DeciTreeOption<PersolisInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersolisEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PersolisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersolisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
