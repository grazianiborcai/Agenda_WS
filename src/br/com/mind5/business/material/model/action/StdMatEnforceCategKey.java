package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatEnforceCategKey implements ActionStd<MatInfo> {
	private ActionStd<MatInfo> actionHelper;	
	
	
	public StdMatEnforceCategKey(DeciTreeOption<MatInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatEnforceCategKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
