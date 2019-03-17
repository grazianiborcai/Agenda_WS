package br.com.gda.business.materialMovement.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatmovEnforceKey implements ActionStd<MatmovInfo> {
	private ActionStd<MatmovInfo> actionHelper;	
	
	
	public StdMatmovEnforceKey(DeciTreeOption<MatmovInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiMatmovEnforceKey());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatmovInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmovInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
