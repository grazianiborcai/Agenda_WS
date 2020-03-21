package br.com.mind5.business.personList.model.action;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersolisEnforceRestricted implements ActionStd<PersolisInfo> {
	private ActionStd<PersolisInfo> actionHelper;	
	
	
	public StdPersolisEnforceRestricted(DeciTreeOption<PersolisInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersolisEnforceRestricted());
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
