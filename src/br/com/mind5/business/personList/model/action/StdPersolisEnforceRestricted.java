package br.com.mind5.business.personList.model.action;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersolisEnforceRestricted implements ActionStdV1<PersolisInfo> {
	private ActionStdV1<PersolisInfo> actionHelper;	
	
	
	public StdPersolisEnforceRestricted(DeciTreeOption<PersolisInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPersolisEnforceRestricted());
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PersolisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersolisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
