package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextEnforceKey implements ActionStd<MatextInfo> {
	private ActionStd<MatextInfo> actionHelper;	
	
	
	public StdMatextEnforceKey(DeciTreeOption<MatextInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatextEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
