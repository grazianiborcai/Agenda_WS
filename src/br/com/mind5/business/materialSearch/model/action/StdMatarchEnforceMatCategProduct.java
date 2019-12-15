package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatarchEnforceMatCategProduct implements ActionStd<MatarchInfo> {
	private ActionStd<MatarchInfo> actionHelper;	
	
	
	public StdMatarchEnforceMatCategProduct(DeciTreeOption<MatarchInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatarchEnforceMatCategProduct());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
